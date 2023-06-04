package models;

public class ContaCorrente extends Conta {
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}

	public ContaCorrente(int agencia, int numero, Cliente titular) {
		super(agencia, numero, titular);
	}

	@Override
	public void saca(double valor) throws SemSaldoException {
		double valorSaque = valor + 0.2; // taxa de saque (R$ 0.20)
		super.saca(valorSaque);
	}

	@Override
	public String toString() {
		return "Conta corrente " + super.toString();
	}
}
