package xlucaspx.adopet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xlucaspx.adopet.api.dto.pet.DetalhesPetDto;
import xlucaspx.adopet.api.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping
	public ResponseEntity<Page<DetalhesPetDto>> listaTodosDisponiveis(Pageable paginacao) {
		var page = petService.listaDisponiveis(paginacao);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesPetDto> detalha(@PathVariable Long id) {
		var pet = petService.buscaPorId(id);
		return ResponseEntity.ok(new DetalhesPetDto(pet));
	}
}
