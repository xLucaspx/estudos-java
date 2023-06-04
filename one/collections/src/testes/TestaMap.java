package testes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestaMap {
	public static void main(String[] args) {
		Map<String, Integer> nomesParaIdade = new HashMap<>();
		nomesParaIdade.put("Paulo", 31);
		nomesParaIdade.put("Adriano", 25);
		nomesParaIdade.put("Alberto", 33);
		nomesParaIdade.put("Guilherme", 26);

		System.out.println("Acessando as chaves:");
		Set<String> chaves = nomesParaIdade.keySet();

		for (String nome : chaves) {
			System.out.println(nome);
		}

		System.out.println("Acessando os valores:");
		Collection<Integer> valores = nomesParaIdade.values();

		for (Integer idade : valores) {
			System.out.println(idade);
		}

		System.out.println("Acessando a associação da chave com os valores:");
		Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();

		for (Entry<String, Integer> associacao : associacoes) {
			System.out.println("Nome: " + associacao.getKey() + ", idade: " + associacao.getValue() + " anos");
		}
	}
}
