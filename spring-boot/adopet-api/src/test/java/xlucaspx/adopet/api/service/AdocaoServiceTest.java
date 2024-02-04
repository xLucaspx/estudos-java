package xlucaspx.adopet.api.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import xlucaspx.adopet.api.dto.adocao.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Adocao;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.Tutor;
import xlucaspx.adopet.api.repository.AdocaoRepository;
import xlucaspx.adopet.api.repository.PetRepository;
import xlucaspx.adopet.api.repository.TutorRepository;
import xlucaspx.adopet.api.validacoes.adocao.ValidadorSolicitacaoAdocao;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AdocaoServiceTest {

	@InjectMocks
	private AdocaoService service;
	@Mock
	private AdocaoRepository adocaoRepository;
	@Mock
	private PetRepository petRepository;
	@Mock
	private TutorRepository tutorRepository;
	@Mock
	private EmailService emailService;
	@Mock
	private Tutor tutor;
	@Mock
	private Abrigo abrigo;
	@Mock
	private Pet pet;
	@Mock
	private ValidadorSolicitacaoAdocao validador1;
	@Mock
	private ValidadorSolicitacaoAdocao validador2;
	@Spy
	// o spy simula um objeto real instanciado, com os métodos funcionando normalmente; seu diferencial é que conseguimos
	// controlar seu comportamento na chamada; o mock, pos sua vez, apenas registra a chamada dos métodos.
	// Neste caso, se não instanciarmos a lista, será uma implementação do Mockito;
	private List<ValidadorSolicitacaoAdocao> validacoes = new ArrayList<>();
	@Captor
	private ArgumentCaptor<Adocao> adocaoCaptor;

	private SolicitacaoAdocaoDto dto;

	@Test
	@DisplayName("Deve salvar a adoção no banco de dados ao solicitar")
	void salvarAdocaoNoBancoCenario01() {
		this.dto = new SolicitacaoAdocaoDto(1L, 1L, "Motivo adoção");

		given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
		given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
		given(pet.getAbrigo()).willReturn(abrigo);

		service.solicitaAdocao(dto);

		then(adocaoRepository).should().save(adocaoCaptor.capture());
		var adocaoSalva = adocaoCaptor.getValue();

		assertEquals(pet, adocaoSalva.getPet());
		assertEquals(tutor, adocaoSalva.getTutor());
		assertEquals(dto.motivo(), adocaoSalva.getMotivo());
	}

	@Test
	@DisplayName("Deve chamar os validadores ao solicitar adoção")
	void validarSolicitacaoAdocaoCenario01() {
		this.dto = new SolicitacaoAdocaoDto(1L, 1L, "Motivo adoção");

		given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
		given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
		given(pet.getAbrigo()).willReturn(abrigo);

		validacoes.add(validador1);
		validacoes.add(validador2);

		service.solicitaAdocao(dto);

		then(validador1).should().valida(dto);
		then(validador2).should().valida(dto);
	}
}
