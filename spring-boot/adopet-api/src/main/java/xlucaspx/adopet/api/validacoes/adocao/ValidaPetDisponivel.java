package xlucaspx.adopet.api.validacoes.adocao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xlucaspx.adopet.api.dto.adocao.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.NaoEncontradoException;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.PetRepository;

@Component
public class ValidaPetDisponivel implements ValidadorSolicitacaoAdocao {
	@Autowired
	private PetRepository petRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		var petAdotado = petRepository.findAdotadoById(dto.idPet());

		if (petAdotado == null) throw new NaoEncontradoException("Nenhum pet encontrado para o id " + dto.idPet());

		if (petAdotado) throw new ValidacaoException("Pet já foi adotado!");
	}
}
