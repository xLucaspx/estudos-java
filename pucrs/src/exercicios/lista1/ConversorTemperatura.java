package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class ConversorTemperatura extends RunnableExercise {
	public ConversorTemperatura() {
		super("Lista I", 6, "Conversor Fahrenheit -> Celsius");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Double fahrenheit = null;

		do {
			try {
				System.out.println("\nVamos converter um a temperatura em °F para °C");

				System.out.print("Digite uma temperatura em graus Fahrenheit: ");
				fahrenheit = Double.parseDouble(in.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (fahrenheit == null);

		System.out.printf("%n%.2f°F = %.2f°C%n%n", fahrenheit, converteFahrenheitParaCelsius(fahrenheit));
	}

	private double converteFahrenheitParaCelsius(double fahrenheit) {
		return 5.0 / 9.0 * (fahrenheit - 32);
	}

	private double converteCelsiusParaFahrenheit(double celsius) {
		return 32 + (9.0 / 5.0 * celsius);
	}
}
