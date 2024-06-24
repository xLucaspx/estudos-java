package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraAreaTerreno extends RunnableExercise {

	public CalculadoraAreaTerreno() {
		super("Lista I", 8, "Calcula a área livre em um terreno");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		double larguraTerreno;
		double comprimentoTerreno;
		double larguraCasa;
		double comprimentoCasa;
		var areaCasa = 0.0;
		var areaTerreno = 0.0;
		var validData = false;

		do {
			try {
				System.out.println("\nVamos calcular a área livre em um terreno com uma construção");
				System.out.println("Dimensões do terreno");

				System.out.print("Largura: ");
				larguraTerreno = leMedida(in);
				System.out.print("Comprimento: ");
				comprimentoTerreno = leMedida(in);

				System.out.println("\nDimensões da construção");

				System.out.print("Largura: ");
				larguraCasa = leMedida(in);
				System.out.print("Comprimento: ");
				comprimentoCasa = leMedida(in);

				areaCasa = calculaArea(larguraCasa, comprimentoCasa);
				areaTerreno = calculaArea(larguraTerreno, comprimentoTerreno);

				validData = areaCasa <= areaTerreno;

				if (!validData) {
					System.err.println("A área da construção não pode ser maior do que a área do terreno");
				}
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (!validData);

		System.out.printf("%nÁrea do terreno = %.2f m²%n", areaTerreno);
		System.out.printf("Área da construção = %.2f m²%n", areaCasa);
		System.out.printf("Área livre = %.2f m²%n%n", (areaTerreno - areaCasa));
	}

	private double calculaArea(double x, double y) {
		return x * y;
	}

	private double leMedida(Scanner in) {
		var medida = Double.parseDouble(in.nextLine());

		if (medida <= 0) {
			throw new IllegalArgumentException("As medidas deve ser maiores que 0!");
		}

		return medida;
	}
}
