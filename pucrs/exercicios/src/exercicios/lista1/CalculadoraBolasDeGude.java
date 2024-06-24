package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraBolasDeGude extends RunnableExercise {
	private static final double CAPACIDADE_CAIXA = 100.0;

	public CalculadoraBolasDeGude() {
		super("Lista I", 21, "Calcula quantas caixas são necessárias para guardar determinada quantidade de bolas de " +
												 "gude");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);

		var quantidadeBolinhas = 0;

		do {
			try {
				System.out.printf("Cada caixa tem capacidade para %.0f bolinhas%n%n", CAPACIDADE_CAIXA);

				System.out.print("Digite a quantidade de bolinhas: ");
				quantidadeBolinhas = Integer.parseInt(in.nextLine());

				if (quantidadeBolinhas <= 0) {
					throw new IllegalArgumentException("A quantidade de bolinhas deve ser maior do que 0!");
				}
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (quantidadeBolinhas <= 0);

		var caixasNecessarias = (int) Math.ceil(quantidadeBolinhas / CAPACIDADE_CAIXA);

		System.out.printf(
			"%nPara armazenar %d bolinha(s) em caixas com capacidade para %.0f serão necessárias %d caixa(s)%n%n",
			quantidadeBolinhas,
			CAPACIDADE_CAIXA,
			caixasNecessarias
		);
	}
}
