package api.domain.consulta.validacoes;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.exceptions.ValidationException;
import api.domain.medico.MedicoRepository;

public class MedicoAtivoValidator implements AgendamentoConsultaValidator {

	private MedicoRepository repository;

	@Override
	public void valida(AgendamentoConsultaDto dados) {
		if (dados.idMedico() == 0) return; // seleção automatica de médico

		var medicoIsAtivo = repository.findAtivoById(dados.idMedico());

		if (!medicoIsAtivo) throw new ValidationException("Não é possível agendar uma consulta com este médico!");
	}
}
