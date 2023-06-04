package testes;

import java.util.ArrayList;
import java.util.Collections;

public class TesteListas {
	public static void main(String[] args) {
		String aula1 = "Conhecendo mais de listas";
		String aula2 = "Modelando a classe Aula";
		String aula3 = "Trabalhando com Cursos e Sets";

		ArrayList<String> aulas = new ArrayList<>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);

		System.out.println(aulas);

		aulas.remove(0);

		System.out.println(aulas);

		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}

		String primeiraAula = aulas.get(0);
		System.out.println("A primeira aula é: " + primeiraAula);

		System.out.println("Adicionando nova aula:");
		aulas.add("Aula introdutória");

		for (int i = 0; i < aulas.size(); i++) {
			System.out.println("Aula " + i + ": " + aulas.get(i));
		}

		System.out.println("Ordenando aulas:");
		Collections.sort(aulas);

		aulas.forEach(aula -> {
			System.out.println("Percorrendo: " + aula);
		});
	}
}
