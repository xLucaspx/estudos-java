package xlucaspx.adopet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.tutor.AtualizacaoTutorDto;
import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;
import xlucaspx.adopet.api.model.Tutor;
import xlucaspx.adopet.api.repository.TutorRepository;
import xlucaspx.adopet.api.validacoes.tutor.ValidadorCadastroTutor;

public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private List<ValidadorCadastroTutor> validacoes;

	public void cadastraTutor(CadastroTutorDto dto) {
		validacoes.forEach(v -> v.valida(dto));

		var tutor = new Tutor(dto);
		tutorRepository.save(tutor);
	}

	public void atualizaTutor(AtualizacaoTutorDto dto) {
		var tutor = tutorRepository.getReferenceById(dto.id());
		tutor.setEmail(dto.email());
		tutor.setTelefone(dto.telefone());
	}
}
