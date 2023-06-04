package testes;

import java.util.ArrayList;

public class TesteWrappers {
	public static void main(String[] args) {
		Integer idade = Integer.valueOf(20); // autoboxing
		System.out.println(idade.intValue()); // unboxing

		Double num = Double.valueOf(1.5);
		System.out.println(num.doubleValue());

		Boolean bRef = Boolean.FALSE;
		System.out.println(bRef.booleanValue());

		Number nRef = Float.valueOf(21.2f); // polimorfismo
		System.out.println(nRef.floatValue());

		ArrayList<Number> lista = new ArrayList<>();
		lista.add(idade);
		lista.add(num);
		lista.add(nRef);

		for (Number x : lista) {
			System.out.println(x);
		}

		// char cRef = 65535; // valor máximo do char
		Character cRef = Character.valueOf('A');
		System.out.println(cRef);
	}
}
