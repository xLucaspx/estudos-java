package models;

public class Consultor extends Funcionario {
	public Consultor(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}

	@Override
	public double getBonificacao() {
		return 700;
	}
}
