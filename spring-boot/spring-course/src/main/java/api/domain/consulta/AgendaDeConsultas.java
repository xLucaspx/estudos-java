package api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void agendaConsulta(AgendamentoConsultaDto dados) {
		if (!pacienteRepository.existsById(dados.idPaciente()))
			throw new ValidationException("Nenhum paciente encontrado para o ID informado!");

		// se estiver utilizando um wrapper deve fazer idMedico != null
		if (dados.idMedico() != 0 && !medicoRepository.existsById(dados.idMedico()))
			throw new ValidationException("Nenhum médico encontrado para o ID informado!");

		// precisamos colocar o .get() para obter a entidade pois o findById retorna um Optional; devemos utilizá-lo quando
		// queremos manipular a entidade. Quando queremos, por exemplo, apenas atribuí-la, utilizamos o getReferenceById():
		var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
		var medico = escolheMedico(dados);

		var consulta = new Consulta(paciente, medico, dados.data());
		System.out.println(medico.getNome());
		System.out.println(paciente.getNome());
		System.out.println(dados);
		consultaRepository.save(consulta);
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
