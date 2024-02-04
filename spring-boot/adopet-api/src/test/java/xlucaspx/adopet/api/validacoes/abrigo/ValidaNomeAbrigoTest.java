package xlucaspx.adopet.api.validacoes.abrigo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.AbrigoRepository;

@ExtendWith(MockitoExtension.class)
class ValidaNomeAbrigoTest {

	@InjectMocks
	private ValidaNomeAbrigo validador;
	@Mock
	private AbrigoRepository repository;
	@Mock
	private CadastroAbrigoDto dto;

	@Test
	@DisplayName("Deve permitir cadastrar abrigo com nome não cadastrado")
	void validaCenario01() {
		BDDMockito.given(repository.existsByNome(dto.nome())).willReturn(false);

		Assertions.assertDoesNotThrow(() -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao tentar cadastrar abrigo com nome já cadastrado")
	void validaCenario02() {
		BDDMockito.given(repository.existsByNome(dto.nome())).willReturn(true);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}
}
