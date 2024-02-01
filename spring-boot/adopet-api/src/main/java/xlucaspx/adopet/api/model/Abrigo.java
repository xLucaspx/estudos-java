package xlucaspx.adopet.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import xlucaspx.adopet.api.dto.abrigo.CadastroAbrigoDto;

@Entity
@Table(name = "abrigos")
public class Abrigo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String telefone;

	@OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL)
	private List<Pet> pets;

	public Abrigo() {}

	public Abrigo(CadastroAbrigoDto dto) {
		setNome(dto.nome());
		setEmail(dto.email());
		setTelefone(dto.telefone());
		this.pets = new ArrayList<>();
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

	public List<Pet> getPets() {
		return pets;
	}

	public void addPet(Pet pet) {
		pets.add(pet);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Abrigo abrigo = (Abrigo) o;
		return Objects.equals(id, abrigo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
