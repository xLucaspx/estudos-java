package exercicios;

public class DiferencaArredondamento {
	public static void exibeDiferencaArredondamento(double x, double y) {
		var result = x + y;

		System.out.printf("%.2f + %.2f = %.2f%n", x, y, result);

		System.out.printf(
			"O método Math.floor() retorna o maior valor double (mais próximo do infinito positivo) que seja menor ou igual "
				+ "ao argumento recebido e igual a um inteiro matemático%nResultado de Math.floor(%.2f) = %.2f%n",
			result,
			Math.floor(result)
		);

		System.out.printf(
			"O método Math.round() retorna o valor long mais próximo do argumento recebido%nResultado de Math.round(%.2f) = "
				+ "%d%n",
			result,
			Math.round(result)
		);

		System.out.printf(
			"O método Math.ceil() retorna o menor valor double (mais próximo do infinito negativo) que seja maior ou igual " + "ao argumento recebido e igual a um inteiro matemático%nResultado de Math.ceil(%.2f) = %.2f%n",
			result,
			Math.ceil(result)
		);
	}
}
