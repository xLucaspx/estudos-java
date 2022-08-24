package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.CalculadorDeImposto;
import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SeguroDeVida;

public class TesteTributaveis {
	public static void main(String[] args) {
		System.out.println("Testando interfaces");

		Cliente clienteTributado = new Cliente("Thalia");
		ContaCorrente contaTributada = new ContaCorrente(2536, 13552, clienteTributado);
		SeguroDeVida seguroTributado = new SeguroDeVida();

		CalculadorDeImposto calculadorImpostos = new CalculadorDeImposto();

		contaTributada.deposita(1000);

		calculadorImpostos.registra(contaTributada); // 2.5% de 1000 = 25
		calculadorImpostos.registra(seguroTributado); // tarifa fixa = 42

		System.out.println("Total de tributos: R$ " + calculadorImpostos.getTotalImposto()); // total 67
	}
}