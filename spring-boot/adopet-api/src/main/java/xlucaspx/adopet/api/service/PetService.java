package xlucaspx.adopet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.dto.pet.DetalhesPetDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.repository.PetRepository;

public class PetService {

	@Autowired
	private PetRepository petRepository;

	public Pet buscaPorId(Long id) {
		return petRepository.getReferenceById(id);
	}

	public Page<DetalhesPetDto> listaDisponiveis(Pageable paginacao) {
		return petRepository.findAllByAdotadoFalse(paginacao).map(DetalhesPetDto::new);
	}

	public Page<DetalhesPetDto> listaPorAbrigo(Long idAbrigo, Pageable paginacao) {
		return petRepository.findAllByAbrigoId(idAbrigo, paginacao).map(DetalhesPetDto::new);
	}

	public Pet cadastraPet(Abrigo abrigo, CadastroPetDto dto) {
		var pet = new Pet(dto);
		pet.setAbrigo(abrigo);

		petRepository.save(pet);

		return pet;
	}
}
