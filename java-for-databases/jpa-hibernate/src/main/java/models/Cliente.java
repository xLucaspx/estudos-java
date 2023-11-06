package models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Embedded //informando à JPA que os atributos de DadosPessoais são colunas de Cliente
	private DadosPessoais dadosPessoais;

	public Cliente() {}

	public Cliente(String nome, String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public Cliente(long id, String nome, String cpf) {
		this.id = id;
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return dadosPessoais.nome();
	}

	public String getCpf() {
		return dadosPessoais.cpf();
	}

	@Override
	public String toString() {
		return String.format("cliente: { id: %d, nome: \"%s\", cpf: \"%s\" }", id, getNome(), getCpf());
	}
}
