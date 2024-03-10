package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraDinheiro extends RunnableExercise {
	public CalculadoraDinheiro() {
		super("Lista I", 12, "Decompõe um quantia em reais");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Integer valor = null;

		do {
			try {
				System.out.println("\nVamos decompor um valor inteiro em reais");

				System.out.print("Digite o valor: ");
				valor = Integer.parseInt(in.nextLine());

				if (valor <= 0) {
					System.err.println("O valor deve ser maior do que zero!");
					valor = null;
				}
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (valor == null);

		System.out.printf("%nR$ %d equivalem a:%n%s%n", valor, decompoeQuantiaEmReais(valor));
	}

	private String decompoeQuantiaEmReais(int valor) {
		int[] notas = {100, 50, 20, 10, 5, 2, 1};
		var strNotas = new StringBuilder();

		for (var nota : notas) {
			int quantidadeNota = valor / nota; // parte inteira da divisão do valor pela nota
			valor %= nota; // valor atualizado para ser o resto após a retirada das notas já contabilizadas

			if (nota == 1) {
				strNotas.append("%d moeda(s) de R$ %d%n".formatted(quantidadeNota, nota));
				continue;
			}

			strNotas.append("%d nota(s) de R$ %d%n".formatted(quantidadeNota, nota));
		}
		return strNotas.toString();
	}
}
