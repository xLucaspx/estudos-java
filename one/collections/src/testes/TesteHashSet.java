package testes;

import java.util.HashSet;
import java.util.Set;

public class TesteHashSet {
	public static void main(String[] args) {
		Set<String> alunos = new HashSet<>();

		alunos.add("Nico Steppat");
		alunos.add("Paulo Silveira");
		alunos.add("Flavio Almeida");
		alunos.add("Mário Melo");
		alunos.add("Vinicius Dias");
		alunos.add("Natan Souza");
		alunos.add("Frederico Aranha");
		alunos.add("Ricardo Bugan");

		boolean pauloFoiAdicionado = alunos.add("Paulo Silveira"); // false pois alunos já contém um "Paulo Silveira".
		boolean pauloEstaMatriculado = alunos.contains("Paulo Silveira");

		System.out.println("Paulo foi adicionado novemente? " + pauloFoiAdicionado);
		System.out.println("Paulo já está matriculado? " + pauloEstaMatriculado);

		System.out.println(alunos.size() + " alunos");

		// alunos.get(0); não funciona pois Set não garante a ordem dos elementos

		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});

		System.out.println("removendo aluno:");
		alunos.remove("Frederico Aranha");
		System.out.println(alunos.size() + " alunos");
	}
}
