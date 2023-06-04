package testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class TesteComparable {
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
			// System.out.println(c + " Titular: " + c.getTitular().getNome());
			System.out.println(c + " Saldo R$ " + c.getSaldo());
		}

		// Atenção: Collections (classe) != Collection (interface)

		// Alguns métodos da classe Collections:
		Collections.sort(lista, new ContaComparatorT());
		Collections.reverse(lista);

		// ordem natural - tivemos que implementar Comparable na classe Conta e
		// sobrescrever o metodo CompareTo para funcionar:
		Collections.sort(lista);
		lista.sort(null); // mesma coisa que o código acima (desde que haja a implementação de Comparable)

		System.out.println("/----/----/----/----/----/----/----/----/----/----/");

		System.out.println("Após a ordenação:");
		for (Conta c : lista) {
			// System.out.println(c + " Titular: " + c.getTitular().getNome());
			System.out.println(c + " Saldo R$ " + c.getSaldo());
		}
	}
}
