package xlucaspx.adopet.api.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "adocoes")
public class Adocao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	@JsonBackReference("tutor_adocoes")
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;

	@OneToOne
	@JoinColumn(name = "pet_id")
	@JsonManagedReference("adocao_pets")
	private Pet pet;

	private LocalDateTime data;
	private String motivo;

	@Enumerated(EnumType.STRING)
	private StatusAdocao status;

	@Column(name = "justificativa_status")
	private String justificativaStatus;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public StatusAdocao getStatus() {
		return status;
	}

	public void setStatus(StatusAdocao status) {
		this.status = status;
	}

	public String getJustificativaStatus() {
		return justificativaStatus;
	}

	public void setJustificativaStatus(String justificativaStatus) {
		this.justificativaStatus = justificativaStatus;
	}
}