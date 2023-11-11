package api.paciente;

import api.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdatePacienteDto(@NotNull int id, String nome, String telefone, @NotNull @Valid EnderecoDto endereco) {}
