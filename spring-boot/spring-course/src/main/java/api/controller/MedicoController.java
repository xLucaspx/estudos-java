package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.medico.Medico;
import api.medico.MedicoDto;
import api.medico.MedicoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired // este atributo será injetado pelo Spring
	private MedicoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastra(@RequestBody MedicoDto dados) {
		repository.save(new Medico(dados));
	}
}
