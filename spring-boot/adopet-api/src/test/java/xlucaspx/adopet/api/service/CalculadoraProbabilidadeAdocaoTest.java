package xlucaspx.adopet.api.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.ProbabilidadeAdocao;
import xlucaspx.adopet.api.model.TipoPet;

class CalculadoraProbabilidadeAdocaoTest {

	@Test
	@DisplayName("Deve retornar probabilidade alta para pet jovem e com pouco peso")
	void calculaProbabilidadeAltaCenario01() {
		var abrigo = createAbrigo();
		var pet = createPet(5, 5.0f, TipoPet.CACHORRO, abrigo);

		var calculadora = new CalculadoraProbabilidadeAdocao();
		var probabilidade = calculadora.calcula(pet);

		Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);
	}

	@Test
	@DisplayName("Deve retornar probabilidade média para pet jovem e com muito peso")
	void calculaProbabilidadeMediaCenario01() {
		var abrigo = createAbrigo();
		var pet = createPet(5, 12.0f, TipoPet.GATO, abrigo);

		var calculadora = new CalculadoraProbabilidadeAdocao();
		var probabilidade = calculadora.calcula(pet);

		Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
	}

	@Test
	@DisplayName("Deve retornar probabilidade média para pet velho e com pouco peso")
	void calculaProbabilidadeMediaCenario02() {
		var abrigo = createAbrigo();
		var pet = createPet(12, 8.0f, TipoPet.GATO, abrigo);

		var calculadora = new CalculadoraProbabilidadeAdocao();
		var probabilidade = calculadora.calcula(pet);

		Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);
	}

	@Test
	@DisplayName("Deve retornar probabilidade baixa para pet velho e com muito peso")
	void calculaProbabilidadeBaixaCenario01() {
		var abrigo = createAbrigo();
		var pet = createPet(15, 16.0f, TipoPet.CACHORRO, abrigo);

		var calculadora = new CalculadoraProbabilidadeAdocao();
		var probabilidade = calculadora.calcula(pet);

		Assertions.assertEquals(ProbabilidadeAdocao.BAIXA, probabilidade);
	}

	private Abrigo createAbrigo() {
		return new Abrigo(new CadastroAbrigoDto("Abrigo", "abrigo@email.com", "51 3367-8900"));
	}

	private Pet createPet(int idade, float peso, TipoPet tipo, Abrigo abrigo) {
		return new Pet(new CadastroPetDto("Pet", "Raca", "Amarelo", idade, peso, tipo), abrigo);
	}
}
