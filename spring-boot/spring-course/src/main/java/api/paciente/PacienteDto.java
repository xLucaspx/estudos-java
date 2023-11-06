package api.paciente;

import api.endereco.EnderecoDto;

public record PacienteDto(String nome, String email, String telefone, String cpf, EnderecoDto endereco) {}
