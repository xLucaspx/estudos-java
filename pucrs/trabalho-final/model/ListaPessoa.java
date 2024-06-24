package model;

public class ListaPessoa {
	private int index;
	private int tamanho;
	private Pessoa[] lista;

	public ListaPessoa() {
		index = 0;
		tamanho = 10; // lista inicia com 10 posições
		lista = new Pessoa[tamanho];
	}

	public Pessoa[] getPessoas() {
		Pessoa[] pessoas = new Pessoa[index]; // criando lista apenas com doações preenchidas

		for (int i = 0; i < index; i++) {
			pessoas[i] = lista[i];
		}

		return pessoas;
	}

	public boolean cadastraPessoa(Pessoa pessoa) {
		if (pessoa == null) {
			return false;
		}

		if (existePessoaDuplicada(pessoa)) {
			return false;
		}

		if (index == tamanho) {
			// se a lista estiver cheia, dobra-se seu tamanho e copia-se os elementos para a nova lista
			expandeLista();
		}

		lista[index] = pessoa;
		index++;
		return true;
	}

	/**
	 * Método para buscar uma pessoa na lista de pessoas
	 *
	 * @param cpf O CPF da pessoa sendo buscada
	 * @return O objeto da Pessoa encontrada ou null caso nenhuma pessoa seja encontrada para o CPF informado
	 */
	public Pessoa buscaPorCpf(String cpf) {
		for (int i = 0; i < index; i++) {
			if (lista[i].getCpf().equals(cpf)) {
				return lista[i];
			}
		}
		return null;
	}

	/**
	 * Método para alterar o e-mail de uma pessoa na lista de pessoas
	 *
	 * @param cpf       O CPF da pessoa que deseja alterar o e-mail
	 * @param novoEmail O novo e-mail que será cadastrado
	 * @return Falso caso a pessoa não esteja na lista, verdadeiro caso o e-mail seja alterado com sucesso
	 * @throws IllegalArgumentException Se o e-mail inserido for inválido
	 */
	public boolean alteraEmail(String cpf, String novoEmail) {
		Pessoa pessoa = buscaPorCpf(cpf);

		if (pessoa == null) {
			return false;
		}

		pessoa.setEmail(novoEmail);
		return true;
	}

	/**
	 * Dobra o tamanho da lista e passa todos os elementos, na ordem em que se encontram, para a nova lista
	 */
	private void expandeLista() {
		tamanho *= 2; // dobrando o tamanho da lista
		Pessoa[] novaLista = new Pessoa[tamanho];

		// copiando conteúdo da lista antiga para a nova
		for (int i = 0; i < index; i++) {
			novaLista[i] = lista[i];
		}

		// substituindo lista antiga
		lista = novaLista;
	}

	/**
	 * @param pessoa A pessoa para ser verificada
	 * @return Verdadeiro caso a pessoa já esteja na lista, falso caso contrário
	 */
	private boolean existePessoaDuplicada(Pessoa pessoa) {
		for (int i = 0; i < index; i++) {
			if (lista[i].getCpf().equals(pessoa.getCpf())) {
				return true;
			}
		}
		return false;
	}
}
