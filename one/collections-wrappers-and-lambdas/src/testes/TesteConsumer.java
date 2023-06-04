package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class TesteConsumer {
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

		lista.sort((c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()));

		lista.forEach(new Consumer<Conta>() {
			@Override
			public void accept(Conta c) {
				System.out.println(c + " Titular: " + c.getTitular().getNome() + " Saldo R$ " + c.getSaldo());
			}
		});

		System.out.println("/----/----/----/----/----/----/----/----/----/----/----/----/----/----/");

		lista.sort((c1, c2) -> Double.compare(c1.getAgencia(), c2.getAgencia()));

		// Forma mais enxuta:
		lista.forEach((conta) -> System.out
				.println(conta + " Titular: " + conta.getTitular().getNome() + " Saldo R$ " + conta.getSaldo()));
	}
}
