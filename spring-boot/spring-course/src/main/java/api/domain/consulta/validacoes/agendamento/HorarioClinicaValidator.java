package api.domain.consulta.validacoes.agendamento;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.exceptions.ValidationException;

@Component
public class HorarioClinicaValidator implements AgendamentoConsultaValidator {
	@Override
	public void valida(AgendamentoConsultaDto dados) {
		var dataConsulta = dados.data();

		var isSunday = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		var isBeforeOpen = dataConsulta.getHour() < 7;
		var isAfterClose = dataConsulta.getHour() > 18;

		if (isSunday || isBeforeOpen || isAfterClose)
			throw new ValidationException("Não é possível agendar uma consulta fora do horário de atendimento da clínica");
	}
}
