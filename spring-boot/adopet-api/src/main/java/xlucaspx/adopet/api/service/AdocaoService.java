package xlucaspx.adopet.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xlucaspx.adopet.api.exception.ValidacaoException;
import xlucaspx.adopet.api.model.Adocao;
import xlucaspx.adopet.api.model.StatusAdocao;
import xlucaspx.adopet.api.repository.AdocaoRepository;

@Service
public class AdocaoService {

	@Autowired
	private AdocaoRepository repository;
	@Autowired
	private EmailService emailService;

	public void solicitaAdocao(Adocao adocao) {
		if (adocao.getPet().getAdotado() == true) throw new ValidacaoException("Pet já foi adotado!");

		List<Adocao> adocoes = repository.findAll();
		int contador = 0;

		for (Adocao a : adocoes) {
			if (a.getTutor() == adocao.getTutor() && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO)
				throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");

			if (a.getPet() == adocao.getPet() && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO)
				throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");

			if (a.getTutor() == adocao.getTutor() && a.getStatus() == StatusAdocao.APROVADO) contador++;

			if (contador == 5) throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
		}

		adocao.setData(LocalDateTime.now());
		adocao.setStatus(StatusAdocao.AGUARDANDO_AVALIACAO);
		repository.save(adocao);

		var emailAbrigo = adocao.getPet().getAbrigo().getEmail();
		var assunto = "Solicitação de adoção";
		var mensagem = """
			Olá %s,\n
			Uma solicitação de adoção foi registrada hoje para o pet %s.
			Favor avaliar para aprovação ou reprovação.
			""".formatted(adocao.getPet().getAbrigo().getNome(), adocao.getPet().getNome());

		emailService.enviaEmail(emailAbrigo, assunto, mensagem);
	}

	public void aprovaAdocao(Adocao adocao) {
		adocao.setStatus(StatusAdocao.APROVADO);
		repository.save(adocao);

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

	public void reprovaAdocao(Adocao adocao) {
		adocao.setStatus(StatusAdocao.REPROVADO);
		repository.save(adocao);

		var emailTutor = adocao.getTutor().getEmail();
		var assunto = "Adoção reprovada";
		var mensagem = """
			Olá %s,\n
			Infelizmente sua adoção do pet %s, solicitada em %s, foi reprovada pelo abrigo %s com a seguinte justificativa:
			"%s"
			""".formatted(adocao.getTutor().getNome(), adocao.getPet().getNome(),
				adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
				adocao.getPet().getAbrigo().getNome(), adocao.getJustificativaStatus());

		emailService.enviaEmail(emailTutor, assunto, mensagem);
	}
}
