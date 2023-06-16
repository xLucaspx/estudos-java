package models;

public class Leitor {
	private String nome;
	private String cpf;
	private Endereco endereco;

	public Leitor(String nome, String cpf, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s\nCPF: %s\nEndereço: %s", nome, cpf, endereco);
	}
}
