package api.domain.consulta.validacoes.cancelamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.domain.consulta.CancelamentoConsultaDto;
import api.domain.consulta.ConsultaRepository;
import api.domain.exceptions.ValidationException;

// para evitar conflitos do Spring não é possível ter dois componentes gerenciados com o mesmo nome.
// Para resolver podemos alterar o nome das classes ou alterar o nome dentro da anotação @Component
@Component("AntecedenciaCancelamentoValidator")
public class AntecedenciaValidator implements CancelamentoConsultaValidator {

	@Autowired
	private ConsultaRepository repository;

	@Override
	public void valida(CancelamentoConsultaDto dados) {
		var consulta = repository.getReferenceById(dados.idConsulta());
		var agora = LocalDateTime.now();

		var hoursDiff = Duration.between(agora, consulta.getData()).toHours();

		if (hoursDiff < 24)
			throw new ValidationException("A consulta só pode ser cancelada com, no mínimo, 24 horas de antecedência!");
	}
}
