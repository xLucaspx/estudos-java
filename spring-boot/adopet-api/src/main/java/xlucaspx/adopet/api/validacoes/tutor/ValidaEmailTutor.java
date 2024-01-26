package xlucaspx.adopet.api.validacoes.tutor;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.TutorRepository;

public class ValidaEmailTutor implements ValidadorCadastroTutor {
	@Autowired
	private TutorRepository repository;

	@Override
	public void valida(CadastroTutorDto dto) {
		if (repository.existsByEmail(dto.email())) throw new ValidacaoException("E-mail do tutor já cadastrado!");
	}
}
