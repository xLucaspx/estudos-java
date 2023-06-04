package testes;

import models.Aluno;
import models.Aula;
import models.Curso;

public class TestaCursoComAluno {
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

		System.out.println("Alunos matriculados: ");

		javaColecoes.getAlunos().forEach(aluno -> {
			System.out.println(aluno);
		});

		javaColecoes.getAlunos().forEach(aluno -> {
			System.out
					.println("O aluno " + aluno.getNome() + " está matriculado no curso? " + javaColecoes.estaMatriculado(aluno));
		});

		Aluno nico = new Aluno("Nico Steppat", 1388);
		System.out.println("e este aluno? " + javaColecoes.estaMatriculado(nico));

		System.out.println("a1 == nico? " + (a1 == nico));

		System.out.println("a1 equals nico? " + a1.equals(nico)); // sobrescrevemos equals e hashcode na classe Aluno
		// obrigatoriamente o seguinte é true:
		System.out.println(a1.hashCode() == nico.hashCode());
	}
}
