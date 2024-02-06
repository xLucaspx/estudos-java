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
import xlucaspx.adopet.api.dto.adocao.AprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.adocao.ReprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.adocao.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.model.Abrigo;
import xlucaspx.adopet.api.model.Adocao;
import xlucaspx.adopet.api.model.Pet;
import xlucaspx.adopet.api.model.Tutor;
import xlucaspx.adopet.api.repository.AdocaoRepository;
import xlucaspx.adopet.api.repository.PetRepository;
import xlucaspx.adopet.api.repository.TutorRepository;
import xlucaspx.adopet.api.validacoes.adocao.ValidadorSolicitacaoAdocao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

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
	private Adocao adocao;
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

	@Test
	@DisplayName("Deve chamar os validadores ao solicitar adoção")
	void validarSolicitacaoAdocaoCenario01() {
		var dto = new SolicitacaoAdocaoDto(1L, 1L, "Motivo adoção");

		given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
		given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
		given(pet.getAbrigo()).willReturn(abrigo);

		validacoes.add(validador1);
		validacoes.add(validador2);

		service.solicitaAdocao(dto);

		then(validador1).should(times(1)).valida(dto);
		then(validador2).should(times(1)).valida(dto);
	}

	@Test
	@DisplayName("Deve salvar a adoção no banco de dados ao solicitar")
	void salvarAdocaoNoBancoCenario01() {
		var dto = new SolicitacaoAdocaoDto(1L, 1L, "Motivo adoção");

		given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
		given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
		given(pet.getAbrigo()).willReturn(abrigo);

		service.solicitaAdocao(dto);

		then(adocaoRepository).should(times(1)).save(adocaoCaptor.capture());
		var adocaoSalva = adocaoCaptor.getValue();

		assertEquals(pet, adocaoSalva.getPet());
		assertEquals(tutor, adocaoSalva.getTutor());
		assertEquals(dto.motivo(), adocaoSalva.getMotivo());
	}

	@Test
	@DisplayName("Deve chamar método de enviar e-mail ao solicitar adoção")
	void enviarEmailSolicitacaoCenario01() {
		var dto = new SolicitacaoAdocaoDto(1L, 1L, "Motivo adoção");

		given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
		given(tutorRepository.getReferenceById(dto.idTutor())).willReturn(tutor);
		given(pet.getAbrigo()).willReturn(abrigo);

		service.solicitaAdocao(dto);

		var assunto = "Solicitação de adoção";
		var mensagem = """
			Olá %s,\n
			Uma solicitação de adoção foi registrada hoje para o pet %s.
			Favor avaliar para aprovação ou reprovação.
			""".formatted(abrigo.getNome(), pet.getNome());

		then(emailService).should(times(1)).enviaEmail(abrigo.getEmail(), assunto, mensagem);
	}

	@Test
	@DisplayName("Deve aprovar a adoção de id correspondente")
	void aprovarAdocaoCenario01() {
		var dto = new AprovacaoAdocaoDto(1L);

		given(adocaoRepository.getReferenceById(dto.idAdocao())).willReturn(adocao);
		given(adocao.getTutor()).willReturn(tutor);
		given(adocao.getPet()).willReturn(pet);
		given(adocao.getData()).willReturn(LocalDateTime.now());
		given(pet.getAbrigo()).willReturn(abrigo);

		service.aprovaAdocao(dto);

		then(adocao).should(times(1)).aprovar();
	}

	@Test
	@DisplayName("Deve chamar método de enviar e-mail ao aprovar adoção")
	void enviarEmailAprovacaoCenario01() {
		var dto = new AprovacaoAdocaoDto(1L);

		given(adocaoRepository.getReferenceById(dto.idAdocao())).willReturn(adocao);
		given(adocao.getTutor()).willReturn(tutor);
		given(adocao.getPet()).willReturn(pet);
		given(adocao.getData()).willReturn(LocalDateTime.now());
		given(pet.getAbrigo()).willReturn(abrigo);

		service.aprovaAdocao(dto);

		var assunto = "Adoção aprovada";
		var mensagem = """
			Parabéns %s!\n
			Sua adoção do pet %s, solicitada em %s, foi aprovada.
			Favor entrar em contato com o abrigo %s para agendar a busca do seu pet.
			""".formatted(tutor.getNome(),
			pet.getNome(),
			adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
			abrigo.getNome()
		);

		then(emailService).should(times(1)).enviaEmail(tutor.getEmail(), assunto, mensagem);
	}

	@Test
	@DisplayName("Deve reprovar a adoção de id correspondente")
	void reprovarAdocaoCenario01() {
		var dto = new ReprovacaoAdocaoDto(1L, "Justificativa teste.");

		given(adocaoRepository.getReferenceById(dto.idAdocao())).willReturn(adocao);
		given(adocao.getTutor()).willReturn(tutor);
		given(adocao.getPet()).willReturn(pet);
		given(adocao.getData()).willReturn(LocalDateTime.now());
		given(pet.getAbrigo()).willReturn(abrigo);

		service.reprovaAdocao(dto);

		then(adocao).should(times(1)).reprovar(dto.justificativa());
	}

	@Test
	@DisplayName("Deve chamar método de enviar e-mail ao reprovar adoção")
	void enviarEmailReprovacaoCenario01() {
		var dto = new ReprovacaoAdocaoDto(1L, "Justificativa teste.");

		given(adocaoRepository.getReferenceById(dto.idAdocao())).willReturn(adocao);
		given(adocao.getTutor()).willReturn(tutor);
		given(adocao.getPet()).willReturn(pet);
		given(adocao.getData()).willReturn(LocalDateTime.now());
		given(pet.getAbrigo()).willReturn(abrigo);

		service.reprovaAdocao(dto);

		var assunto = "Adoção reprovada";
		var mensagem = """
			Olá %s,\n
			Infelizmente sua adoção do pet %s, solicitada em %s, foi reprovada pelo abrigo %s com a seguinte justificativa:
			"%s"
			""".formatted(tutor.getNome(),
			pet.getNome(),
			adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
			abrigo.getNome(),
			dto.justificativa()
		);

		then(emailService).should(times(1)).enviaEmail(tutor.getEmail(), assunto, mensagem);
	}
}
