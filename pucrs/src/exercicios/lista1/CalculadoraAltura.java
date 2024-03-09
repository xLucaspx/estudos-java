package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraAltura extends RunnableExercise {
	public CalculadoraAltura() {
		super("Lista I", 9, "Escreve a altura de uma pessoa em centímetros e milímetros");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Double altura = null;

		do {
			try {
				System.out.println("\nVamos converter uma altura para centímetros e milímetros");

				System.out.print("Digite uma altura em metros: ");
				altura = Double.parseDouble(in.nextLine());

				if (altura < 1 || altura > 2.3) {
					System.err.println("A altura deve estar entre 1 m e 2.3 m");
					altura = null;
				}

			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (altura == null);

		System.out.printf("%n%.2f m = %.2f cm%n", altura, converteMetrosParaCentimetros(altura));
		System.out.printf("%.2f m = %.2f mm%n%n", altura, converteMetrosParaMilimetros(altura));
	}

	private double converteMetrosParaCentimetros(double metros) {
		return metros * 100.0;
	}

	private double converteMetrosParaMilimetros(double metros) {
		return metros * 1000.0;
	}
}
