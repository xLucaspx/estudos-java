package xlucaspx.adopet.api.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import xlucaspx.adopet.api.dto.tutor.CadastroTutorDto;

@Entity
@Table(name = "tutores")
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String telefone;

	@OneToMany(mappedBy = "tutor")
	private List<Adocao> adocoes;

	public Tutor() {
	}

	public Tutor(CadastroTutorDto dto) {
		setNome(dto.nome());
		setEmail(dto.email());
		setTelefone(dto.telefone());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Adocao> getAdocoes() {
		return adocoes;
	}

	public void setAdocoes(List<Adocao> adocoes) {
		this.adocoes = adocoes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tutor tutor = (Tutor) o;
		return Objects.equals(id, tutor.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
