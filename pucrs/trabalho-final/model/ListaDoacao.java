package model;

import java.util.Arrays;
import java.util.Objects;

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

	public Doacao[] getDoacoesPorQuantidade(double quantidade) {
		Doacao[] doacoes = new Doacao[index]; // criando lista que será retornada; apenas posições preenchidas

		for (int i = 0; i < index; i++) {
			if (lista[i].getQuantidade() >= quantidade) {
				doacoes[i] = lista[i];
			}
		}

		// retornando array preenchido sem posições nulas
		return Arrays.stream(doacoes).filter(Objects::nonNull).toArray(Doacao[]::new);
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
	 * Método para buscar uma doação na lista de doações; busca pela descrição informada utilizando o método
	 * <code>equalsIgnoreCase</code> da classe String.
	 *
	 * @param descricao A descrição da doação sendo buscada
	 * @return O objeto da Doacao encontrada ou null caso a descrição seja nula ou nenhuma doação seja encontrada para a
	 * descrição
	 * informada
	 */
	public Doacao buscaPorDescricao(String descricao) {
		if (descricao == null) {
			return null;
		}

		for (int i = 0; i < index; i++) {
			if (lista[i].getDescricao().equalsIgnoreCase(descricao)) {
				return lista[i];
			}
		}
		return null;
	}

	/**
	 * @param descricao  A descrição da doação a qual se deseja adicionar a quantidade; não pode ser nula
	 * @param quantidade A quantidade a ser adicionada à doação; deve ser maior do que zero
	 * @return Falso caso a descrição seja nula, a doação não seja encontrada ou a quantidade seja inválida; verdadeiro
	 * em caso de sucesso
	 */
	public boolean adiciona(String descricao, double quantidade) {
		Doacao doacao = buscaPorDescricao(descricao);

		if (doacao == null) {
			return false;
		}

		return doacao.adiciona(quantidade);
	}

	/**
	 * @param descricao  A descrição da doação a qual se deseja subtrair a quantidade; não pode ser nula
	 * @param quantidade A quantidade a ser subtraída da doação; deve ser maior do que zero
	 * @return Falso caso a descrição seja nula, a doação não seja encontrada ou a quantidade seja inválida; verdadeiro
	 * em caso de sucesso
	 */
	public boolean remove(String descricao, double quantidade) {
		Doacao doacao = buscaPorDescricao(descricao);

		if (doacao == null) {
			return false;
		}

		return doacao.remove(quantidade);
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
