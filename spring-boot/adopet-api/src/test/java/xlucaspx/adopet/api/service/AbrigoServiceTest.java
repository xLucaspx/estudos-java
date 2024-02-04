package xlucaspx.adopet.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.exception.NaoEncontradoException;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.repository.AbrigoRepository;
import xlucaspx.adopet.api.validacoes.abrigo.ValidadorCadastroAbrigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

	@InjectMocks
	private AbrigoService service;
	@Mock
	private AbrigoRepository repository;
	@Mock
	private Abrigo abrigo;
	@Mock
	private ValidadorCadastroAbrigo validador1;
	@Mock
	private ValidadorCadastroAbrigo validador2;
	@Spy
	private List<ValidadorCadastroAbrigo> validacoes = new ArrayList<>();
	@Captor
	private ArgumentCaptor<Abrigo> abrigoCaptor;

	@Test
	@DisplayName("Deve chamar os validadores ao tentar cadastrar um abrigo")
	void validarCadastroAbrigoCenario01() {
		var dto = criaCadastroAbrigoDto();

		validacoes.add(validador1);
		validacoes.add(validador2);

		service.cadastraAbrigo(dto);

		then(validador1).should(times(1)).valida(dto);
		then(validador2).should(times(1)).valida(dto);
	}

	@Test
	@DisplayName("Deve salvar o abrigo no banco de dados ao cadastrar")
	void salvarAdocaoNoBancoCenario01() {
		var dto = criaCadastroAbrigoDto();

		var abrigoRetornado = service.cadastraAbrigo(dto);

		then(repository).should(times(1)).save(abrigoRetornado);

		assertEquals(dto.nome(), abrigoRetornado.getNome());
		assertEquals(dto.email(), abrigoRetornado.getEmail());
		assertEquals(dto.telefone(), abrigoRetornado.getTelefone());
		assertThat(abrigoRetornado.getPets()).isEmpty();
	}

	@Test
	@DisplayName("Deve retornar o abrigo de id correspondente")
	void carregaAbrigoCenario01() {
		given(abrigo.getId()).willReturn(1L);
		given(repository.findById(abrigo.getId())).willReturn(Optional.of(abrigo));

		var abrigoRetornado = service.carregaAbrigo(abrigo.getId().toString());

		assertEquals(abrigo.getId(), abrigoRetornado.getId());
	}

	@Test
	@DisplayName("Deve retornar o abrigo de nome correspondente")
	void carregaAbrigoCenario02() {
		given(abrigo.getNome()).willReturn("Abrigo Teste");
		given(repository.findByNome(abrigo.getNome())).willReturn(Optional.of(abrigo));

		var abrigoRetornado = service.carregaAbrigo(abrigo.getNome());

		assertEquals(abrigo.getId(), abrigoRetornado.getId());
	}

	@Test
	@DisplayName("Deve lançar NaoEncontradoException ao não encontrar o abrigo correspondente")
	void carregaAbrigoCenario03() {
		var idOuNome = "idOuNome";
		given(repository.findByNome(idOuNome)).willReturn(Optional.empty());

		assertThrows(NaoEncontradoException.class, () -> service.carregaAbrigo(idOuNome));
	}

	private CadastroAbrigoDto criaCadastroAbrigoDto() {
		return new CadastroAbrigoDto("Abrigo Teste", "abrigo@teste.com", "55 33445678");
	}
}
