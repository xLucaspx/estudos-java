package xlucaspx.adopet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import xlucaspx.adopet.api.dto.AprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.ReprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.service.AdocaoService;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

	@Autowired
	private AdocaoService adocaoService;

	@PostMapping
	@Transactional
	public ResponseEntity<String> solicitaAdocao(@RequestBody @Valid SolicitacaoAdocaoDto dto) {
		try {
			adocaoService.solicitaAdocao(dto);
			return ResponseEntity.ok("Adoção solicitada com sucesso!");
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/aprovar")
	@Transactional
	public ResponseEntity<String> aprovar(@RequestBody @Valid AprovacaoAdocaoDto dto) {
		adocaoService.aprovaAdocao(dto);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/reprovar")
	@Transactional
	public ResponseEntity<String> reprovar(@RequestBody @Valid ReprovacaoAdocaoDto dto) {
		adocaoService.reprovaAdocao(dto);
		return ResponseEntity.ok().build();
	}
}
