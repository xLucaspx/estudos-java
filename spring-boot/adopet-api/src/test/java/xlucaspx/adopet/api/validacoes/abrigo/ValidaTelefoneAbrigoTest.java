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
class ValidaTelefoneAbrigoTest {

	@InjectMocks
	private ValidaTelefoneAbrigo validador;
	@Mock
	private AbrigoRepository repository;
	@Mock
	private CadastroAbrigoDto dto;

	@Test
	@DisplayName("Deve permitir cadastrar abrigo com telefone não cadastrado")
	void validaCenario01() {
		BDDMockito.given(repository.existsByTelefone(dto.telefone())).willReturn(false);

		Assertions.assertDoesNotThrow(() -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao tentar cadastrar abrigo com telefone já cadastrado")
	void validaCenario02() {
		BDDMockito.given(repository.existsByTelefone(dto.telefone())).willReturn(true);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}
}
