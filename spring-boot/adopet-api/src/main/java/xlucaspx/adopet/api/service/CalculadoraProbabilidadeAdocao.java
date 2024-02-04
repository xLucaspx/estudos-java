package xlucaspx.adopet.api.service;

import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.ProbabilidadeAdocao;

public class CalculadoraProbabilidadeAdocao {

	public ProbabilidadeAdocao calcula(Pet pet) {
		int nota = calculaNota(pet);

		if (nota > 8) return ProbabilidadeAdocao.ALTA;

		return nota >= 5 ? ProbabilidadeAdocao.MEDIA : ProbabilidadeAdocao.BAIXA;
	}

	private int calculaNota(Pet pet) {
		var peso = pet.getPeso().intValue();
		var idade = pet.getIdade();
		var tipo = pet.getTipo();

		int nota = 10;

		// penalizando por peso
		switch (tipo) {
			case GATO -> {if (peso > 10) nota -= 2;}
			case CACHORRO -> {if (peso > 15) nota -= 2;}
			default -> throw new ValidacaoException("Erro ao definir tipo do pet: " + tipo);
		}

		// penalizando por idade avançada
		if (idade >= 15) nota -= 5;
		else if (idade >= 10) nota -= 4;

		return nota;
	}
}
