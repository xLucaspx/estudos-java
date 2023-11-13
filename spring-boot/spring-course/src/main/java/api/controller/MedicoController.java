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

import api.medico.CadastroMedicoDto;
import api.medico.DetalhesMedicoDto;
import api.medico.ListagemMedicoDto;
import api.medico.Medico;
import api.medico.MedicoRepository;
import api.medico.UpdateMedicoDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired // este atributo será injetado pelo Spring
	private MedicoRepository repository;

//	@GetMapping
//	public List<ListagemMedicoDto> listaTodos() {
//		// ListagemMedicoDto tem um construtor que recebe um objeto Medico, então podemos fazer um map passando esse
//		// contrutor para nos devolver uma Stream de ListegemMedicoDto, que depois convertemos para List e retornamos
//		// o Spring se encarrega de serializar os objetos da lista para JSON
//		return repository.findAll().stream().map(ListagemMedicoDto::new).toList();
//	}

	@GetMapping
	public ResponseEntity<Page<ListagemMedicoDto>> listaTodos(
			// a anotação @PageableDefault sobrescreve o pardrão do Spring, mas pode ser sobrescrita pela URL
			@PageableDefault(size = 10, page = 0, sort = { "nome", "especialidade" }) Pageable paginacao) {
		// para fazer a paginação precisamos utilizar como parâmetro a interface Pageable e devolver, ao ivés de uma List,
		// um objeto Page, que contém as informações da paginação; é possível controlar a paginação passando query params na
		// url, ex: ?size=5&page=0 (5 itens por página, primeira página)
//		return repository.findAll(paginacao).map(ListagemMedicoDto::new);

		var page = repository.findAllByAtivoTrue(paginacao).map(ListagemMedicoDto::new);
		return ResponseEntity.ok(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesMedicoDto> detalha(@PathVariable int id) {
		var medico = repository.getReferenceById(id);
		return ResponseEntity.ok(new DetalhesMedicoDto(medico));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<DetalhesMedicoDto> cadastra(@RequestBody @Valid CadastroMedicoDto dados,
			UriComponentsBuilder uriBuilder) {
		var medico = repository.save(new Medico(dados)); // ao salvar é definido um id para a entidade

		// se declararmos um UriComponentsBuilder como parâmetro do método, esse objeto é passado automaticamente pelo
		// Spring; além disso, ele encapsula a URI do prjeto e evita que tenhamos que alterar de "localhost..." quando for
		// realizado o deploy. Para o método path() passamos apenas o recurso e para o buildAndExpand os parâmetros:
		var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

		// o método created() já cria o cabeçalho Location automaticamente quando passamos a URI
		return ResponseEntity.created(uri).body(new DetalhesMedicoDto(medico));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DetalhesMedicoDto> atualiza(@RequestBody @Valid UpdateMedicoDto dados) {
		var medico = repository.getReferenceById(dados.id());
		// como estamos usando JPA, ao colocar a anotação @Transactional no método
		// basta atualizar os campos da entidade que a JPA faz a atualização no banco
		medico.atualizaInformacoes(dados);

		return ResponseEntity.ok(new DetalhesMedicoDto(medico));
	}

	// para passar parâmetros na URL, colocamos o nome do parâmetro entre chaves
	// dentro da anotação do método, e o recebemos com a anotação @PathVariable:
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleta(@PathVariable int id) {
		// exclusão física, removendo o registro do banco:
//		repository.deleteById(id);

		// exclusão lógica, apenas declarando como inativo:
		var medico = repository.getReferenceById(id);
		medico.desativa();

		return ResponseEntity.noContent().build();
	}
}
