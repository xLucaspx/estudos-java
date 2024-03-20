package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraIngressoTeatro extends RunnableExercise {

	private static final double ALTURA_MINIMA_PESSOA = 1.0;
	private static final double ALTURA_MAXIMA_PESSOA = 2.3;

	public CalculadoraIngressoTeatro() {
		super("Lista I", 22, "Calcular o valor do ingresso de um espetáculo");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);

		var gastosElenco = 0.0;
		var gastosTecnicos = 0.0;
		var aluguelTeatro = 0.0;

		var percentualLucroDesejado = 0.0;
		var percentualOcupacaoEsperado = 0.0;

		var lotacaoTeatro = 0;
		var quantidadeEspetaculos = 0;

		var validData = false;

		do {
			try {
				System.out.println(
					"Vamos calcular, com base no custo e nos valores esperados, o preço do ingresso de um espetáculo!\n");

				System.out.print("Insira a lotação máxima do teatro: ");
				lotacaoTeatro = leIntMaiorQue0(in);

				System.out.println("\nCusto do espetáculo");

				System.out.print("	Gastos com elenco: ");
				gastosElenco = leDoubleMaiorQue0(in);

				System.out.print("	Gastos técnicos: ");
				gastosTecnicos = leDoubleMaiorQue0(in);

				System.out.print("	Aluguel do teatro: ");
				aluguelTeatro = leDoubleMaiorQue0(in);

				System.out.println("\nValores esperados");

				System.out.print("	Percentual de lucro desejado: ");
				percentualLucroDesejado = leDoubleMaiorQue0(in) / 100;

				System.out.print("	Percenual de ocupação estimado: ");
				percentualOcupacaoEsperado = leDoubleMaiorQue0(in) / 100;

				System.out.print("	Quantidade de espetáculos que será realizada: ");
				quantidadeEspetaculos = leIntMaiorQue0(in);

				validData = true; // se chegar até aqui, os dados são válidos
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (!validData);

		var custoTotal = gastosElenco + gastosTecnicos + aluguelTeatro;
		var valorEsperado = custoTotal + custoTotal * percentualLucroDesejado;

		var valorEsperadoPorNoite = valorEsperado / quantidadeEspetaculos;
		var lotacaoTotalPorNoite = Math.round(lotacaoTeatro * percentualOcupacaoEsperado);

		var precoIngresso = valorEsperadoPorNoite / lotacaoTotalPorNoite;

		System.out.printf("%nO custo do espetáculo ficou estimado em R$ %.2f%n", custoTotal);
		System.out.printf("Para atingir o lucro desejado de %.0f%%, será preciso arrecadar R$ %.2f%n",
			(percentualLucroDesejado * 100),
			valorEsperado
		);
		System.out.printf("Realizando %d espetáculos, será necessário arrecadar R$ %.2f por espetáculo%n",
			quantidadeEspetaculos,
			valorEsperadoPorNoite
		);
		System.out.printf("Com a lotação esperada de %.0f%%, há %d lugares disponíveis%n",
			(percentualOcupacaoEsperado * 100),
			lotacaoTotalPorNoite
		);
		System.out.printf("Com isso, o preço médio de cada ingresso deve ser R$ %.2f%n%n", precoIngresso);
	}

	private double leDoubleMaiorQue0(Scanner in) {
		var numero = Double.parseDouble(in.nextLine());

		if (numero <= 0) {
			throw new IllegalArgumentException("Os valores devem ser maiores do que 0");
		}

		return numero;
	}

	private int leIntMaiorQue0(Scanner in) {
		var numero = Integer.parseInt(in.nextLine());

		if (numero <= 0) {
			throw new IllegalArgumentException("Os valores devem ser maiores do que 0");
		}

		return numero;
	}
}
