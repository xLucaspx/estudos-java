package xlucaspx.adopet.api.validacoes.abrigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.AbrigoRepository;

@Component
public class ValidaEmailAbrigo implements ValidadorCadastroAbrigo {
	@Autowired
	private AbrigoRepository repository;

	@Override
	public void valida(CadastroAbrigoDto dto) {
		if (repository.existsByEmail(dto.email())) throw new ValidacaoException("E-mail do abrigo já cadastrado!");
	}
}
