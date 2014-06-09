package spa.simone;

import static spa.simone.util.EntityType.FASCIA;
import static spa.simone.util.EntityType.ILLUMINAZIONE_PUBBLICA;
import static spa.simone.util.EntityType.TIPO_CLIENTE;
import static spa.simone.util.TipoCliente.INDIVIDUALE;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spa.simone.model.Cliente;
import spa.simone.model.ClienteIndividuale;
import spa.simone.util.EntityType;
import spa.simone.util.Fascia;
import spa.simone.util.IlluminazionePubblica;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarker {

	public static void main(String[] args) {
		String latexSource = createLatexSource();
		createPdf(normalize(latexSource));
		clean("output/article");
	}

	public static String createLatexSource() {
		Configuration cfg = new Configuration();
		StringReader reader = null;
		StringWriter tempWriter = new StringWriter();
		StringWriter latexWriter = new StringWriter();
		String latexSource = null;
		try {
			// Crea il modello
			Map<String, Object> model = new HashMap<String, Object>();
			model.put(TIPO_CLIENTE.toString(), INDIVIDUALE);
			model.put(FASCIA.toString(), Fascia.MONO);
			model.put(ILLUMINAZIONE_PUBBLICA.toString(), IlluminazionePubblica.NO);
			model.put(EntityType.CLIENTE_BEAN.toString(), getClienteIndividuale());
			// FASE 1: Legge il template e genera il file latex parziale
			Template template = cfg.getTemplate("contratto/power/template.ltf");
			template.process(model, tempWriter);
			// FASE 2: Legge il sorgente latex parziale dalla memoria e genera il
			// sorgente finale
			reader = new StringReader(tempWriter.toString());
			template = new Template("power", reader, cfg);
			template.process(model, latexWriter);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			try {
				tempWriter.flush();
				tempWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			latexSource = latexWriter.toString();
			try {
				latexWriter.flush();
				latexWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return latexSource;
	}

	public static String normalize(String input) {
		return input.replaceAll("[\\n\\r\\f]", "");
	}

	public static void createPdf(String latexSource) {
		List<String> command = new ArrayList<String>();
		command.add("miktex\\miktex\\bin\\pdflatex.exe");
		command.add("-output-directory=output");
		command.add("-quiet");
		command.add(latexSource);
		for (String s : command) {
			System.out.print(s + " ");
		}
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = null;
		try {
			process = builder.start();
			process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (process != null) {
				process.destroy();
			}
		}
	}

	public static void clean(String sourceName) {
		File aux = new File(sourceName + ".aux");
		aux.delete();
		File log = new File(sourceName + ".log");
		log.delete();
		File tex = new File(sourceName + ".tex");
		tex.delete();
	}

	private static Cliente getClienteIndividuale() {
		ClienteIndividuale c = new ClienteIndividuale();
		c.setCapitaleSociale("39.3009");
		c.setCitt‡SedeLegale("MILANO");
		c.setCodiceFiscale("CODICE FISCALE");
		c.setNome("TRIVAGO");
		c.setPartitaIva("PARTITA IVA");
		c.setProvinciaSedeLegale("MI");
		c.setRagioneSociale("RAGIONE SOCIALE");
		c.setRappresentanteLegale("IVAN CATOZZO");
		c.setRegistroImprese("MILANO");
		c.setTipoRappresentanza("AMMINISTRATORE UNICO");
		c.setViaSedeLegale("VIA CARDUCCI 7");
		return c;
	}

}