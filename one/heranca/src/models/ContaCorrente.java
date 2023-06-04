package models;

public class ContaCorrente extends Conta implements Tributavel {
	public ContaCorrente(int agencia, int numero, Cliente titular) {
		super(agencia, numero);
		super.setTitular(titular);
	}

	@Override
	public void saca(double valor) throws SemSaldoException {
		double valorSaque = valor + 0.2; // taxa de saque (R$ 0.20)
		super.saca(valorSaque);
	}

	@Override
	public double getValorImposto() {
		return super.getSaldo() * 0.025; // 2.5% do saldo total
	}
}
