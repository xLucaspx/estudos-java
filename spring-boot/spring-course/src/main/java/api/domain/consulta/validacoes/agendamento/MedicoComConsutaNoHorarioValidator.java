package api.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.consulta.ConsultaRepository;
import api.domain.exceptions.ValidationException;

@Component
public class MedicoComConsutaNoHorarioValidator implements AgendamentoConsultaValidator {

	@Autowired
	private ConsultaRepository repository;

	@Override
	public void valida(AgendamentoConsultaDto dados) {
		if (dados.idMedico() == 0) return; // seleção automatica de médico

		var medicoPossuiOutraConsulta = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());

		if (medicoPossuiOutraConsulta)
			throw new ValidationException("O médico selecionado não está disponível neste horário!");
	}
}
