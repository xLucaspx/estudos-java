package br.com.curso.collections.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.curso.collections.modelos.Aula;
import br.com.curso.collections.modelos.Curso;

public class TestaCurso {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		List<Aula> aulasImutaveis = javaColecoes.getAulas();

		System.out.println(aulasImutaveis);

//		aulasImutaveis.add(new Aula("Trabalhando com ArrayList", 24)); // não funciona com unmodifiable
//		javaColecoes.getAulas().add(new Aula("Listas de objetos", 19)); // não funciona com unmodifiable

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 24));
		javaColecoes.adiciona(new Aula("Listas de objetos", 19));
		javaColecoes.adiciona(new Aula("Relacionamento com coleções", 23));

		List<Aula> aulas = new ArrayList<>(aulasImutaveis);

		aulas.forEach(aula -> {
			System.out.println(aula);
		});

		System.out.println("Tempo total do curso: " + javaColecoes.getTempoTotal() + " minutos");

		System.out.println(javaColecoes);

		System.out.println(aulas == javaColecoes.getAulas());
		System.out.println(aulasImutaveis == aulas);
	}
}
