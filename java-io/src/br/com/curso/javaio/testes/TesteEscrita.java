package br.com.curso.javaio.testes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TesteEscrita {
	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("lorem2 .txt");
//		OutputStream fis = new FileOutputStream("lorem.txt"); // polimorfismo
//		Writer isr = new OutputStreamWriter(fis);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("Lorem ipsum et sit, e coisa, e tal.");
		bw.newLine();
		bw.write("teste escrita arquivo novo");

		bw.close();
	}
}