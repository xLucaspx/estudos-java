package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import api.paciente.CadastroPacienteDto;
import api.paciente.DetalhesPacienteDto;
import api.paciente.ListagemPacienteDto;
import api.paciente.Paciente;
import api.paciente.PacienteRepository;
import api.paciente.UpdatePacienteDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	PacienteRepository repository;

	@GetMapping
	public ResponseEntity<Page<ListagemPacienteDto>> listaTodos(
			@PageableDefault(size = 10, page = 0, sort = "nome") Pageable paginacao) {
		var page = repository.findAll(paginacao).map(ListagemPacienteDto::new);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesPacienteDto> detalha(@PathVariable int id) {
		var paciente = repository.getReferenceById(id);
		return ResponseEntity.ok(new DetalhesPacienteDto(paciente));
	}

	@PostMapping
	public ResponseEntity<DetalhesPacienteDto> cadastra(@RequestBody @Valid CadastroPacienteDto body,
			UriComponentsBuilder uriBuilder) {
		var paciente = repository.save(new Paciente(body));

		var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

		return ResponseEntity.created(uri).body(new DetalhesPacienteDto(paciente));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DetalhesPacienteDto> atualiza(@RequestBody @Valid UpdatePacienteDto dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizaInformacoes(dados);

		return ResponseEntity.ok(new DetalhesPacienteDto(paciente));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleta(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
