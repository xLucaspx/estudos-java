package xlucaspx.adopet.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlucaspx.adopet.api.dto.AprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.ReprovacaoAdocaoDto;
import xlucaspx.adopet.api.dto.SolicitacaoAdocaoDto;
import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.Adocao;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;
import xlucaspx.adopet.api.repository.PetRepository;
import xlucaspx.adopet.api.repository.TutorRepository;

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

	public void solicitaAdocao(SolicitacaoAdocaoDto dto) {
		var pet = petRepository.getReferenceById(dto.idPet());
		var tutor = tutorRepository.getReferenceById(dto.idTutor());

		if (pet.getAdotado()) throw new ValidacaoException("Pet já foi adotado!");

		var adocoes = adocaoRepository.findAll();
		int contador = 0;

		for (Adocao a : adocoes) {
			if (a.getTutor().equals(tutor) && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO)
				throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");

			if (a.getPet().equals(pet) && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO)
				throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");

			if (a.getTutor().equals(tutor) && a.getStatus() == StatusAdocao.APROVADO) contador++;

			if (contador == 5) throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
		}

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
