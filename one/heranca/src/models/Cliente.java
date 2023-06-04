package models;

/**
 * Classe que representa um cliente do Bytebank.
 * 
 * @author L. paz
 * @version 0.1
 */
public class Cliente implements Autenticavel {
	private String nome;
	private String cpf;
	private String profissao;
	private MetodosAutenticacao metodosAuntenticacao;

	public Cliente(String nome) {
		this.nome = nome;
		this.metodosAuntenticacao = new MetodosAutenticacao();
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
	public void setSenha(int senha) {
		this.metodosAuntenticacao.setSenha(senha);
		System.out.println(this.getNome() + ", sua senha foi alterada com sucesso.");
	}

	@Override
	public boolean autentica(int senha) {
		boolean autenticou = this.metodosAuntenticacao.autentica(senha);
		return autenticou;
	}

	@Override
	public String toString() {
		return "Cliente: " + this.getNome();
	}
}
