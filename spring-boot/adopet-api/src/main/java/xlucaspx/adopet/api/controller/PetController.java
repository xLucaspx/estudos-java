package xlucaspx.adopet.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xlucaspx.adopet.api.dto.DetalhesPetDto;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetRepository repository;

	@GetMapping
	public ResponseEntity<List<DetalhesPetDto>> listarTodosDisponiveis() {
		var pets = repository.findAll();
		var disponiveis = new ArrayList<DetalhesPetDto>();

		for (Pet pet : pets) {
			if (!pet.getAdotado()) disponiveis.add(new DetalhesPetDto(pet));
		}

		return ResponseEntity.ok(disponiveis);
	}
}
