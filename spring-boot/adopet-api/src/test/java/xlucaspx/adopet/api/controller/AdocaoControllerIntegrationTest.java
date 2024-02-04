package xlucaspx.adopet.api.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled("Desativado até que seja necessário realizar testes de integração")
class AdocaoControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("Deve devolver código HTTP 400 para uma solicitação de adoção inválida")
	void solicitaAdocaoCenario01() {
		var json = "{}";
		var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		var res = restTemplate.exchange("/adocoes", HttpMethod.POST, new HttpEntity<>(json, headers), Void.class);

		assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 para uma solicitação de adoção válida")
	void solicitaAdocaoCenario02() {
		var json = """
			{
				"idPet": 4,
				"idTutor": 2,
				"motivo": "Motivo adoção"
			}
			""";
		var headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		var res = restTemplate.exchange("/adocoes", HttpMethod.POST, new HttpEntity<>(json, headers), Void.class);

		assertEquals(HttpStatus.OK, res.getStatusCode());
	}
}
