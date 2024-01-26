package xlucaspx.adopet.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.repository.AbrigoRepository;
import xlucaspx.adopet.api.validacoes.abrigo.ValidadorCadastroAbrigo;

public class AbrigoService {

	@Autowired
	private AbrigoRepository repository;
	@Autowired
	private List<ValidadorCadastroAbrigo> validacoes;

	public void cadastraAbrigo(CadastroAbrigoDto dto) {
		validacoes.forEach(v -> v.valida(dto));

		var abrigo = new Abrigo(dto);
		repository.save(abrigo);
	}

	public void cadastraPet(Long idAbrigo, CadastroPetDto dto) {
		var abrigo = repository.getReferenceById(idAbrigo);
		var pet = new Pet(dto);
		pet.setAbrigo(abrigo);

		abrigo.addPet(pet);
	}
}
