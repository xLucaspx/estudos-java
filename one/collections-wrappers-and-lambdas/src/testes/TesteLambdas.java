package testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class TesteLambdas {
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

		// Lambda expression:
		lista.sort((Conta c1, Conta c2) -> {
			return Integer.compare(c1.getNumero(), c2.getNumero());
		});

		// Atribuindo a uma variável:
		Comparator<Conta> comp = (Conta c1, Conta c2) -> {
			return c1.getTitular().getNome().compareTo(c2.getTitular().getNome());
		};

		lista.sort(comp);

		// Forma mais enxuta - sem definir o tipo das variaveis, sem chaves, sem return:
		lista.sort((c1, c2) -> Integer.compare(c1.getAgencia(), c2.getAgencia()));

		System.out.println("Após a ordenação:");
		for (Conta c : lista) {
			System.out.println(c);
		}
	}
}
