package testes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeitura {
	// public static void main(String[] args) throws FileNotFoundException {
	// FileNotFoundException extende de IOException, então podemos fazer assim:
	public static void main(String[] args) throws IOException {
		// Fluxo de entrada com arquivo:
		FileInputStream fis = new FileInputStream("lorem.txt");
		// InputStream fis = new FileInputStream("lorem.txt"); // polimorfismo
		// Reader isr = new InputStreamReader(fis);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String linha = br.readLine();

		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		br.close();
	}
}
