package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class CalculadoraVolumeGarrafa extends RunnableExercise {
	public CalculadoraVolumeGarrafa() {
		super("Lista I", 17, "Calcular o volume de uma garrafa");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);

		var raioBase = 0.0;
		var raioGargalo = 0.0;
		var alturaCorpo = 0.0;
		var alturaGargalo = 0.0;
		var alturaCone = 0.0;

		var validData = false;

		do {
			try {
				System.out.println(
					"\nVamos calcular o volume de uma garrafa; para isso, precisamos do raio da base e do gargalo (r1 e r2) e " + "da" + " " + "altura do corpo (h1), do gargalo (h2) e do cone que os une (h3)");

				System.out.print("Digite o valor em centímetros do raio da base (r1): ");
				raioBase = leMedida(in);

				System.out.print("Digite o valor em centímetros do raio do gargalo (r2): ");
				raioGargalo = leMedida(in);

				System.out.print("Digite o valor em centímetros da altura do corpo (h1): ");
				alturaCorpo = leMedida(in);

				System.out.print("Digite o valor em centímetros da altura do gargalo (h2): ");
				alturaGargalo = leMedida(in);

				System.out.print("Digite o valor em centímetros da altura do cone que liga o corpo ao gargalo (h3): ");
				alturaCone = leMedida(in);

				validData = true; // se chegar aqui, os dados são válidos
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (!validData);

		var volumeCorpo = calculaVolumeCilindro(raioBase, alturaCorpo);
		var volumeGargalo = calculaVolumeCilindro(raioGargalo, alturaGargalo);
		var volumeCone = calculaVolumeCone(raioBase, raioGargalo, alturaCone);
		var volumeGarrafa = volumeCorpo + volumeGargalo + volumeCone;

		System.out.printf("%nVolume do corpo = %.2f cm³%n", volumeCorpo);
		System.out.printf("Volume do gargalo = %.2f cm³%n", volumeGargalo);
		System.out.printf("Volume do cone = %.2f cm³%n", volumeCone);
		System.out.printf("Volume da garrafa = %.2f cm³%n%n", volumeGarrafa);
	}

	private double calculaVolumeCone(double r1, double r2, double h) {
		// (r1² + r1 * r2 + r2²) * h
		var expression = (Math.pow(r1, 2) + r1 * r2 + Math.pow(r2, 2)) * h;

		return Math.PI * expression / 3;
	}

	private double calculaVolumeCilindro(double raio, double altura) {
		return Math.PI * Math.pow(raio, 2) * altura;
	}

	private double leMedida(Scanner in) {
		var medida = Double.parseDouble(in.nextLine());

		if (medida <= 0) {
			throw new IllegalArgumentException("As medidas deve ser maiores que 0!");
		}

		return medida;
	}
}
