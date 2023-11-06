package api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.paciente.PacienteDto;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@PostMapping
	public void cadastra(@RequestBody PacienteDto body) {
		System.out.println(body);
	}
}
