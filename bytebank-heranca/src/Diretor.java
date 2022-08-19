
public class Diretor extends Funcionario implements Autenticavel {
	private MetodosAutenticacao metodosAuntenticacao;

	Diretor(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
		this.metodosAuntenticacao = new MetodosAutenticacao();
	}

	@Override
	public double getBonificacao() {
		return 1250;
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