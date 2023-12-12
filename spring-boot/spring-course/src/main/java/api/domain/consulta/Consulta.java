package api.domain.consulta;

import java.time.LocalDateTime;

import api.domain.medico.Medico;
import api.domain.paciente.Paciente;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultas")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_medico")
	private Medico medico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	private LocalDateTime data;

	public Consulta() {}

	public Consulta(int id, Medico medico, Paciente paciente, LocalDateTime data) {
		this.id = id;
		this.medico = medico;
		this.paciente = paciente;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public Medico getMedico() {
		return medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public LocalDateTime getData() {
		return data;
	}

	@Override
	public int hashCode() {
		return id * medico.hashCode() * paciente.hashCode() * data.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;

		Consulta consulta = (Consulta) o;
		return id == consulta.getId();
	}
}
