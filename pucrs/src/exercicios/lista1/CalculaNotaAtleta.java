package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculaNotaAtleta extends RunnableExercise {
	public CalculaNotaAtleta() {
		super("Lista I", 19, "Calcula a nota de um atleta");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		var notaBancaA = 0.0;
		var notasBancaB = new double[6];
		var validData = false;

		do {
			try {
				System.out.println("""

					Vamos calcular a nota de um atleta; para isso, insira a nota da banca A e a nota de cada jurado da banca B
					Para a banca B, serão descartadas a nota mais alta e a mais baixa e será feita a média das notas restantes""");

				System.out.print("Digite a nota da banca A: ");
				notaBancaA = leNota(in);

				for (var i = 0; i < notasBancaB.length; i++) {
					System.out.printf("Digite a nota %d da banca B: ", (i + 1));
					notasBancaB[i] = leNota(in);
				}

				validData = true;
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (!validData);

		var resultadoBancaB = calculaNotaBancaB(notasBancaB);
		var menorNotaBancaB = resultadoBancaB[0];
		var maiorNotaBancaB = resultadoBancaB[1];
		var notaFinalBancaB = resultadoBancaB[2];

		System.out.printf("%nNota da banca A: %.2f%n", notaBancaA);
		System.out.printf("%nNotas da banca B:%n");
		System.out.printf("	Menor nota (desconsiderada): %.2f%n", menorNotaBancaB);
		System.out.printf("	Maior nota (desconsiderada): %.2f%n", maiorNotaBancaB);
		System.out.printf("	Média das notas restantes: %.2f%n", notaFinalBancaB);
		System.out.printf("%nNota final: %.2f%n%n", notaBancaA + notaFinalBancaB);
	}

	private double leNota(Scanner in) {
		var nota = Double.parseDouble(in.nextLine());

		if (nota < 0) {
			throw new IllegalArgumentException("A nota não pode ser menor do que 0");
		}
		return nota;
	}

	/**
	 * Recebe um array de double representando as notas, remove a maior e a menor nota e faz a média das notas restantes
	 *
	 * @param notas um array de double contendo as notas
	 * @return um array de double de 3 posições contendo a menor nota no índice 0, a maior nota no índice 1 e a média
	 * das notas restantes no índice 2
	 */
	private double[] calculaNotaBancaB(double... notas) {
		var maiorNota = notas[0];
		var menorNota = notas[0];
		var sum = 0.0;

		for (var nota : notas) {
			if (nota > maiorNota) {
				maiorNota = nota;
			}

			if (nota < menorNota) {
				menorNota = nota;
			}

			sum += nota;
		}

		var media = (sum - maiorNota - menorNota) / (notas.length - 2);

		return new double[]{menorNota, maiorNota, media};
	}
}
