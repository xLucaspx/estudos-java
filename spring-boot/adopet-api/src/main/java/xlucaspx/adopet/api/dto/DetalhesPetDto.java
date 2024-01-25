package xlucaspx.adopet.api.dto;

import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.TipoPet;

public record DetalhesPetDto(Long id, TipoPet tipo, String nome, String raca, Integer idade) {

	public DetalhesPetDto(Pet pet) {
		this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
	}
}
