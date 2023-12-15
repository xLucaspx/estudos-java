package api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.consulta.ConsultaRepository;
import api.domain.exceptions.ValidationException;

@Component
public class PacienteComConsutaNoDiaValidator implements AgendamentoConsultaValidator {

	@Autowired
	private ConsultaRepository repository;

	@Override
	public void valida(AgendamentoConsultaDto dados) {
		var primeiroHorario = dados.data().withHour(7);
		var ultimoHorario = dados.data().withHour(18);

		var pacientePossuiOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario,
				ultimoHorario);

		if (pacientePossuiOutraConsulta)
			throw new ValidationException("O paciente já possui uma consulta agendada neste dia!");
	}
}
