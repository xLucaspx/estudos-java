package models;

public class Designer extends Funcionario {

	public Designer(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}

	@Override
	public double getBonificacao() {
		// return super.getBonificacao() + 500; // bonificação padrão + R$ 500,00
		return 400;
	}
}
