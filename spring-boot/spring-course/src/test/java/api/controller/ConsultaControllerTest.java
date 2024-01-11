package api.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import api.domain.consulta.AgendamentoConsultaDto;
import api.domain.consulta.DetalhesConsultaDto;
import api.domain.medico.Especialidade;

@SpringBootTest // anotação para subir o contexto completo do Spring para testar as controllers
@AutoConfigureMockMvc // anotação para podermos injetar o MockMvc
class ConsultaControllerTest {

	// o controller não é injetado; para testá-lo, devemos disparar uma requição,
	// seja verdadeira (teste de integração) ou usando um mock (teste unitário).
	// Vamos usar a abordagem de teste unitário da controller, utilizando o MockMvc:
	@Autowired
	private MockMvc mvc;
	// JacksonTester é uma classe do Spring que serve para simular os dados que vamos enviar e receber da controller;
	// nos generics, passamos exatamente a classe que queremos mockar, neste caso os DTOs de agendamento e detalhes:
	@Autowired
	private JacksonTester<AgendamentoConsultaDto> agendamentoConsultaJson;
	@Autowired
	private JacksonTester<DetalhesConsultaDto> detalhesConsultaJson;

	@Test
	@DisplayName("Deve devolver código HTTP 400 quando as informações são inválidas")
	@WithMockUser // anotação para ignorar a segurança (autenticação) no teste, pois queremos testar apenas o método em si
	void agendaConsultaCenario1() throws Exception {
		// realizando requisição sem body:
		var response = mvc.perform(MockMvcRequestBuilders.post("/consultas")).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 quando as informações são válidas")
	@WithMockUser
	void agendaConsultaCenario2() throws Exception {
		var data = LocalDateTime.now().plusHours(1);

		var response = mvc.perform(MockMvcRequestBuilders.post("/consultas")
				.contentType(MediaType.APPLICATION_JSON)
				// utilizando o JacksonTester para criar o JSON
				.content(agendamentoConsultaJson.write(new AgendamentoConsultaDto(1, 1, data, Especialidade.DERMATOLOGIA))
						.getJson()))
				.andReturn()
				.getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

		var jsonEsperado = detalhesConsultaJson.write(new DetalhesConsultaDto(0, 1, 1, data)).getJson();

		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
	}

//	@Test
//	void testCancelaConsulta() {
//		fail("Not yet implemented");
//	}
}
