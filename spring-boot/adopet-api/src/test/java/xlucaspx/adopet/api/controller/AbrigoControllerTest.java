package xlucaspx.adopet.api.controller;

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
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.dto.abrigo.DetalhesAbrigoDto;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.dto.pet.DetalhesPetDto;
import xlucaspx.adopet.api.exception.NaoEncontradoException;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.TipoPet;
import xlucaspx.adopet.api.service.AbrigoService;
import xlucaspx.adopet.api.service.PetService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AbrigoControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private JacksonTester<CadastroAbrigoDto> cadastroAbrigoJson;
	@Autowired
	private JacksonTester<CadastroPetDto> cadastroPetJson;
	@Autowired
	private JacksonTester<DetalhesAbrigoDto> detalhesAbrigoJson;
	@Autowired
	private JacksonTester<DetalhesPetDto> detalhesPetJson;
	@MockBean
	private AbrigoService abrigoService;
	@MockBean
	private PetService petService;

	@Test
	@DisplayName("Deve devolver código HTTP 201 e detalhes do abrigo cadastrado")
	void cadastroAbrigoCenario01() throws Exception {
		var dto = new CadastroAbrigoDto("Nome Teste", "email@teste.com", "55 34567890");
		var abrigo = spy(new Abrigo(dto));

		when(abrigoService.cadastraAbrigo(dto)).thenReturn(abrigo);
		doReturn(1L).when(abrigo).getId();

		var expectedJson = detalhesAbrigoJson.write(new DetalhesAbrigoDto(abrigo)).getJson();

		var res = mvc.perform(post("/abrigos").contentType(MediaType.APPLICATION_JSON)
			.content(cadastroAbrigoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.CREATED.value(), res.getStatus());
		assertEquals(expectedJson, res.getContentAsString());
		assertEquals("http://localhost/abrigos/" + abrigo.getId(), res.getHeader("Location"));
	}

	@Test
	@DisplayName("Deve devolver código HTTP 400 para cadastro de abrigo inválido")
	void cadastroAbrigoCenario02() throws Exception {
		var dto = new CadastroAbrigoDto("Nome Teste", "email", null);

		var res = mvc.perform(post("/abrigos").contentType(MediaType.APPLICATION_JSON)
			.content(cadastroAbrigoJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 201 e detalhes do pet cadastrado")
	void cadastroPetCenario01() throws Exception {
		var dto = new CadastroPetDto("Nome Teste", "Raca Teste", "Cor Teste", 5, 5.0F, TipoPet.GATO);

		var abrigo = spy(new Abrigo(new CadastroAbrigoDto("Nome Teste", "email@teste.com", "55 34567890")));
		doReturn(1L).when(abrigo).getId();

		var pet = spy(new Pet(dto, abrigo));
		doReturn(1L).when(pet).getId();

		when(abrigoService.carregaAbrigo(abrigo.getNome())).thenReturn(abrigo);
		when(petService.cadastraPet(abrigo, dto)).thenReturn(pet);

		var expectedJson = detalhesPetJson.write(new DetalhesPetDto(pet)).getJson();

		var res = mvc.perform(post("/abrigos/{idOuNome}/pets", abrigo.getNome()).contentType(MediaType.APPLICATION_JSON)
			.content(cadastroPetJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.CREATED.value(), res.getStatus());
		assertEquals(expectedJson, res.getContentAsString());
		assertEquals("http://localhost/pets/" + pet.getId(), res.getHeader("Location"));
	}

	@Test
	@DisplayName("Deve devolver código HTTP 400 para cadastro de pet inválido")
	void cadastroPetCenario02() throws Exception {
		var dto = new CadastroPetDto("", "", "", -5, -5.0F, null);
		var idAbrigo = "idOuNome";

		var res = mvc.perform(post("/abrigos/{idOuNome}/pets", idAbrigo).contentType(MediaType.APPLICATION_JSON)
			.content(cadastroPetJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para cadastro de pet com id de abrigo inexistente")
	void cadastroPetCenario03() throws Exception {
		var dto = new CadastroPetDto("Nome Teste", "Raça Teste", "Cor Teste", 5, 5.0F, TipoPet.GATO);
		var idAbrigo = "idOuNome";

		when(abrigoService.carregaAbrigo(idAbrigo)).thenThrow(NaoEncontradoException.class);

		var res = mvc.perform(post("/abrigos/{idOuNome}/pets", idAbrigo).contentType(MediaType.APPLICATION_JSON)
			.content(cadastroPetJson.write(dto).getJson())).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 200 e detalhes do abrigo correspondente")
	void detalhaAbrigoCenario01() throws Exception {
		var abrigo = spy(new Abrigo(new CadastroAbrigoDto("Nome Teste", "email@teste.com", "55 34567890")));
		doReturn(1L).when(abrigo).getId();

		var idOuNome = abrigo.getId().toString();
		var expected = detalhesAbrigoJson.write(new DetalhesAbrigoDto(abrigo)).getJson();

		when(abrigoService.carregaAbrigo(idOuNome)).thenReturn(abrigo);

		var res = mvc.perform(get("/abrigos/{idOuNome}", idOuNome).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		assertEquals(HttpStatus.OK.value(), res.getStatus());
		assertEquals(expected, res.getContentAsString());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para abrigo não encontrado")
	void detalhaAbrigoCenario02() throws Exception {
		var idOuNome = "idOuNome";

		when(abrigoService.carregaAbrigo(idOuNome)).thenThrow(NaoEncontradoException.class);

		var res = mvc.perform(get("/abrigos/{idOuNome}", idOuNome).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}
}
