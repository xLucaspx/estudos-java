package api.domain.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.domain.consulta.validacoes.AgendamentoConsultaValidator;
import api.domain.exceptions.ValidationException;
import api.domain.medico.Medico;
import api.domain.medico.MedicoRepository;
import api.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsultas {

	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	// ao criar uma lista da interface e anotá-la com @Autowired,
	// o Spring irá criar essa lista com todas as implementações encontradas desta interface
	@Autowired
	private List<AgendamentoConsultaValidator> validators;

	public DetalhesConsultaDto agendaConsulta(AgendamentoConsultaDto dados) {
		if (!pacienteRepository.existsById(dados.idPaciente()))
			throw new ValidationException("Nenhum paciente encontrado para o ID informado!");

		// se estiver utilizando um wrapper deve fazer idMedico != null
		if (dados.idMedico() != 0 && !medicoRepository.existsById(dados.idMedico()))
			throw new ValidationException("Nenhum médico encontrado para o ID informado!");

		validators.forEach(v -> v.valida(dados));

		// precisamos colocar o .get() para obter a entidade pois o findById retorna um Optional; devemos utilizá-lo quando
		// queremos manipular a entidade. Quando queremos, por exemplo, apenas atribuí-la, utilizamos o getReferenceById():
		var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
		var medico = escolheMedico(dados);

		if (medico == null)
			throw new ValidationException("Não há médicos disponíveis neste horário para a especialidade informada!");

		var consulta = new Consulta(paciente, medico, dados.data());
		consultaRepository.save(consulta);

		return new DetalhesConsultaDto(consulta);
	}

	public void cancelaConsulta(CancelamentoConsultaDto dados) {
		if (!consultaRepository.existsById(dados.idConsulta()))
			throw new ValidationException("Nenhuma consulta encontrada para o ID informado!");

		var consulta = consultaRepository.getReferenceById(dados.idConsulta());
		consulta.cancela(dados.motivo());
	}

	private Medico escolheMedico(AgendamentoConsultaDto dados) {
		if (dados.idMedico() != 0) return medicoRepository.getReferenceById(dados.idMedico());

		if (dados.especialidade() == null)
			throw new ValidationException("Selecione um médico ou uma especialidade para agendar a consulta!");

		return medicoRepository.escolheMedicoLivreNaDataPorEspecialidade(dados.data(), dados.especialidade());
	}
}
