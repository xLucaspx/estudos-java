package xlucaspx.adopet.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlucaspx.adopet.api.dto.AprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.ReprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.model.Adocao;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;
import xlucaspx.adopet.api.repository.PetRepository;
import xlucaspx.adopet.api.repository.TutorRepository;
import xlucaspx.adopet.api.validacoes.ValidadorSolicitacaoAdocao;

@Service
public class AdocaoService {

	@Autowired
	private AdocaoRepository adocaoRepository;
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private EmailService emailService;
	@Autowired
	private List<ValidadorSolicitacaoAdocao> validacoes;

	public void solicitaAdocao(SolicitacaoAdocaoDto dto) {
		var pet = petRepository.getReferenceById(dto.idPet());
		var tutor = tutorRepository.getReferenceById(dto.idTutor());

		validacoes.forEach(v -> v.valida(dto));

		var adocao = new Adocao();
		adocao.setData(LocalDateTime.now());
		adocao.setStatus(StatusAdocao.AGUARDANDO_AVALIACAO);
		adocao.setPet(pet);
		adocao.setTutor(tutor);
		adocao.setMotivo(dto.motivo());

		adocaoRepository.save(adocao);

		var emailAbrigo = pet.getAbrigo().getEmail();
		var assunto = "Solicitação de adoção";
		var mensagem = """
			Olá %s,\n
			Uma solicitação de adoção foi registrada hoje para o pet %s.
			Favor avaliar para aprovação ou reprovação.
			""".formatted(pet.getAbrigo().getNome(), pet.getNome());

		emailService.enviaEmail(emailAbrigo, assunto, mensagem);
	}

	public void aprovaAdocao(AprovacaoAdocaoDto dto) {
		var adocao = adocaoRepository.getReferenceById(dto.idAdocao());

		adocao.setStatus(StatusAdocao.APROVADO); // ao carregar o objeto do banco, qualquer mudança dispara o UPDATE

		var emailTutor = adocao.getTutor().getEmail();
		var assunto = "Adoção aprovada";
		var mensagem = """
			Parabéns %s!\n
			Sua adoção do pet %s, solicitada em %s, foi aprovada.
			Favor entrar em contato com o abrigo %s para agendar a busca do seu pet.
			""".formatted(adocao.getTutor().getNome(), adocao.getPet().getNome(),
				adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
				adocao.getPet().getAbrigo().getNome());

		emailService.enviaEmail(emailTutor, assunto, mensagem);
	}

	public void reprovaAdocao(ReprovacaoAdocaoDto dto) {
		var adocao = adocaoRepository.getReferenceById(dto.idAdocao());

		adocao.setStatus(StatusAdocao.REPROVADO);
		adocao.setJustificativaStatus(dto.justificativa());

		var emailTutor = adocao.getTutor().getEmail();
		var assunto = "Adoção reprovada";
		var mensagem = """
			Olá %s,\n
			Infelizmente sua adoção do pet %s, solicitada em %s, foi reprovada pelo abrigo %s com a seguinte justificativa:
			"%s"
			""".formatted(adocao.getTutor().getNome(), adocao.getPet().getNome(),
				adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
				adocao.getPet().getAbrigo().getNome(), dto.justificativa());

		emailService.enviaEmail(emailTutor, assunto, mensagem);
	}
}
