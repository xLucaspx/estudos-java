package xlucaspx.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;

public class ValidaLimiteAdocoesTutor implements ValidadorSolicitacaoAdocao {
	@Autowired
	private AdocaoRepository adocaoRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		var totalAdocoes = adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);

		if (totalAdocoes >= 5) throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
	}
}
