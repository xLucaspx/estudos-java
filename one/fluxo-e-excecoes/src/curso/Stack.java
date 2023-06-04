package curso;

public class Stack { // utilizamos breakpoints e o debugger para entender a stack do Java
	public static void main(String[] args) {
		System.out.println("Início do main");
		metodo1();
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
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("Fim do metodo2");
	}
}
