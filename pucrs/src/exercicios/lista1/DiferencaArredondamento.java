package exercicios.lista1;

import model.RunnableExercise;

import java.util.Scanner;

public class DiferencaArredondamento extends RunnableExercise {

	public DiferencaArredondamento() {
		super("Lista I", 2, "Diferença arredondamento");
	}

	@Override
	public void run(Scanner in) {
		System.out.println(this);
		Double x = null;
		Double y = null;

		do {
			try {
				System.out.println(
					"\nVamos verificar a diferença entre as funções de arredondamento floor, ceil e round da classe Math");

				System.out.print("Digite o primeiro valor real: ");
				x = Double.parseDouble(in.nextLine());

				System.out.print("Digite o segundo valor real: ");
				y = Double.parseDouble(in.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Valor inválido inserido!");
			}
		} while (x == null || y == null);

		exibeDiferencaArredondamento(x, y);
	}

	private void exibeDiferencaArredondamento(double x, double y) {
		var result = x + y;

		System.out.printf("%.2f + %.2f = %.2f%n%n", x, y, result);

		System.out.printf(
			"O método Math.floor() retorna o maior valor double (mais próximo do infinito positivo) que seja menor ou igual "
			+ "ao argumento recebido e igual a um inteiro matemático%nResultado de Math.floor(%.2f) = %.2f%n%n",
			result,
			Math.floor(result)
		);

		System.out.printf(
			"O método Math.ceil() retorna o menor valor double (mais próximo do infinito negativo) que seja maior ou igual " +
			"ao argumento recebido e igual a um inteiro matemático%nResultado de Math.ceil(%.2f) = %.2f%n%n",
			result,
			Math.ceil(result)
		);

		System.out.printf(
			"O método Math.round() retorna o valor long mais próximo do argumento recebido%nResultado de Math.round(%.2f) = "
			+ "%d%n%n",
			result,
			Math.round(result)
		);
	}
}
