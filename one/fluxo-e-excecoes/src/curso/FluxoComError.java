package curso;

public class FluxoComError {
	public static void main(String[] args) {
		System.out.println("Início do main");

		try {
			metodo1();
		} catch (ArithmeticException | NullPointerException e) { // multi-catch
			e.printStackTrace();
		}

		System.out.println("Fim do main");
	}

	private static void metodo1() {
		System.out.println("Início do metodo1");
		metodo2();
		System.out.println("Fim do metodo1");
	}

	private static void metodo2() {
		System.out.println("Início do metodo2");
		// metodo2 se chama eternamente, resultando em um Erro;
		// (erros são exclusivos da máquina virtual)
		metodo2(); // java.lang.StackOverflowError
		System.out.println("Fim do metodo2");
	}
}
