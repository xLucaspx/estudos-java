package xlucaspx.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;
import xlucaspx.adopet.api.repository.PetRepository;

public class ValidaPetComAdocaoEmAndamento implements ValidadorSolicitacaoAdocao {
	@Autowired
	private AdocaoRepository adocaoRepository;
	@Autowired
	private PetRepository petRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		var adocoes = adocaoRepository.findAll();
		var pet = petRepository.getReferenceById(dto.idPet());

		for (var adocao : adocoes) {
			if (adocao.getPet().equals(pet) && adocao.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO)
				throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
		}
	}
}
