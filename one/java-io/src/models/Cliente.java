package models;

import java.io.Serializable;

// Serializable é uma interface de marcação: funciona semelhante a uma anotação
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String profissao;

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "Cliente: " + this.getNome();
	}
}
