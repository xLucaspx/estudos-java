package api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.domain.consulta.AgendaDeConsultas;
import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.consulta.DetalhesConsultaDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
public class ConsultaController {
	
	@Autowired private AgendaDeConsultas agenda;

	@PostMapping
	@Transactional
	public ResponseEntity<DetalhesConsultaDto> agendaConsulta(@RequestBody @Valid AgendamentoConsultaDto dados) {
		agenda.agendaConsulta(dados);
		return ResponseEntity.ok(new DetalhesConsultaDto(0, dados.idMedico(), dados.idPaciente(), dados.data()));
	}
}
