package xlucaspx.adopet.api.controller;

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
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.dto.abrigo.DetalhesAbrigoDto;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.dto.pet.DetalhesPetDto;
import xlucaspx.adopet.api.service.AbrigoService;
import xlucaspx.adopet.api.service.PetService;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

	@Autowired
	private AbrigoService abrigoService;
	@Autowired
	private PetService petService;

	@PostMapping
	@Transactional
	public ResponseEntity<DetalhesAbrigoDto> cadastra(@RequestBody @Valid CadastroAbrigoDto dto,
			UriComponentsBuilder uriBuilder) {
		var abrigo = abrigoService.cadastraAbrigo(dto);

		var uri = uriBuilder.path("/abrigos/{idOuNome}").buildAndExpand(abrigo.getId()).toUri();

		return ResponseEntity.created(uri).body(new DetalhesAbrigoDto(abrigo));
	}

	@PostMapping("/{idOuNome}/pets")
	@Transactional
	public ResponseEntity<DetalhesPetDto> cadastraPet(@PathVariable String idOuNome,
			@RequestBody @Valid CadastroPetDto dto, UriComponentsBuilder uriBuilder) {
		var abrigo = abrigoService.carregaAbrigo(idOuNome);
		var pet = petService.cadastraPet(abrigo, dto);

		var uri = uriBuilder.path("/pets/{id}").buildAndExpand(pet.getId()).toUri();

		return ResponseEntity.created(uri).body(new DetalhesPetDto(pet));
	}

	@GetMapping
	public ResponseEntity<Page<DetalhesAbrigoDto>> listaTodos(Pageable paginacao) {
		var page = abrigoService.listaTodos(paginacao);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{idOuNome}")
	public ResponseEntity<DetalhesAbrigoDto> detalha(@PathVariable String idOuNome) {
		var abrigo = abrigoService.carregaAbrigo(idOuNome);
		return ResponseEntity.ok(new DetalhesAbrigoDto(abrigo));
	}

	@GetMapping("/{idOuNome}/pets")
	public ResponseEntity<Page<DetalhesPetDto>> listaPets(@PathVariable String idOuNome, Pageable paginacao) {
		var abrigo = abrigoService.carregaAbrigo(idOuNome);
		var page = petService.listaPorAbrigo(abrigo.getId(), paginacao);
		return ResponseEntity.ok(page);
	}
}
