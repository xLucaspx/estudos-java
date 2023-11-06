package api.medico;

import api.endereco.EnderecoDto;

public record MedicoDto(String nome, String email, String crm, Especialidade especialidade, EnderecoDto endereco) {}
