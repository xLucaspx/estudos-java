package curso;

public class FluxoComTratamento {
	public static void main(String[] args) {
		System.out.println("Início do main");

		try {
			metodo1();
		} catch (ArithmeticException | NullPointerException e) {
			String mensagem = e.getMessage();
			System.out.println("Exception: " + mensagem);
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
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
			Conta c = null;
			c.deposita(); // NullPointerException
			// int a = i / 0; // ArithmeticException
		}
		System.out.println("Fim do metodo2");
	}
}
