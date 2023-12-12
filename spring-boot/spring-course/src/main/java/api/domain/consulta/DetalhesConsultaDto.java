package api.domain.consulta;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record DetalhesConsultaDto(
		int id,
		int idMedico,
		int idPaciente,
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime data) {}
