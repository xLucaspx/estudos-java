package testes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeitura2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("contas.csv"), "UTF-8");

		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			// System.out.println(linha);

			Scanner scannerLinha = new Scanner(linha);
			scannerLinha.useLocale(Locale.US); // para evitar input mismatch exception
			scannerLinha.useDelimiter(",");

			String tipo = scannerLinha.next();
			int agencia = scannerLinha.nextInt();
			int numero = scannerLinha.nextInt();
			String titular = scannerLinha.next();
			double saldo = scannerLinha.nextDouble();

			// String valorFormatado = String.format(new Locale("pt", "BR"), "Tipo: %s,
			// agência: %04d, número: %05d, titular: %s, saldo R$ %.2f %n", tipo, agencia,
			// numero, titular, saldo);
			// System.out.println(valorFormatado);

			System.out.format(new Locale("pt", "BR"),
					"Tipo: %s, agência: %04d, número: %05d, titular: %s, saldo R$ %.2f %n", tipo, agencia, numero,
					titular, saldo);

			// System.out.println(tipo + " " + agencia + " " + numero + " " + titular + " "
			// + saldo);

			scannerLinha.close();

			// String[] valores = linha.split(",");
			// System.out.println(Arrays.toString(valores));
			// System.out.println("Titular: " + valores[3]);
		}
		scanner.close();
	}
}
