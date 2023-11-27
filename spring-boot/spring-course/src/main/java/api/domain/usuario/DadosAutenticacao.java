package api.domain.usuario;

import jakarta.validation.constraints.NotEmpty;

public record DadosAutenticacao(@NotEmpty String login, @NotEmpty String senha) {}
