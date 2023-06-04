package testes;

import java.util.ArrayList;
import java.util.List;

public class TesteInteger {
	public static void main(String[] args) {

		// int[] idades = new int[5]; // array de primitivos
		// Strin[] nomes = new String[5]; // array de referências

		int idade = 20; // Integer
		// List<int> numeros = new ArrayList<int>(); //não compila: int é primitivo

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(idade);
		// não deveria funcionar pois idade é um tipo primitivo, porém o java transforma
		// em referência por baixo dos panos:
		// Integer idade = new Integer(20); (deprecated)
		numeros.add(Integer.valueOf(idade));

		numeros.add(22); // Autoboxing

		Integer idadeRef = Integer.valueOf(idade); // asiim podemos usar metodos com este valor:
		int valor = idadeRef.intValue();

		System.out.println("Idade: " + valor);

		String s = args[0];

		// parsing:
		Integer num1 = Integer.valueOf(s); // devolve uma referência
		int num2 = Integer.parseInt(s); // devolve um primitivo

		System.out.println(num1 + num2);

		num1++; // ex de unboxing e autoboxing: incrementando a referência
		System.out.println(num1.doubleValue());

		// constantes sempre com letra maiúscula:
		System.out.println(Integer.MAX_VALUE); // 2^31 - 1
		System.out.println(Integer.MIN_VALUE); // -2^31
		System.out.println(Integer.SIZE + " bits"); // 32 bits
		System.out.println(Integer.BYTES + " bytes"); // 4 Bytes
	}
}
