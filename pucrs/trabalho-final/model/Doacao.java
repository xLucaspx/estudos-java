package model;

public class Doacao {
	private int codigo;
	private String descricao;
	private double quantidade;

	/**
	 * Construtor para instanciar um objeto do tipo Doacao
	 *
	 * @param codigo     O código da doação sendo cadastrada; deve ser maior do que zero.
	 * @param descricao  A descrição da doação sendo cadastrada; não pode ser nula ou vazia.
	 * @param quantidade A quantidade da doação sendo cadastrada; deve ser maior do que zero.
	 * @throws IllegalArgumentException Caso qualquer dos valores passados seja nulo ou inválido.
	 */
	public Doacao(int codigo, String descricao, double quantidade) {
		// utilizando os métodos set para encapsular as validações
		setCodigo(codigo);
		setDescricao(descricao);
		setQuantidade(quantidade);
	}

	/**
	 * @param quantidade A quantidade a ser adicionada; deve ser maior do que zero
	 * @return Falso caso a quantidade seja inválida, verdadeiro caso contrário
	 */
	public boolean adiciona(double quantidade) {
		if (quantidade <= 0) {
			return false;
		}
		this.quantidade += quantidade;
		return true;
	}

	/**
	 * @param quantidade A quantidade a ser removida; deve ser maior do que zero e menor do que a quantidade disponível
	 * @return Falso caso a quantidade seja inválida, verdadeiro caso contrário
	 */
	public boolean remove(double quantidade) {
		if (quantidade <= 0 || quantidade > this.quantidade) {
			return false;
		}
		this.quantidade -= quantidade;
		return true;
	}

	public int getCodigo() {
		return codigo;
	}

	// os métodos setCodigo e setQuantidade são privado pois o código da doação não deve ser alterado após sua
	// inicialização e a quantidade deve ser modificada pelos métodos adiciona e remove

	/**
	 * @param codigo O código da doação sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja menor ou igual a zero
	 */
	private void setCodigo(int codigo) {
		if (codigo <= 0) {
			throw new IllegalArgumentException("O código da doação deve ser um número maior que zero!");
		}

		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao A descrição da doação sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja nulo ou vazio
	 */
	public void setDescricao(String descricao) {
		if (descricao == null || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("A descrição deve ser preenchida!");
		}

		this.descricao = descricao.trim();
	}

	public double getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade A quantidade da doação sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja menor ou igual a zero
	 */
	private void setQuantidade(double quantidade) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade deve ser maior do que zero!");
		}

		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return """
			Doação:
				Código: %05d,
				Descrição: %s,
				Quantidade: %.2f
			""".formatted(codigo, descricao, quantidade);
	}
}
