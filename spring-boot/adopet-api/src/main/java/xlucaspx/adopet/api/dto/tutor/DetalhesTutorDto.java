package xlucaspx.adopet.api.dto.tutor;

import xlucaspx.adopet.api.model.Tutor;

public record DetalhesTutorDto(Long id, String nome, String email, String telefone) {

	public DetalhesTutorDto(Tutor tutor) {
		this(tutor.getId(), tutor.getNome(), tutor.getEmail(), tutor.getTelefone());
	}
}
