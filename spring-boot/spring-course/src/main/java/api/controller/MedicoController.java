package api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.medico.MedicoDto;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@PostMapping
	public void cadastra(@RequestBody MedicoDto body) {
		System.out.println(body);
	}
}
