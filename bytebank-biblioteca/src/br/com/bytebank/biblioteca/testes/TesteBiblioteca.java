package br.com.bytebank.biblioteca.testes;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SemSaldoException;
// imports vem do arquivo bytebank-biblioteca.jar, que adicionamos ao build-path e agora aparece em referenced libraries

public class TesteBiblioteca {

	public static void main(String[] args) {
		System.out.println("Testando biblioteca");

		Cliente cliente = new Cliente("Amanda");
		ContaCorrente conta = new ContaCorrente(7856, 55456, cliente);

		conta.deposita(500);
		try {
			conta.saca(49.8);
		} catch (SemSaldoException e) {
			e.printStackTrace();
		}

		System.out.println(conta.getTitular().getNome() + ", seu saldo é de R$ " + conta.getSaldo());
	}
}
