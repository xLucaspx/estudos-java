package br.com.curso.javautil.testes;

import br.com.curso.javautil.modelos.Conta;
import br.com.curso.javautil.modelos.ContaCorrente;
import br.com.curso.javautil.modelos.ContaPoupanca;
import br.com.curso.javautil.modelos.GuardaContas;

public class TesteGuardaContas {
	public static void main(String[] args) {
		GuardaContas guardaContas = new GuardaContas();
		
		ContaCorrente cc = new ContaCorrente(2255, 85479);
		ContaPoupanca cp = new ContaPoupanca(2547, 66558);
		
		guardaContas.adicionaConta(cc);
		guardaContas.adicionaConta(cp);
		
		Conta ref1 = guardaContas.getConta(0);
		Conta ref2 = guardaContas.getConta(1);
		Conta ref3 = guardaContas.getConta(2);
		
		System.out.println(ref1);
		System.out.println(ref2);
		System.out.println(ref3);
		System.out.println("Quantidade de contas: " + guardaContas.getQuantidadeDeContas());
	}
}
