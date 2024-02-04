package xlucaspx.adopet.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import xlucaspx.adopet.api.service.AdocaoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AdocaoControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private AdocaoService adocaoService;

	@Test
	@DisplayName("Deve devolver código HTTP 400 para uma solicitação de adoção inválida")
	void solicitaAdocaoCenario01() throws Exception {
		var json = "{}";

		var res =
			mvc.perform(post("/adocoes").content(json).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 para uma solicitação de adoção válida")
	void solicitaAdocaoCenario02() throws Exception {
		var json = """
			{
				"idPet": 1,
				"idTutor": 1,
				"motivo": "Motivo adoção"
			}
			""";

		var res =
			mvc.perform(post("/adocoes").content(json).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), res.getStatus());
		assertEquals("Adoção solicitada com sucesso!", res.getContentAsString());
	}
}
