package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.paciente.CadastroPacienteDto;
import api.paciente.ListagemPacienteDto;
import api.paciente.Paciente;
import api.paciente.PacienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	PacienteRepository repository;

	@GetMapping
	public Page<ListagemPacienteDto> listaTodos(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable paginacao) {
		return repository.findAll(paginacao).map(ListagemPacienteDto::new);
	}

	@PostMapping
	public void cadastra(@RequestBody @Valid CadastroPacienteDto body) {
		repository.save(new Paciente(body));
	}
}
