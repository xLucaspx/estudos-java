package xlucaspx.adopet.api.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adocoes")
public class Adocao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Tutor tutor;

	@OneToOne(fetch = FetchType.LAZY)
	private Pet pet;

	private LocalDateTime data;
	private String motivo;

	@Enumerated(EnumType.STRING)
	private StatusAdocao status;

	private String justificativaStatus;

	public Adocao() {}

	public Adocao(Tutor tutor, Pet pet, String motivo) {
		this.setPet(pet);
		this.setTutor(tutor);
		this.setMotivo(motivo);
		this.setData(LocalDateTime.now());
		this.setStatus(StatusAdocao.AGUARDANDO_AVALIACAO);
	}

	public void aprovar() {
		setStatus(StatusAdocao.APROVADO);
	}

	public void reprovar(String justificativa) {
		setStatus(StatusAdocao.REPROVADO);
		this.justificativaStatus = justificativa;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getData() {
		return data;
	}

	private void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tutor getTutor() {
		return tutor;
	}

	private void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Pet getPet() {
		return pet;
	}

	private void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getMotivo() {
		return motivo;
	}

	private void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public StatusAdocao getStatus() {
		return status;
	}

	private void setStatus(StatusAdocao status) {
		this.status = status;
	}

	public String getJustificativaStatus() {
		return justificativaStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Adocao adocao = (Adocao) o;
		return Objects.equals(id, adocao.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
