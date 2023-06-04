package models;

public class Gerente extends Funcionario implements Autenticavel {
	private MetodosAutenticacao metodosAuntenticacao;

	public Gerente(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
		this.metodosAuntenticacao = new MetodosAutenticacao();
	}

	@Override
	public double getBonificacao() {
		// return super.getBonificacao() + super.getSalario(); //salario + 5%
		return 1000;
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
}
