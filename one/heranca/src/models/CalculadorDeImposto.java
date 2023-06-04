package models;

public class CalculadorDeImposto {
	private double totalImposto;

	public double getTotalImposto() {
		return this.totalImposto;
	}

	public void registra(Tributavel operacaoTributavel) {
		double valor = operacaoTributavel.getValorImposto();
		this.totalImposto += valor;
	}
}
