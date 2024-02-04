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
import xlucaspx.adopet.api.exception.NaoEncontradoException;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
class ValidaPetDisponivelTest {

	// A anotação @InjectMocks deve ser adicionada apenas ao objeto que se deseja instanciar e injetar nele os mocks.
	@InjectMocks
	private ValidaPetDisponivel validador;
	@Mock
	private PetRepository repository;
	@Mock
	private SolicitacaoAdocaoDto dto;

	@Test
	@DisplayName("Deve permitir solicitar a adoção de um pet disponível")
	void validaCenario01() {
		// ARRANGE
		BDDMockito.given(repository.findAdotadoById(dto.idPet())).willReturn(false);

		// ACT + ASSERT
		Assertions.assertDoesNotThrow(() -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao solicitar a adoção de um pet indisponível")
	void validaCenario02() {
		BDDMockito.given(repository.findAdotadoById(dto.idPet())).willReturn(true);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar NaoEncontradoException ao solicitar a adoção de um pet inexistente")
	void validaCenario03() {
		BDDMockito.given(repository.findAdotadoById(dto.idPet())).willReturn(null);

		Assertions.assertThrows(NaoEncontradoException.class, () -> validador.valida(dto));
	}
}
