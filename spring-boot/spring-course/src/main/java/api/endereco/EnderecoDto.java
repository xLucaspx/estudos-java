package api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoDto(
		@NotBlank @Pattern(regexp = "\\d{5}-?\\d{3}") String cep,
		@NotBlank @Size(min = 3, max = 100) String logradouro,
		@NotBlank @Size(min = 3, max = 50) String bairro,
		@NotBlank @Size(min = 3, max = 50) String cidade,
		@NotBlank @Size(min = 2, max = 2) String uf,
		String numero,
		String complemento) {}
