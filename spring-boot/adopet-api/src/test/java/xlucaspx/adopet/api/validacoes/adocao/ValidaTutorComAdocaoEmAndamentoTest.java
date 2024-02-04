package xlucaspx.adopet.api.validacoes.adocao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xlucaspx.adopet.api.dto.adocao.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;

@ExtendWith(MockitoExtension.class)
class ValidaTutorComAdocaoEmAndamentoTest {

	@InjectMocks
	private ValidaTutorComAdocaoEmAndamento validador;
	@Mock
	private AdocaoRepository repository;
	@Mock
	private SolicitacaoAdocaoDto dto;

	@Test
	@DisplayName("Deve permitir ao tutor que não possui solicitação em andamento solicitar a adoção")
	void validaCenario01() {
		BDDMockito.given(repository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(
			false);

		Assertions.assertDoesNotThrow(() -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao tutor que possui solicitação em andamento solicitar a adoção")
	void validaCenario02() {
		BDDMockito.given(repository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(
			true);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}
}
