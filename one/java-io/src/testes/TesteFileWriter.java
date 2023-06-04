package testes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteFileWriter {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("lorem2.txt");
		fw.write("teste file writer para escrever em novo arquivo");
		fw.write("\n"); // quebra de linha
		fw.write("não sei se funcionou; será?");
		fw.write(System.lineSeparator()); // quebra de linha

		// Outra forma, um pouco melhor:
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write("mais novo teste do momento");
		bw.newLine(); // usa o System.lineSeparator por baixo dos panos
		bw.write("Qual será o resultado final?");

		bw.close();
	}
}
