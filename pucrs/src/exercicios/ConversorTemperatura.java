package exercicios;

public class ConversorTemperatura {
	public static double converteFahrenheitParaCelsius(double fahrenheit) {
		return 5.0 / 9.0 * (fahrenheit - 32);
	}

	public static double converteCelsiusParaFahrenheit(double celsius) {
		return 32 + (9.0/5.0 * celsius);
	}
}
