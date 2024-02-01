package xlucaspx.adopet.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.dto.abrigo.DetalhesAbrigoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.repository.AbrigoRepository;
import xlucaspx.adopet.api.validacoes.abrigo.ValidadorCadastroAbrigo;

public class AbrigoService {

	@Autowired
	private AbrigoRepository repository;
	@Autowired
	private List<ValidadorCadastroAbrigo> validacoes;

	public Page<DetalhesAbrigoDto> listaTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(DetalhesAbrigoDto::new);
	}

	public Abrigo carregaAbrigo(String idOuNome) {
		Optional<Abrigo> optional;

		try {
			var id = Long.parseLong(idOuNome);
			optional = repository.findById(id);
		} catch (NumberFormatException e) {
			optional = repository.findByNome(idOuNome);
		}

		return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado"));
	}

	public Abrigo cadastraAbrigo(CadastroAbrigoDto dto) {
		validacoes.forEach(v -> v.valida(dto));

		var abrigo = new Abrigo(dto);
		repository.save(abrigo);
		
		return abrigo;
	}
}
