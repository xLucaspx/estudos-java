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
class ValidaLimiteAdocoesTutorTest {

	@InjectMocks
	private ValidaLimiteAdocoesTutor validador;
	@Mock
	private AdocaoRepository repository;
	@Mock
	private SolicitacaoAdocaoDto dto;

	@Test
	@DisplayName("Deve permitir ao tutor com menos de 5 adoções solicitar a adoção")
	void validaCenario01() {
		BDDMockito.given(repository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(2L);

		Assertions.assertDoesNotThrow(() -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao tutor com 5 adoções solicitar a adoção")
	void validaCenario02() {
		BDDMockito.given(repository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(5L);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao tutor com mais de 5 adoções solicitar a adoção")
	void validaCenario03() {
		BDDMockito.given(repository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(7L);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}
}
