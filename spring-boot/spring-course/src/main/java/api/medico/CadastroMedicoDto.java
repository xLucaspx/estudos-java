package api.medico;

import api.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CadastroMedicoDto(
		// @NotBlank já verifica se não é nulo e nem vazio, mas serve apenas para String
		@NotBlank @Size(min = 3, max = 75) String nome,
		@NotBlank @Email
		@Size(min = 10, max = 75) String email,
		@NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
		@NotBlank @Size(min = 10, max = 25) String telefone,
		@NotNull Especialidade especialidade,
		// @Valid serve para garantir a execução das validações do outro DTO
		@NotNull @Valid EnderecoDto endereco) {}
