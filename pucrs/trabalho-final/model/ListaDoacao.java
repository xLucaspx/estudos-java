package model;

public class ListaDoacao {
	private int index;
	private int tamanho;
	private Doacao[] lista;

	public ListaDoacao() {
		index = 0;
		tamanho = 10; // lista inicia com 10 posições
		lista = new Doacao[tamanho];
	}

	public Doacao[] getDoacoes() {
		Doacao[] doacoes = new Doacao[index]; // criando lista apenas com doações preenchidas

		for (int i = 0; i < index; i++) {
			doacoes[i] = lista[i];
		}

		return doacoes;
	}

	/**
	 * @param doacao A doação que será cadastrada
	 * @return Falso caso a doação seja nula ou duplicada, verdadeiro em caso de sucesso
	 */
	public boolean cadastraDoacao(Doacao doacao) {
		if (doacao == null) {
			return false;
		}

		if (existeDoacaoDuplicada(doacao)) {
			return false;
		}

		if (index == tamanho) {
			// se a lista estiver cheia, dobra-se seu tamanho e copia-se os elementos para a nova lista
			expandeLista();
		}

		lista[index] = doacao;
		index++;
		return true;
	}

	/**
	 * Dobra o tamanho da lista e passa todos os elementos, na ordem em que se encontram, para a nova lista
	 */
	private void expandeLista() {
		tamanho *= 2; // dobrando o tamanho da lista
		Doacao[] novaLista = new Doacao[tamanho];

		// copiando conteúdo da lista antiga para a nova
		for (int i = 0; i < index; i++) {
			novaLista[i] = lista[i];
		}

		// substituindo lista antiga
		lista = novaLista;
	}

	/**
	 * @param doacao A doação para ser verificada
	 * @return Verdadeiro caso a doação já esteja na lista, falso caso contrário
	 */
	private boolean existeDoacaoDuplicada(Doacao doacao) {
		for (int i = 0; i < index; i++) {
			if (lista[i].getCodigo() == doacao.getCodigo()) {
				return true;
			}
		}
		return false;
	}
}
