package api.domain.consulta.validacoes;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.consulta.ConsultaRepository;
import api.domain.exceptions.ValidationException;

public class PacienteComConsutaNoDiaValidator {

	private ConsultaRepository repository;

	public void valida(AgendamentoConsultaDto dados) {
		var primeiroHorario = dados.data().withHour(7);
		var ultimoHorario = dados.data().withHour(18);

		var pacientePossuiOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.idMedico(), primeiroHorario, ultimoHorario);

		if (pacientePossuiOutraConsulta)
			throw new ValidationException("O paciente já possui uma consulta agendada neste dia!");
	}
}
