package testes;

import java.util.Iterator;
import java.util.Set;

import models.Aluno;
import models.Aula;
import models.Curso;

public class TesteIterator {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 24));
		javaColecoes.adiciona(new Aula("Listas de objetos", 19));
		javaColecoes.adiciona(new Aula("Relacionamento com coleções", 23));

		Aluno a1 = new Aluno("Nico Steppat", 1388);
		Aluno a2 = new Aluno("Gulherme Silveira", 5467);
		Aluno a3 = new Aluno("Flavio Almeida", 2765);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);

		System.out.println(javaColecoes);

		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator(); // todas as coleções possuem o método iterator

		while (iterador.hasNext()) {
			System.out.println(iterador.next());
		}

		// Aluno depoisDoUltimo = iterador.next(); // NoSuchElementException;
		// se quisermos percorrer novamente com o iterador, temos que pedir um novo

		// iterator é a forma mais antiga de se fazer...
		for (Aluno a : javaColecoes.getAlunos()) {
			System.out.println(a);
		}
	}
}
