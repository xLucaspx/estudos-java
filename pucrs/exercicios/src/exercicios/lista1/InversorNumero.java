package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class InversorNumero extends RunnableExercise {
	public InversorNumero() {
		super("Lista I", 11, "Inverte número");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Integer num = null;

		do {
			try {
				System.out.println("\nVamos inverter, de forma matemática, um inteiro de 4 dígitos");

				System.out.print("Digite o valor a ser invertido: ");
				num = Integer.parseInt(in.nextLine());

				if (num < 1000 || num > 9999) {
					System.err.println("O número deve ter quatro dígitos, ou seja, precisa estar entre 1000 e 9999!");
					num = null;
				}
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (num == null);

		System.out.printf("%nO inverso de %d é %d%n%n", num, inverteNumero(num));
	}

	private int inverteNumero(int numero) {
		var inverso = 0;

		while (numero > 0) {
			var ultimoDigito = numero % 10;
			inverso = inverso * 10 + ultimoDigito;
			numero /= 10;
		}

		return inverso;
	}
}
