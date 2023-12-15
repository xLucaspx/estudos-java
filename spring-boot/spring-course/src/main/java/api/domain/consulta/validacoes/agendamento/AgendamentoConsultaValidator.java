package api.domain.consulta.validacoes.agendamento;

import api.domain.consulta.AgendamentoConsultaDto;

// esta interface não precisa de anotação para ser carregada pelo Spring
public interface AgendamentoConsultaValidator {
	void valida(AgendamentoConsultaDto dados);
}
