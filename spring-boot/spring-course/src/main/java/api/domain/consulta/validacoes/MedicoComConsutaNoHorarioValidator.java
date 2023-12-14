package api.domain.consulta.validacoes;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.consulta.ConsultaRepository;
import api.domain.exceptions.ValidationException;

public class MedicoComConsutaNoHorarioValidator {

	private ConsultaRepository repository;

	public void valida(AgendamentoConsultaDto dados) {
		if (dados.idMedico() == 0) return; // seleção automatica de médico

		var medicoPossuiOutraConsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

		if (medicoPossuiOutraConsulta)
			throw new ValidationException("O médico selecionado não está disponível neste horário!");
	}
}
