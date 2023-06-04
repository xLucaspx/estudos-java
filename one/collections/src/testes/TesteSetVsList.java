package testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TesteSetVsList {
	public static void main(String[] args) {
		System.out.println("**** ArrayList vs HashSet ***");

		List<Integer> numerosArrayList = new ArrayList<>();
		Set<Integer> numerosHashSet = new HashSet<>();
		int quantidadeElementos = 100000;

		long tempoArrayList = insereElementosNo(numerosArrayList, quantidadeElementos);
		long tempoHashSet = insereElementosNo(numerosHashSet, quantidadeElementos);

		System.out.println("Inserção na ArrayList demorou  " + tempoArrayList);
		System.out.println("Inserção na HashSet demorou " + tempoHashSet);

		tempoArrayList = pesquisaElementos(numerosArrayList);
		tempoHashSet = pesquisaElementos(numerosHashSet);

		System.out.println("Pesquisa da ArrayList demorou  " + tempoArrayList);
		System.out.println("Pesquisa da HashSet demorou " + tempoHashSet);
	}

	private static long insereElementosNo(Collection<Integer> numeros, int quantidade) {
		long ini = System.currentTimeMillis();
		for (int i = 0; i < quantidade; i++) {
			numeros.add(i);
		}
		long fim = System.currentTimeMillis();
		return fim - ini;
	}

	private static long pesquisaElementos(Collection<Integer> numeros) {
		long ini = System.currentTimeMillis();

		for (int numero : numeros) {
			numeros.contains(numero);
		}
		long fim = System.currentTimeMillis();
		return fim - ini;
	}
}
