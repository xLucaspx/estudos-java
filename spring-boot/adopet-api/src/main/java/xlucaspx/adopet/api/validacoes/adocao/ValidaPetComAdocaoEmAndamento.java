package xlucaspx.adopet.api.validacoes.adocao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xlucaspx.adopet.api.dto.adocao.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;

@Component
public class ValidaPetComAdocaoEmAndamento implements ValidadorSolicitacaoAdocao {
	@Autowired
	private AdocaoRepository adocaoRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		if (adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO))
			throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
	}
}
