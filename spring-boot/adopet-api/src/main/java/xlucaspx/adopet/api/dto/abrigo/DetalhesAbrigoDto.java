package xlucaspx.adopet.api.dto.abrigo;

import xlucaspx.adopet.api.model.Abrigo;

public record DetalhesAbrigoDto(Long id, String nome, String email, String telefone) {

	public DetalhesAbrigoDto(Abrigo abrigo) {
		this(abrigo.getId(), abrigo.getNome(), abrigo.getEmail(), abrigo.getTelefone());
	}
}
