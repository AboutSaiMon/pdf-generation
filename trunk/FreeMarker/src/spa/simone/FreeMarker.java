package spa.simone;

import static spa.simone.util.EntityType.FASCIA;
import static spa.simone.util.EntityType.ILLUMINAZIONE_PUBBLICA;
import static spa.simone.util.EntityType.TIPO_CLIENTE;
import static spa.simone.util.TipoCliente.INDIVIDUALE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	private static Configuration cfg;
	private static Template template;
	private static FileWriter writer;
	private static File tmp;
	private static File output;

	// File tmpDir =
	// (File)getServletContext().getAttribute(ServletContext.TEMPDIR);
	public static void main(String[] args) {
		cfg = new Configuration();
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put(TIPO_CLIENTE.toString(), INDIVIDUALE);
			model.put(FASCIA.toString(), Fascia.MONO);
			model.put(ILLUMINAZIONE_PUBBLICA.toString(), IlluminazionePubblica.NO);
			model.put(EntityType.CLIENTE_BEAN.toString(), getClienteIndividuale());

			tmp = new File("output/contratto.tmp");
			output = new File("output/contratto.tex");

			template = cfg.getTemplate("contratto/power/template.ltf");
			writer = new FileWriter(tmp);
			template.process(model, writer);

			template = cfg.getTemplate("output/contratto.tmp");
			writer = new FileWriter(output);
			template.process(model, writer);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				create(output);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				clean();
			}
		}
	}

	private static void clean() {
		File dir = new File("output");
		for (File file : dir.listFiles()) {
			String fileName = file.getName().trim();
			if (!fileName.endsWith(".pdf")) {
				file.deleteOnExit();
			}
		}
	}

	private static void create(File output) throws IOException, InterruptedException {
		List<String> command = new ArrayList<String>();
		command.add("miktex/miktex/bin/pdflatex.exe");
		command.add("-output-directory=output");
		command.add("-quiet");
		command.add("output/" + output.getName());
		System.out.println(command.get(3));
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();
		process.waitFor();
		process.destroy();
	}

	public static Cliente getClienteIndividuale() {
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