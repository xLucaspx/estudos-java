package api.paciente;

import api.endereco.Endereco;

public record DetalhesPacienteDto(int id, String nome, String cpf, String email, String telefone, Endereco endereco) {

	public DetalhesPacienteDto(Paciente p) {
		this(p.getId(), p.getNome(), p.getCpf(), p.getEmail(), p.getTelefone(), p.getEndereco());
	}
}
