package testes;

import java.util.ArrayList;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class TesteArrayList {
	public static void main(String[] args) {
		// ArrayList lista = new ArrayList();
		// pode ocorrer mistura de referências de tipos diferentes

		// Generics: código mais tipado e mais seguro
		ArrayList<Conta> lista = new ArrayList<Conta>(); // tipificação: agora a lista só guarda objetos do tipo Conta

		ContaCorrente cc1 = new ContaCorrente(2545, 55447);
		ContaPoupanca cp1 = new ContaPoupanca(2145, 77884);
		ContaCorrente cc2 = new ContaCorrente(2547, 78978);

		lista.add(cc1);
		lista.add(cp1);
		lista.add(cc2);

		System.out.println("Conteúdo da lista:");

		// for (int i = 0; i < lista.size(); i++) {
		// Object oRef = lista.get(i);
		// System.out.println(oRef);
		// }

		for (Conta x : lista) { // mesma saída que o for acima
			System.out.println(x);
		}

		System.out.println("Tamanho da lista: " + lista.size());
		lista.remove(0);
		System.out.println("Removendo um elemento...");
		System.out.println("Tamanho da lista: " + lista.size());

		System.out.println(lista.get(1).getClass());

		Object ref1 = lista.get(1);
		System.out.println(ref1);

		Conta ref2 = (Conta) lista.get(0);
		System.out.println(ref2.getNumero());
	}
}
