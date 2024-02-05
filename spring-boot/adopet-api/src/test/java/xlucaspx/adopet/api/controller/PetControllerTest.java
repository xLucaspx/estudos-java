package xlucaspx.adopet.api.controller;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.dto.pet.DetalhesPetDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.TipoPet;
import xlucaspx.adopet.api.service.PetService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class PetControllerTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private JacksonTester<DetalhesPetDto> detalhesPetJson;
	@MockBean
	private PetService petService;
	@Mock
	private Abrigo abrigo;

	@Test
	@DisplayName("Deve devolver código HTTP 200 e detalhes do pet correspondente")
	void detalhaPetCenario01() throws Exception {
		var pet = spy(new Pet(new CadastroPetDto("Nome Teste", "Raca Teste", "Cor Teste", 5, 5.0F, TipoPet.GATO), abrigo));
		doReturn(1L).when(pet).getId();

		var expected = detalhesPetJson.write(new DetalhesPetDto(pet)).getJson();

		when(petService.buscaPorId(pet.getId())).thenReturn(pet);

		var res = mvc.perform(get("/pets/{id}", pet.getId()).contentType(MediaType.APPLICATION_JSON))
			.andReturn()
			.getResponse();

		assertEquals(HttpStatus.OK.value(), res.getStatus());
		assertEquals(expected, res.getContentAsString());
	}

	@Test
	@DisplayName("Deve devolver código HTTP 404 para abrigo não encontrado")
	void detalhaPetCenario02() throws Exception {
		var id = 1L;

		when(petService.buscaPorId(id)).thenThrow(EntityNotFoundException.class);

		var res = mvc.perform(get("/pets/{id}", id).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		assertEquals(HttpStatus.NOT_FOUND.value(), res.getStatus());
	}
}
