package api.domain.medico;

import api.domain.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdateMedicoDto(@NotNull int id, String nome, String telefone, @NotNull @Valid EnderecoDto endereco) {}
