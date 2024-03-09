package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraPotencia extends RunnableExercise {

	public CalculadoraPotencia() {
		super("Lista I", 5, "Calcular potência");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Integer n = null;

		do {
			try {
				System.out.println("\nVamos calcular um número elevado a 2ª, 3ª e 4ª potência");

				System.out.print("Digite um valor inteiro a ser calculado: ");
				n = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (n == null);

		System.out.printf("%n%d² = %.0f%n", n, Math.pow(n, 2));
		System.out.printf("%d³ = %.0f%n", n, Math.pow(n, 3));
		System.out.printf("%d⁴ = %.0f%n%n", n, Math.pow(n, 4));
	}
}
