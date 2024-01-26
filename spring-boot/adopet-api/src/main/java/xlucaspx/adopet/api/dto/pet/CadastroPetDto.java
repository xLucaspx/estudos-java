package xlucaspx.adopet.api.dto.pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import xlucaspx.adopet.api.model.TipoPet;

public record CadastroPetDto(@NotBlank String nome, @NotBlank String raca, @NotBlank String cor, @NotNull Integer idade,
		@NotNull Float peso, @NotNull TipoPet tipo) {}
