package exercicios;

public class Calculadora {

	public static double soma(double x, double y) {
		return x + y;
	}

	public static double subtrai(double x, double y) {
		return x - y;
	}

	public static double calculaMedia(double x, double y) {
		return (x + y) / 2;
	}

	public static double retornaMaior(double x, double y) {
		// return (x + y + Math.abs(x - y)) / 2;

		return Math.max(x, y);
	}

	public static double retornaMenor(double x, double y) {
		// return (x + y - Math.abs(x - y)) / 2;

		return Math.min(x, y);
	}

	public static double calculaAreaEsfera(double raio) {
		return 4 * Math.PI * Math.pow(raio, 2);
	}
}
