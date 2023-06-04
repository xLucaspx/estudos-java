package testes;

import models.Aluno;
import models.Aula;
import models.Curso;

public class TestaBuscaAlunosNoCurso {
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

		Aluno aluno = javaColecoes.buscaMatriculado(5467);
		System.out.println(aluno);
	}
}
