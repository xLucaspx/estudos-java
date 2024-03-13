package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraAreaEsfera extends RunnableExercise {

	public CalculadoraAreaEsfera() {
		super("Lista I", 4, "Calcular área da esfera");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Double raio = null;

		do {
			try {
				System.out.println("\nVamos calcular a área de uma esfera utilizando a fórmula 4πr²");

				System.out.print("Digite o valor do raio (r): ");
				raio = Double.parseDouble(in.nextLine());

				if (raio <= 0) {
					System.err.println("O valor do raio deve ser maior do que 0!");
					raio = null;
				}

			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (raio == null);

		System.out.printf("a = %.2f%n%n", calculaAreaEsfera(raio));
	}

	private double calculaAreaEsfera(double raio) {
		return 4 * Math.PI * Math.pow(raio, 2);
	}
}
