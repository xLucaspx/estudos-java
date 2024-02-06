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
import xlucaspx.adopet.api.dto.adocao.AprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.adocao.ReprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.adocao.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.service.AdocaoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AdocaoControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private JacksonTester<SolicitacaoAdocaoDto> solicitacaoAdocaoJson;
	@Autowired
	private JacksonTester<AprovacaoAdocaoDto> aprovacaoAdocaoJson;
	@Autowired
	private JacksonTester<ReprovacaoAdocaoDto> reprovacaoAdocaoJson;
	@MockBean
	private AdocaoService adocaoService;

	@Test
	@DisplayName("Deve devolver código HTTP 201 para uma solicitação de adoção válida")
	void solicitaAdocaoCenario01() throws Exception {
		var dto = new SolicitacaoAdocaoDto(1L, 1L, "Motivo adoção");

		var res = mvc.perform(post("/adocoes").contentType(MediaType.APPLICATION_JSON)
			.content(solicitacaoAdocaoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.CREATED.value(), res.getStatus());
		assertEquals("Adoção solicitada com sucesso!", res.getContentAsString());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 400 para uma solicitação de adoção inválida")
	void solicitaAdocaoCenario02() throws Exception {
		var json = "{}";

		var res = mvc.perform(post("/adocoes").contentType(MediaType.APPLICATION_JSON).content(json))
			.andReturn()
			.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para uma solicitação de adoção com id de pet/tutor inexistente")
	void solicitaAdocaoCenario03() throws Exception {
		var dto = new SolicitacaoAdocaoDto(1L, 1L, "Motivo adoção");

		doThrow(EntityNotFoundException.class).when(adocaoService).solicitaAdocao(dto);

		var res = mvc.perform(post("/adocoes").contentType(MediaType.APPLICATION_JSON)
			.content(solicitacaoAdocaoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 para uma aprovação de adoção válida")
	void aprovaAdocaoCenario01() throws Exception {
		var dto = new AprovacaoAdocaoDto(1L);

		var res = mvc.perform(put("/adocoes/aprovar").contentType(MediaType.APPLICATION_JSON)
			.content(aprovacaoAdocaoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), res.getStatus());
		assertEquals("Adoção aprovada com sucesso!", res.getContentAsString());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 400 para uma aprovação de adoção inválida")
	void aprovaAdocaoCenario02() throws Exception {
		// POST sem body
		var res = mvc.perform(put("/adocoes/aprovar").contentType(MediaType.APPLICATION_JSON))
			.andReturn()
			.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para uma aprovação de adoção com id inexistente")
	void aprovaAdocaoCenario03() throws Exception {
		var dto = new AprovacaoAdocaoDto(1L);

		doThrow(EntityNotFoundException.class).when(adocaoService).aprovaAdocao(dto);

		var res = mvc.perform(put("/adocoes/aprovar").contentType(MediaType.APPLICATION_JSON)
			.content(aprovacaoAdocaoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 para uma reprovação de adoção válida")
	void reprovaAdocaoCenario01() throws Exception {
		var dto = new ReprovacaoAdocaoDto(1L, "Justificativa Teste");

		var res = mvc.perform(put("/adocoes/reprovar").contentType(MediaType.APPLICATION_JSON)
			.content(reprovacaoAdocaoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), res.getStatus());
		assertEquals("Adoção reprovada com sucesso!", res.getContentAsString());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 400 para uma reprovação de adoção inválida")
	void reprovaAdocaoCenario02() throws Exception {
		var json = "{}";

		var res = mvc.perform(put("/adocoes/reprovar").contentType(MediaType.APPLICATION_JSON).content(json))
			.andReturn()
			.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para uma reprovação de adoção com id inexistente")
	void reprovaAdocaoCenario03() throws Exception {
		var dto = new ReprovacaoAdocaoDto(1L, "Justificativa Teste");

		doThrow(EntityNotFoundException.class).when(adocaoService).reprovaAdocao(dto);

		var res = mvc.perform(put("/adocoes/reprovar").contentType(MediaType.APPLICATION_JSON)
			.content(reprovacaoAdocaoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}
}
