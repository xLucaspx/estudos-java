package api.domain.consulta;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import api.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record AgendamentoConsultaDto(
		int idMedico,
		int idPaciente,
		@NotNull @Future
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime data,
		Especialidade especialidade) {}
