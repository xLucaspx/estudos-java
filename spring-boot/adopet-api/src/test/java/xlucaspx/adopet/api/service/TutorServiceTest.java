package xlucaspx.adopet.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import xlucaspx.adopet.api.dto.tutor.AtualizacaoTutorDto;
import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;
import xlucaspx.adopet.api.model.Tutor;
import xlucaspx.adopet.api.repository.TutorRepository;
import xlucaspx.adopet.api.validacoes.tutor.ValidadorCadastroTutor;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class TutorServiceTest {

	@InjectMocks
	private TutorService service;
	@Mock
	private TutorRepository repository;
	@Mock
	private ValidadorCadastroTutor validador1;
	@Mock
	private ValidadorCadastroTutor validador2;
	@Spy
	private List<ValidadorCadastroTutor> validacoes = new ArrayList<>();


	@Test
	@DisplayName("Deve chamar os validadores ao tentar cadastrar um tutor")
	void validarCadastroTutorCenario01() {
		var dto = new CadastroTutorDto("Tutor Teste", "tutor@teste.com", "55 99876-0099");

		validacoes.add(validador1);
		validacoes.add(validador2);

		service.cadastraTutor(dto);

		validacoes.forEach(v -> then(v).should(times(1)).valida(dto));
	}

	@Test
	@DisplayName("Deve salvar o tutor no banco de dados ao cadastrar")
	void salvarTutorNoBancoCenario01() {
		var dto = criaCadastroTutorDto();

		var tutorRetornado = service.cadastraTutor(dto);

		then(repository).should(times(1)).save(tutorRetornado);

		assertEquals(dto.nome(), tutorRetornado.getNome());
		assertEquals(dto.email(), tutorRetornado.getEmail());
		assertEquals(dto.telefone(), tutorRetornado.getTelefone());
		assertThat(tutorRetornado.getAdocoes()).isEmpty();
	}

	@Test
	@DisplayName("Deve salvar o tutor no banco de dados ao atualizar")
	void salvarTutorNoBancoCenario02() {
		var tutor = new Tutor(criaCadastroTutorDto());
		var dto = new AtualizacaoTutorDto(1L, "novoemail@teste.com", "55 99876-0099");

		given(repository.getReferenceById(dto.id())).willReturn(tutor);

		var tutorRetornado = service.atualizaTutor(dto);

		assertEquals(dto.email(), tutorRetornado.getEmail());
		assertEquals(dto.telefone(), tutorRetornado.getTelefone());
	}

	@Test
	@DisplayName("Deve retornar o tutor de id correspondente")
	void buscaPorIdCenario01() {
		var id = 1L;
		var tutor = new Tutor(criaCadastroTutorDto());

		given(repository.getReferenceById(id)).willReturn(tutor);

		var tutorRetornado = service.buscaPorId(id);

		assertEquals(tutor.getNome(), tutorRetornado.getNome());
		assertEquals(tutor.getEmail(), tutorRetornado.getEmail());
		assertEquals(tutor.getTelefone(), tutorRetornado.getTelefone());
	}

	private CadastroTutorDto criaCadastroTutorDto() {
		return new CadastroTutorDto("Tutor Teste", "tutor@teste.com", "55 99876-0099");
	}
}
