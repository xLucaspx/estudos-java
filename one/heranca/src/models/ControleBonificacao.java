package models;

public class ControleBonificacao {
	private double soma;

	public void registraBonificacao(Funcionario f) {
		double bonificacao = f.getBonificacao();
		this.soma += bonificacao;
	}

	public double getSoma() {
		return this.soma;
	}
}
