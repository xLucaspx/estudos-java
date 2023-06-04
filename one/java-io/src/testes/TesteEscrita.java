package testes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TesteEscrita {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("lorem.txt");
		// OutputStream fis = new FileOutputStream("lorem.txt"); // polimorfismo
		// Writer isr = new OutputStreamWriter(fis);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("Lorem ipsum dolor sit amet...");
		bw.newLine();
		bw.write("teste escrita arquivo novo");

		bw.close();
	}
}
