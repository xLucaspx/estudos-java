package models;

// já existe uma classe que faz tudo isso e muito mais: ArrayList, do pacote java.util
public class GuardaReferencias {
	private Conta[] referencias;
	private int posicao;

	public GuardaReferencias() {
		this.referencias = new Conta[10];
		this.posicao = 0;
	}

	public void adiciona(Conta ref) {
		this.referencias[this.posicao] = ref;
		posicao++;
	}

	public Conta getReferencia(int i) {
		return this.referencias[i];
	}

	public int getQuantidadeDeContas() {
		return this.posicao;
	}
}
