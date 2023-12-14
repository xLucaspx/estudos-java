package api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record CancelamentoConsultaDto(@NotNull Integer idConsulta, @NotNull MotivoCancelamento motivo) {}
