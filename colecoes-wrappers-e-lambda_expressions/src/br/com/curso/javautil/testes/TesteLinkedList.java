package br.com.curso.javautil.testes;

import java.util.LinkedList;
import java.util.List;

import br.com.curso.javautil.modelos.Conta;
import br.com.curso.javautil.modelos.ContaCorrente;
import br.com.curso.javautil.modelos.ContaPoupanca;

public class TesteLinkedList {
	public static void main(String[] args) {
		// ArrayList e LinkedList implementam List, ou seja, tem os mesmos métodos
		List<Conta> lista = new LinkedList<Conta>(); // polimorfismo
		
		ContaCorrente cc1 = new ContaCorrente(2545, 55447);
		ContaPoupanca cp1 = new ContaPoupanca(2145, 77884);
		ContaCorrente cc2 = new ContaCorrente(2547, 78978);
		
		lista.add(cc1);
		lista.add(cp1);
		lista.add(cc2);
		
		System.out.println("Conteúdo da lista:");
		
		for (Conta x : lista) {
			System.out.println(x);
		}
		
		System.out.println("Tamanho da lista: " + lista.size());
		lista.remove(0);
		System.out.println("Removendo um elemento...");
		System.out.println("Tamanho da lista: " + lista.size());
		
		
		Object ref1 = lista.get(0);
		System.out.println(ref1);
		
		Conta ref2 = (Conta) lista.get(1);
		System.out.println(ref2);
	}
}
