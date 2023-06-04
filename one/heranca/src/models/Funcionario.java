package models;

//não é possível instanciar uma classe abstrata
public abstract class Funcionario {
	private String nome;
	private String cpf;
	private double salario;
	// protected double salario;
	private static int totalDeFuncionarios;

	public Funcionario(String nome, String cpf, double salario) {
		totalDeFuncionarios++;
		setNome(nome);
		setCpf(cpf);
		setSalario(salario);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public static int getTotalDeFuncionarios() {
		return Funcionario.totalDeFuncionarios;
	}

	// metodo abstrato: sem corpo, não há implementação aqui, apenas nos filhos:

	public abstract double getBonificacao();

	// metodo de bonificação substituido (não temos mais uma bonificação padrão):

	// public double getBonificacao() {
	// return this.salario * 0.05; // 5% de bonificação
	// }
}
