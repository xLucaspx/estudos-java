package models;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(int agencia, int numero, Cliente titular) {
		super(agencia, numero);
		super.setTitular(titular);
	}
}
