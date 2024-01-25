package xlucaspx.adopet.api.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	JavaMailSender emailSender;

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

		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("adopet@email.com.br");
		email.setTo(adocao.getPet().getAbrigo().getEmail());
		email.setSubject("Solicitação de adoção");
		email.setText("Olá " + adocao.getPet().getAbrigo().getNome()
				+ "!\n\nUma solicitação de adoção foi registrada hoje para o pet: " + adocao.getPet().getNome()
				+ ". \nFavor avaliar para aprovação ou reprovação.");
		emailSender.send(email);
	}

	public void aprovaAdocao(Adocao adocao) {
		adocao.setStatus(StatusAdocao.APROVADO);
		repository.save(adocao);

		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("adopet@email.com.br");
		email.setTo(adocao.getTutor().getEmail());
		email.setSubject("Adoção aprovada");
		email.setText("Parabéns " + adocao.getTutor().getNome() + "!\n\nSua adoção do pet " + adocao.getPet().getNome()
				+ ", solicitada em " + adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
				+ ", foi aprovada.\nFavor entrar em contato com o abrigo " + adocao.getPet().getAbrigo().getNome()
				+ " para agendar a busca do seu pet.");
		emailSender.send(email);
	}

	public void reprovaAdocao(Adocao adocao) {
		adocao.setStatus(StatusAdocao.REPROVADO);
		repository.save(adocao);

		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("adopet@email.com.br");
		email.setTo(adocao.getTutor().getEmail());
		email.setSubject("Adoção reprovada");
		email.setText("Olá " + adocao.getTutor().getNome() + "!\n\nInfelizmente sua adoção do pet "
				+ adocao.getPet().getNome() + ", solicitada em "
				+ adocao.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + ", foi reprovada pelo abrigo "
				+ adocao.getPet().getAbrigo().getNome() + " com a seguinte justificativa: " + adocao.getJustificativaStatus());
		emailSender.send(email);
	}
}
