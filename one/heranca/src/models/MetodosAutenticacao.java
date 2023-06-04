package models;

// isso se chama composição; é como se fosse uma delegação;
// quem precisa dos metodos instancia esta classe, para evitar repetição de código.
public class MetodosAutenticacao {
	private int senha;

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public boolean autentica(int senha) {
		if (this.senha == senha) {
			System.out.println("Bem vindo!");
			return true;
		} else {
			System.out.println("Senha incorreta...");
			return false;
		}
	}
}
