package xlucaspx.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.PetRepository;

public class ValidaPetDisponivel implements ValidadorSolicitacaoAdocao {
	@Autowired
	private PetRepository petRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		var pet = petRepository.getReferenceById(dto.idPet());
		if (pet.getAdotado()) throw new ValidacaoException("Pet já foi adotado!");
	}
}
