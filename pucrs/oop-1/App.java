import java.util.Scanner;

public class App {
	public void run(String... args) {
		int length = args.length;
		switch (length) {
			case 0 -> runFromScanner();
			case 3 -> runFromArgs(args);
			default -> System.err.println("Número de parâmetros incorreto: deve ser 0 ou 3!");
		}
	}

	private void runFromScanner() {
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("Insira o dividendo (inteiro): ");
			int dividendo = Integer.parseInt(in.nextLine());

			System.out.print("Insira o divisor (inteiro): ");
			int divisor = Integer.parseInt(in.nextLine());

			System.out.print("Insira a precisão desejada (inteiro): ");
			int precisao = Integer.parseInt(in.nextLine());

			exibeResultado(dividendo, divisor, precisao);
		} catch (NumberFormatException e) {
			System.err.println("Erro ao converter: " + e.getMessage());
		}
	}

	private void runFromArgs(String... args) {
		try {
			int dividendo = Integer.parseInt(args[0]);
			int divisor = Integer.parseInt(args[1]);
			int precisao = Integer.parseInt(args[2]);

			exibeResultado(dividendo, divisor, precisao);
		} catch (NumberFormatException e) {
			System.err.println("Erro ao converter: " + e.getMessage());
		}
	}

	private void exibeResultado(int dividendo, int divisor, int precisao) {
		String resultado = Matematica.divide(dividendo, divisor, precisao);
		System.out.printf("%d / %d = %s%n", dividendo, divisor,
				resultado == null ? "Não foi possível realizar a divisão" : resultado);
	}
}
