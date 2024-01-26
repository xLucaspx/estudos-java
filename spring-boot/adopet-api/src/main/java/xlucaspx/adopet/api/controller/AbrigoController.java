package xlucaspx.adopet.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.dto.abrigo.DetalhesAbrigoDto;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.dto.pet.DetalhesPetDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.AbrigoRepository;
import xlucaspx.adopet.api.service.AbrigoService;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

	@Autowired
	private AbrigoRepository repository;
	@Autowired
	private AbrigoService abrigoService;

	@PostMapping
	@Transactional
	public ResponseEntity<String> cadastra(@RequestBody @Valid CadastroAbrigoDto dto) {
		try {
			abrigoService.cadastraAbrigo(dto);
			return ResponseEntity.ok("Abrigo cadastrado com sucesso!");
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/{id}/pets")
	@Transactional
	public ResponseEntity<String> cadastraPet(@PathVariable Long id, @RequestBody @Valid CadastroPetDto dto) {
		try {
			abrigoService.cadastraPet(id, dto);
			return ResponseEntity.ok("Pet cadastrado com sucesso!");
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public Page<DetalhesAbrigoDto> listaTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(DetalhesAbrigoDto::new);
	}

	@GetMapping("/{id}/pets")
	public ResponseEntity<List<DetalhesPetDto>> listaPets(@PathVariable Long id) {
		try {
			var pets = repository.getReferenceById(id).getPets();
			var lista = new ArrayList<DetalhesPetDto>();

			for (var pet : pets) lista.add(new DetalhesPetDto(pet));

			return ResponseEntity.ok(lista);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
