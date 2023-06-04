package testes;

import java.util.ArrayList;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class TesteArrayListEquals {
	public static void main(String[] args) {
		ArrayList<Conta> lista = new ArrayList<Conta>();

		ContaCorrente cc1 = new ContaCorrente(2145, 77884);
		ContaPoupanca cp1 = new ContaPoupanca(2145, 77884);
		ContaCorrente cc2 = new ContaCorrente(2547, 78978);
		ContaPoupanca cp2 = new ContaPoupanca(2145, 77884);

		lista.add(cc1);
		lista.add(cp1);
		lista.add(cc2);

		boolean contem = lista.contains(cp2); // == compara as referencias, não o conteúdo (loop abaixo explicando contains)
		System.out.println(contem);

		// contains:
		// for (Conta conta : lista) {
		// if (conta == cp2) {
		// System.out.println("Contém");
		// }
		// }

		boolean igual = cp1.equals(cp2); // sobrescrevemos metodo equals na classe Conta
		boolean igual2 = cp2.equals(cc1);
		System.out.println(igual + " " + igual2);

		System.out.println(cc1.getClass());
		System.out.println(cp1.getClass());
		System.out.println(cp2.getClass());
	}
}
