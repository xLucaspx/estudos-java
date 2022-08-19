
public class Consultor extends Funcionario {

	Consultor(String nome, String cpf, double salario) {
		super(nome, cpf, salario);
	}

	@Override
	public double getBonificacao() {
		return 700;
	}
}