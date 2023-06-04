package testes;

import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;
import models.SistemaInterno;

public class TestesContas {
	public static void main(String[] args) {
		System.out.println("Testes herança e polimorfismo - contas");

		Cliente cli1 = new Cliente("Jonas");

		ContaCorrente cc1 = new ContaCorrente(2425, 12557, cli1);
		String nomeClienteCc = cc1.getTitular().getNome();

		ContaPoupanca cp1 = new ContaPoupanca(2425, 13258, cli1);
		String nomeClienteCp = cp1.getTitular().getNome();

		cc1.deposita(800);

		try {
			// polimorfismo: transfere de uma CONTA corrente para uma CONTA poupanca (CONTA = tipo mais genérico)
			cc1.transfere(cp1, 300); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Conta corrente " + nomeClienteCc + ": ag " + cc1.getAgencia() + " nº " + cc1.getNumero()
				+ " Saldo R$ " + cc1.getSaldo());

		System.out.println("Conta poupança " + nomeClienteCp + ": ag " + cp1.getAgencia() + " nº " + cp1.getNumero()
				+ " Saldo R$ " + cp1.getSaldo());

		int numeroDeContas = Conta.getNumeroDeContas();
		System.out.println("Número de contas: " + numeroDeContas);

		cli1.setSenha(1369);
		SistemaInterno sistemaLogin = new SistemaInterno(1369);
		sistemaLogin.autentica(cli1);
	}
}
