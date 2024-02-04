package xlucaspx.adopet.api.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.TipoPet;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PetRepositoryTest {

	@Autowired
	private PetRepository petRepository;
	@Autowired
	private TestEntityManager entityManager;

	@Test
	@DisplayName("Deve retornar true quando o pet de id correspondente já houver sido adotado")
	void findAdotadoByIdCenario1() {
		var expectedAdotado = true;
		var pet = cadastraPet(expectedAdotado);

		var actualAdotado = petRepository.findAdotadoById(pet.getId());

		assertThat(actualAdotado).isEqualTo(expectedAdotado);
	}

	@Test
	@DisplayName("Deve retornar false quando o pet de id correspondente não houver sido adotado")
	void findAdotadoByIdCenario2() {
		var expectedAdotado = false;
		var pet = cadastraPet(expectedAdotado);

		var actualAdotado = petRepository.findAdotadoById(pet.getId());

		assertThat(actualAdotado).isEqualTo(expectedAdotado);
	}

	@Test
	@DisplayName("Deve retornar null quando não existir pet de id correspondente")
	void findAdotadoByIdCenario3() {
		var adotado = petRepository.findAdotadoById(10L);

		assertThat(adotado).isNull();
	}

	private Pet cadastraPet(boolean adotado) {
		var abrigo = new Abrigo(new CadastroAbrigoDto("Abrigo Teste", "abrigo@teste.com", "55 33445678"));
		var pet = new Pet(new CadastroPetDto("Pet Teste", "Dog Teste", "Cor teste", 5, 5.0F, TipoPet.CACHORRO), abrigo);
		pet.setAdotado(adotado);

		entityManager.persist(abrigo);
		entityManager.persist(pet);

		return pet;
	}
}
