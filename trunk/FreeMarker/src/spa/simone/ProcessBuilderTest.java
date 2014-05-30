package spa.simone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		create();
		clean();
	}

	private static void clean() {
		File aux = new File("test/testo.aux");
		File log = new File("test/testo.log");
		aux.delete();
		log.delete();
	}

	private static void create() throws IOException, InterruptedException {
		List<String> command = new ArrayList<String>();
		command.add("miktex/miktex/bin/pdflatex.exe");
		command.add("-output-directory=test");
		command.add("-quiet");
		command.add("test/testo.tex");
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();
		process.waitFor();
		process.destroy();
	}

}