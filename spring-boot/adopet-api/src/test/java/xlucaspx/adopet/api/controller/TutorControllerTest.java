package xlucaspx.adopet.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import xlucaspx.adopet.api.dto.tutor.AtualizacaoTutorDto;
import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;
import xlucaspx.adopet.api.dto.tutor.DetalhesTutorDto;
import xlucaspx.adopet.api.model.Tutor;
import xlucaspx.adopet.api.service.TutorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class TutorControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private JacksonTester<CadastroTutorDto> cadastroTutorJson;
	@Autowired
	private JacksonTester<AtualizacaoTutorDto> atualizacaoTutorJson;
	@Autowired
	private JacksonTester<DetalhesTutorDto> detalhesTutorJson;
	@MockBean
	private TutorService service;

	@Test
	@DisplayName("Deve devolver código HTTP 201 e detalhes do tutor cadastrado")
	void cadastroTutorCenario01() throws Exception {
		var dto = criaCadastroTutorDto();
		var tutor = spy(new Tutor(dto));

		doReturn(1L).when(tutor).getId();
		when(service.cadastraTutor(dto)).thenReturn(tutor);

		var expectedJson = detalhesTutorJson.write(new DetalhesTutorDto(tutor)).getJson();

		var res = mvc.perform(post("/tutores").contentType(MediaType.APPLICATION_JSON)
			.content(cadastroTutorJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.CREATED.value(), res.getStatus());
		assertEquals(expectedJson, res.getContentAsString());
		assertEquals("http://localhost/tutores/" + tutor.getId(), res.getHeader("Location"));
	}

	@Test
	@DisplayName("Deve devolver código HTTP 400 para cadastro de tutor inválido")
	void cadastroTutorCenario02() throws Exception {
		var dto = new CadastroTutorDto("Nome Teste", "email", null);

		var res = mvc.perform(post("/tutores").contentType(MediaType.APPLICATION_JSON)
			.content(cadastroTutorJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 para uma atualização de tutor válida")
	void atualizacaoTutorCenario01() throws Exception {
		var tutor = spy(new Tutor(criaCadastroTutorDto()));
		doReturn(1L).when(tutor).getId();

		var dto = new AtualizacaoTutorDto(tutor.getId(), tutor.getEmail(), tutor.getTelefone());

		when(service.atualizaTutor(dto)).thenReturn(tutor);

		var expectedJson = detalhesTutorJson.write(new DetalhesTutorDto(tutor)).getJson();

		var res = mvc.perform(put("/tutores").contentType(MediaType.APPLICATION_JSON)
			.content(atualizacaoTutorJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), res.getStatus());
		assertEquals(expectedJson, res.getContentAsString());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 400 para uma atualização de tutor inválida")
	void atualizacaoTutorCenario02() throws Exception {
		var dto = new AtualizacaoTutorDto(null, null, "111111111111111");

		var res = mvc.perform(put("/tutores").contentType(MediaType.APPLICATION_JSON)
			.content(atualizacaoTutorJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para uma atualização de tutor inexistente")
	void atualizacaoTutorCenario03() throws Exception {
		var dto = new AtualizacaoTutorDto(10L, "email@teste.com", "55 999876544");

		when(service.atualizaTutor(dto)).thenThrow(EntityNotFoundException.class);

		var res = mvc.perform(put("/tutores").contentType(MediaType.APPLICATION_JSON)
			.content(atualizacaoTutorJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}

	private CadastroTutorDto criaCadastroTutorDto() {
		return new CadastroTutorDto("Nome Teste", "email@teste.com", "55 999876544");
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 e detalhes do tutor correspondente")
	void detalhaTutorCenario01() throws Exception {
		var tutor = spy(new Tutor(criaCadastroTutorDto()));
		doReturn(1L).when(tutor).getId();

		var expected = detalhesTutorJson.write(new DetalhesTutorDto(tutor)).getJson();

		when(service.buscaPorId(tutor.getId())).thenReturn(tutor);

		var res = mvc.perform(get("/tutores/{id}", tutor.getId()).contentType(MediaType.APPLICATION_JSON))
			.andReturn()
			.getResponse();

		assertEquals(HttpStatus.OK.value(), res.getStatus());
		assertEquals(expected, res.getContentAsString());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para tutor não encontrado")
	void detalhaTutorCenario02() throws Exception {
		var id = 1L;

		when(service.buscaPorId(id)).thenThrow(EntityNotFoundException.class);

		var res = mvc.perform(get("/tutores/{id}", id).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}
}
