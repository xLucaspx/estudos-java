package models;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}

	public ContaPoupanca(int agencia, int numero, Cliente titular) {
		super(agencia, numero, titular);
	}

	@Override
	public String toString() {
		return "Conta poupança " + super.toString();
	}
}
