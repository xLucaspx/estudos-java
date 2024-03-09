package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class Calculadora extends RunnableExercise {

	public Calculadora() {
		super("Lista I", 7, "Soma, diferença, média, distância, maior e menor");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Integer x = null;
		Integer y = null;

		do {
			try {
				System.out.println(
					"\nVamos calcular soma, diferença, média, distância (valor absoluto da diferença), o maior e o menor entre " + "dois inteiros");

				System.out.print("Digite o primeiro valor: ");
				x = Integer.parseInt(in.nextLine());

				System.out.print("Digite o segundo valor: ");
				y = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (x == null || y == null);

		System.out.printf("%n%d + %s = %d%n", x, (y < 0 ? "(" + y + ")" : y), soma(x, y));
		System.out.printf("%d - %s = %d%n", x, (y < 0 ? "(" + y + ")" : y), subtrai(x, y));
		System.out.printf("Média de %d e %d = %.1f%n", x, y, calculaMedia(x, y));
		System.out.printf("Distância entre %d e %d = %d%n", x, y, calculaDistancia(x, y));
		System.out.printf("Maior entre %d e %d = %d%n", x, y, retornaMaior(x, y));
		System.out.printf("Menor entre %d e %d = %d%n%n", x, y, retornaMenor(x, y));
	}

	private int soma(int x, int y) {
		return x + y;
	}

	private int subtrai(int x, int y) {
		return x - y;
	}

	private int calculaDistancia(int x, int y) {
		return Math.abs(x - y);
	}

	private double calculaMedia(int x, int y) {
		return (x + y) / 2.0;
	}

	private int retornaMaior(int x, int y) {
		// return (x + y + Math.abs(x - y)) / 2;

		return Math.max(x, y);
	}

	private int retornaMenor(int x, int y) {
		// return (x + y - Math.abs(x - y)) / 2;

		return Math.min(x, y);
	}
}
