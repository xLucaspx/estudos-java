package api.domain.paciente;

import api.domain.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;

	@Embedded
	private Endereco endereco;

	public Paciente() {}

	public Paciente(CadastroPacienteDto dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void atualizaInformacoes(@Valid UpdatePacienteDto dados) {
		if (dados.nome() != null && !dados.nome().trim().isEmpty()) this.nome = dados.nome();
		if (dados.telefone() != null && !dados.telefone().trim().isEmpty()) this.telefone = dados.telefone();
		if (dados.endereco() != null) this.endereco = new Endereco(dados.endereco());
	}

	@Override
	public int hashCode() {
		return id * cpf.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;

		Paciente paciente = (Paciente) o;
		return id == paciente.getId() && cpf.equals(paciente.getCpf());
	}
}
