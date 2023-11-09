package api.paciente;

import api.endereco.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PacienteDto(
		@NotBlank @Size(min = 3, max = 75) String nome,
		@NotBlank @Email @Size(min = 10, max = 75) String email,
		@NotBlank @Size(min = 10, max = 25) String telefone,
		@NotBlank @Size(min = 11, max = 11) String cpf,
		@Valid EnderecoDto endereco) {}
