package model;

import java.util.Scanner;

public abstract class RunnableExercise {
	private String descricao;

	public RunnableExercise(String lista, int numero, String descricao) {
		this.descricao = "%s - Exercício %02d - %s".formatted(lista, numero, descricao);
	}

	public abstract void run(Scanner in);

	@Override
	public String toString() {
		return descricao;
	}
}
