package xlucaspx.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;
import xlucaspx.adopet.api.repository.TutorRepository;

public class ValidaTutorComAdocaoEmAndamento implements ValidadorSolicitacaoAdocao {
	@Autowired
	private AdocaoRepository adocaoRepository;
	@Autowired
	private TutorRepository tutorRepository;

	@Override
	public void valida(SolicitacaoAdocaoDto dto) {
		var adocoes = adocaoRepository.findAll();
		var tutor = tutorRepository.getReferenceById(dto.idTutor());

		for (var adocao : adocoes) {
			if (adocao.getTutor().equals(tutor) && adocao.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO)
				throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
		}
	}
}
