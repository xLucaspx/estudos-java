package testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class TesteComparatorN {
	public static void main(String[] args) {
		Conta cc1 = new ContaCorrente(221, 33, new Cliente("Nico"));
		cc1.deposita(333.0);

		Conta cp1 = new ContaPoupanca(223, 44, new Cliente("Guilherme"));
		cp1.deposita(444.0);

		Conta cc2 = new ContaCorrente(224, 11, new Cliente("Paulo"));
		cc2.deposita(111.0);

		Conta cp2 = new ContaPoupanca(222, 22, new Cliente("Ana"));
		cp2.deposita(222.0);

		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cp1);
		lista.add(cc2);
		lista.add(cp2);

		System.out.println("Antes da ordenação:");
		for (Conta c : lista) {
			System.out.println(c);
		}

		System.out.println("/----/----/----/----/----/----/----/");

		// ContaComparatorN comparator = new ContaComparatorN();
		// lista.sort(comparator);

		lista.sort(new ContaComparatorN()); // mais enxuto que a forma acima

		System.out.println("Após a ordenação:");
		for (Conta c : lista) {
			System.out.println(c);
		}
	}
}

class ContaComparatorN implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		// if (c1.getNumero() < c2.getNumero()) {
		// return -1;
		// }
		// if (c1.getNumero() > c2.getNumero()) {
		// return 1;
		// }
		// return 0;

		// return c1.getNumero() - c2.getNumero(); // mais enxuto que o código acima

		return Integer.compare(c1.getNumero(), c2.getNumero()); // outra forma com o mesmo resultado
	}
}
