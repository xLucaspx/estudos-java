package xlucaspx.adopet.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xlucaspx.adopet.api.dto.pet.CadastroPetDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.TipoPet;
import xlucaspx.adopet.api.repository.PetRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

	@InjectMocks
	private PetService service;
	@Mock
	private PetRepository repository;
	@Mock
	private Abrigo abrigo;
	@Mock
	private Pageable paginacao;
	@Mock
	private Page<Pet> petPage;

	@Test
	@DisplayName("Deve salvar o pet no banco de dados ao cadastrar")
	void salvarPetNoBancoCenario01() {
		var dto = criaCadastroPetDto();

		var petRetornado = service.cadastraPet(abrigo, dto);

		then(repository).should(times(1)).save(petRetornado);

		assertEquals(dto.nome(), petRetornado.getNome());
		assertEquals(dto.raca(), petRetornado.getRaca());
		assertEquals(dto.cor(), petRetornado.getCor());
		assertEquals(dto.idade(), petRetornado.getIdade());
		assertEquals(dto.peso(), petRetornado.getPeso());
		assertEquals(dto.tipo(), petRetornado.getTipo());
		assertEquals(abrigo, petRetornado.getAbrigo());
		assertEquals(false, petRetornado.isAdotado());
		assertThat(petRetornado.getAdocao()).isNull();
	}

	@Test
	@DisplayName("Deve retornar o pet de id correspondente")
	void buscaPorIdCenario01() {
		var id = 1L;
		var adotado = true;
		var pet = new Pet(criaCadastroPetDto(), abrigo);
		pet.setAdotado(adotado);

		given(repository.getReferenceById(id)).willReturn(pet);

		var petRetornado = service.buscaPorId(id);

		assertEquals(pet.getNome(), petRetornado.getNome());
		assertEquals(pet.getRaca(), petRetornado.getRaca());
		assertEquals(pet.getCor(), petRetornado.getCor());
		assertEquals(pet.getIdade(), petRetornado.getIdade());
		assertEquals(pet.getPeso(), petRetornado.getPeso());
		assertEquals(pet.getTipo(), petRetornado.getTipo());
		assertEquals(pet.getAbrigo(), petRetornado.getAbrigo());
		assertEquals(pet.isAdotado(), petRetornado.isAdotado());
	}

	@Test
	@DisplayName("Deve chamar o método que lista os pets disponíveis")
	void listaDisponiveisCenario01() {
		given(repository.findAllByAdotadoFalse(paginacao)).willReturn(petPage);

		service.listaDisponiveis(paginacao);

		then(repository).should(times(1)).findAllByAdotadoFalse(paginacao);
	}

	@Test
	@DisplayName("Deve chamar o método que lista os pets por abrigo")
	void listaPorAbrigoCenario01() {
		var id = 1L;
		given(repository.findAllByAbrigoId(id, paginacao)).willReturn(petPage);

		service.listaPorAbrigo(id, paginacao);

		then(repository).should(times(1)).findAllByAbrigoId(id, paginacao);
	}

	private CadastroPetDto criaCadastroPetDto() {
		return new CadastroPetDto("Pet Teste", "Raça Teste", "Cor Teste", 5, 5.0F, TipoPet.CACHORRO);
	}
}
