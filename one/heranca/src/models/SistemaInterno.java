package models;

public class SistemaInterno {
	private int senha;

	public SistemaInterno(int senha) {
		this.senha = senha;
	}

	public void autentica(Autenticavel admin) {
		admin.autentica(this.senha);
	}
}
