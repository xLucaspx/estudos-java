package xlucaspx.adopet.api.validacoes.adocao;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.adocao.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.PetRepository;

public class ValidaPetDisponivel implements ValidadorSolicitacaoAdocao {
	@Autowired
	private PetRepository petRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		var petAdotado = petRepository.findAdotadoById(dto.idPet());

		if (petAdotado) throw new ValidacaoException("Pet já foi adotado!");
	}
}
