package xlucaspx.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;
import xlucaspx.adopet.api.repository.TutorRepository;

public class ValidaLimiteAdocoesTutor implements ValidadorSolicitacaoAdocao {
	@Autowired
	private AdocaoRepository adocaoRepository;
	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		var adocoes = adocaoRepository.findAll();
		var tutor = tutorRepository.getReferenceById(dto.idTutor());

		int contador = 0;
		for (var adocao : adocoes) {
			if (adocao.getTutor().equals(tutor) && adocao.getStatus() == StatusAdocao.APROVADO) contador++;

			if (contador == 5) throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
		}
	}
}
