package xlucaspx.adopet.api.validacoes.tutor;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.TutorRepository;

public class ValidaTelefoneTutor implements ValidadorCadastroTutor {
	@Autowired
	private TutorRepository repository;

	@Override
	public void valida(CadastroTutorDto dto) {
		if (repository.existsByTelefone(dto.telefone())) throw new ValidacaoException("Telefone do tutor já cadastrado!");
	}
}
