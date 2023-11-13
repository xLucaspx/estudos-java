package api.domain.medico;

import api.domain.endereco.Endereco;

public record DetalhesMedicoDto(
		int id,
		String nome,
		String email,
		String telefone,
		String crm,
		Especialidade especialidade,
		Endereco endereco) {

	public DetalhesMedicoDto(Medico m) {
		this(m.getId(), m.getNome(), m.getEmail(), m.getTelefone(), m.getCrm(), m.getEspecialidade(), m.getEndereco());
	}
}
