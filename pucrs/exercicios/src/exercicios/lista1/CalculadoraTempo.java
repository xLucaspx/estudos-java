package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraTempo extends RunnableExercise {
	public CalculadoraTempo() {
		super("Lista I", 10, "Converte tempo em segundos para hh:MM:ss");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Integer tempo = null;

		do {
			try {
				System.out.println("\nVamos converter um tempo em segundos para horas, minutos e segundos");

				System.out.print("Digite o tempo em segundos: ");
				tempo = Integer.parseInt(in.nextLine());

				if (tempo <= 0) {
					System.err.println("O tempo deve ser maior do que zero!");
					tempo = null;
				}
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (tempo == null);

		System.out.printf("%n%d segundos equivalem a %s%n%n", tempo, decompoeTempoEmSegundos(tempo));
	}

	private String decompoeTempoEmSegundos(int tempo) {
		// HORAS = quociente inteiro do valor dividido por 3600
		var horas = tempo / 3600;
		// MINUTOS = quociente inteiro da divisão do resto do valor dividido por 3600 por 60
		var minutos = (tempo % 3600) / 60;
		// SEGUNDOS = resto inteiro da divisão do valor dividido por 60
		var segundos = tempo % 60;

		return "%02dH:%02dM:%02dS".formatted(horas, minutos, segundos);
	}
}
