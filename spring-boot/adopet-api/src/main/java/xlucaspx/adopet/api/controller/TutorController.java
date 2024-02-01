package xlucaspx.adopet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import xlucaspx.adopet.api.dto.tutor.AtualizacaoTutorDto;
import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;
import xlucaspx.adopet.api.dto.tutor.DetalhesTutorDto;
import xlucaspx.adopet.api.service.TutorService;

@RestController
@RequestMapping("/tutores")
public class TutorController {

	@Autowired
	private TutorService tutorService;

	@PostMapping
	@Transactional
	public ResponseEntity<DetalhesTutorDto> cadastra(@RequestBody @Valid CadastroTutorDto dto,
			UriComponentsBuilder uriBuilder) {
		var tutor = tutorService.cadastraTutor(dto);

		var uri = uriBuilder.path("/tutores/{id}").buildAndExpand(tutor.getId()).toUri();

		return ResponseEntity.created(uri).body(new DetalhesTutorDto(tutor));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DetalhesTutorDto> atualiza(@RequestBody @Valid AtualizacaoTutorDto dto) {
		var tutor = tutorService.atualizaTutor(dto);
		return ResponseEntity.ok(new DetalhesTutorDto(tutor));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesTutorDto> detalha(@PathVariable Long id) {
		var tutor = tutorService.buscaPorId(id);
		return ResponseEntity.ok(new DetalhesTutorDto(tutor));
	}
}
