package api.domain.medico;

import api.domain.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "medicos")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	private boolean ativo;

	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	@Embedded
	private Endereco endereco;

	public Medico() {}

	public Medico(CadastroMedicoDto dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.crm = dados.crm();
		this.especialidade = dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
		this.ativo = true;
	}

	public int getId() {
		return id;
	}

	public String getCrm() {
		return crm;
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void desativa() {
		this.ativo = false;
	}

	public void atualizaInformacoes(@Valid UpdateMedicoDto dados) {
		if (dados.nome() != null && !dados.nome().trim().isEmpty()) this.nome = dados.nome();
		if (dados.telefone() != null && !dados.telefone().trim().isEmpty()) this.telefone = dados.telefone();
		if (dados.endereco() != null) this.endereco = new Endereco(dados.endereco());
	}

	@Override
	public int hashCode() {
		return id * crm.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (this.getClass() != o.getClass()) return false;

		Medico medico = (Medico) o;
		return id == medico.getId() && crm.equals(medico.getCrm());
	}
}
