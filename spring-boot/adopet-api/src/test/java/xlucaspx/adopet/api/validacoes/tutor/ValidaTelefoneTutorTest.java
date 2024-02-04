package xlucaspx.adopet.api.validacoes.tutor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.repository.TutorRepository;

@ExtendWith(MockitoExtension.class)
class ValidaTelefoneTutorTest {

	@InjectMocks
	private ValidaTelefoneTutor validador;
	@Mock
	private TutorRepository repository;
	@Mock
	private CadastroTutorDto dto;

	@Test
	@DisplayName("Deve permitir cadastrar tutor com telefone não cadastrado")
	void validaCenario01() {
		BDDMockito.given(repository.existsByTelefone(dto.telefone())).willReturn(false);

		Assertions.assertDoesNotThrow(() -> validador.valida(dto));
	}

	@Test
	@DisplayName("Deve lançar ValidacaoException ao tentar cadastrar tutor com telefone já cadastrado")
	void validaCenario02() {
		BDDMockito.given(repository.existsByTelefone(dto.telefone())).willReturn(true);

		Assertions.assertThrows(ValidacaoException.class, () -> validador.valida(dto));
	}
}
