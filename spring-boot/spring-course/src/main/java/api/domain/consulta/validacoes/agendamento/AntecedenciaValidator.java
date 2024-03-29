package api.domain.consulta.validacoes.agendamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.exceptions.ValidationException;

@Component("AntecedenciaAgendamentoValidator")
public class AntecedenciaValidator implements AgendamentoConsultaValidator {
	@Override
	public void valida(AgendamentoConsultaDto dados) {
		var horaConsulta = dados.data();
		var agora = LocalDateTime.now();

		var minutesDiff = Duration.between(agora, horaConsulta).toMinutes();

		if (minutesDiff < 30)
			throw new ValidationException("A consulta deve ser agendada com, no mínimo, 30 minutos de antecedência!");
	}
}
