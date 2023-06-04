package testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.Aula;

public class TestaListaDeAula {

	public static void main(String[] args) {
		Aula a1 = new Aula("Trabalhando com ArrayList", 24);
		Aula a2 = new Aula("Listas de objetos", 19);
		Aula a3 = new Aula("Relacionamento com coleções", 23);

		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);

		System.out.println(aulas);

		System.out.println("Ordenando pelo título:");
		Collections.sort(aulas);

		aulas.forEach(aula -> {
			System.out.println(aula);
		});

		System.out.println("Ordenando pelo tempo:");
		// Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		aulas.sort(Comparator.comparing(Aula::getTempo));

		aulas.forEach(aula -> {
			System.out.println(aula);
		});
	}
}
