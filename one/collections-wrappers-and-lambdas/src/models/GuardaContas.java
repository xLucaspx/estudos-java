package models;

public class GuardaContas {
	private Conta[] contas;
	private int posicao;

	public GuardaContas() {
		this.contas = new Conta[10];
		this.posicao = 0; // int já inicia com zero, mas assim deixamos explícito
	}

	public void adicionaConta(Conta conta) {
		this.contas[this.posicao] = conta;
		posicao++;
	}

	public Conta getConta(int i) {
		return this.contas[i];
	}

	public int getQuantidadeDeContas() {
		return this.posicao; // se a posição está em 1 é porque temos 1 elemento na posiçõa 0, e por aí vai
	}
}
