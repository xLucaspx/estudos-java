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
class ValidaPetComAdocaoEmAndamentoTest {

	@InjectMocks
	private ValidaPetComAdocaoEmAndamento validador;
	@Mock
	private AdocaoRepository repository;
	@Mock
	private SolicitacaoAdocaoDto dto;

	@Test
	@DisplayName("Deve permitir solicitar a adoção de pet que não possui solicitação em andamento")
	void validaCenario01() {
		BDDMockito.given(repository.existsByPetIdAndStatus(dto.idPet(),
			StatusAdocao.AGUARDANDO_AVALIACAO
		)).willReturn(false);

		Assertions.assertDoesNotThrow(() -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao solicitar a adoção de pet que possui solicitação em andamento")
	void validaCenario02() {
		BDDMockito.given(repository.existsByPetIdAndStatus(dto.idPet(),
			StatusAdocao.AGUARDANDO_AVALIACAO
		)).willReturn(true);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}
}
