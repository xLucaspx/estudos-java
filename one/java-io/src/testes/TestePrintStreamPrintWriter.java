package testes;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TestePrintStreamPrintWriter {
	public static void main(String[] args) throws IOException {
		// PrintStream ps = new PrintStream("lorem4.txt");
		PrintStream ps = new PrintStream(new File("lorem3.txt"));

		ps.println("teste print stream");
		ps.println();
		ps.println("será que funcionou?");

		ps.close();

		PrintWriter pw = new PrintWriter("lorem4.txt");

		pw.println("teste print writer");
		pw.println();
		pw.println("Será que funcionou?");

		pw.close();
	}
}
