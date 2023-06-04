package testes;

public class TesteArrayDePrimitivos {
	public static void main(String[] args) {

		int[] idades = new int[5]; // devemos dizer quantos objetos vamos guardar no array.

		System.out.println(idades[2]); // array sempre é inicializado com o valor padrão, no caso o de int é 0

		idades[0] = 46;
		idades[1] = 45;
		idades[2] = 20;
		idades[3] = 15;
		idades[4] = 2;

		System.out.println(idades[0]);

		// System.out.println(idades[50]); // exception (este array só tem 5 "casas" e
		// estamos tentando acessar a casa 50)

		System.out.println("Comprimento do array idades: " + idades.length);

		for (int i = 0; i < idades.length; i++) {
			// System.out.println("A idade " + (i + 1) + " é: " + idades[i] + " anos.");
			System.out.println("A idade na posição " + i + " é: " + idades[i] + " anos.");
		}
	}
}
