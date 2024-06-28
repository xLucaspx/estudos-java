package model;

import static utils.Validador.*;

public class Pessoa {
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private ListaDoacao doacoesRecebidas;

	/**
	 * Construtor para instanciar um objeto do tipo Pessoa.
	 *
	 * @param cpf      O CPF da pessoa sendo cadastrada; deve ser um CPF válido.
	 * @param nome     O nome da pessoa sendo cadastrada; não pode ser nulo ou vazio.
	 * @param email    O e-mail da pessoa sendo cadastrada; deve estar em um formato de e-mail válido.
	 * @param telefone O telefone da pessoa sendo cadastrada; deve estar em um formato de telefone válido.
	 * @throws IllegalArgumentException Caso qualquer dos valores passados seja nulo ou inválido.
	 */
	public Pessoa(String cpf, String nome, String email, String telefone) {
		// utilizando os métodos set para encapsular as validações
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		this.doacoesRecebidas = new ListaDoacao();
	}

	/**
	 * @param doacao A doação recebida pela pessoa, que será adicionada à lista
	 * @return Falso caso a doação seja nula ou duplicada, verdadeiro caso contrário
	 */
	public boolean adicionaDoacao(Doacao doacao) {
		return doacoesRecebidas.cadastraDoacao(doacao);
	}

	/**
	 * @return A lista de doações recebidas pela pessoa. A lista terá o mesmo tamanho de doações recebidas, sem posições
	 * nulas
	 */
	public Doacao[] getDoacoesRecebidas() {
		return doacoesRecebidas.getDoacoes();
	}

	/**
	 * @return O CPF da pessoa contendo apenas números.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf O CPF da pessoa sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja nulo ou inválido
	 */
	public void setCpf(String cpf) {
		if (!validaCpf(cpf)) {
			throw new IllegalArgumentException("O CPF inserido é inválido!");
		}

		// removendo tudo o que não é dígito do CPF
		this.cpf = cpf.trim().replaceAll("\\D", "");
	}

	/**
	 * @return O CPF da pessoa, formatado para exibição
	 */
	public String getCpfFormatado() {
		// utilizando RegExp para formatar o CPF
		return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}

	/**
	 * @return O telefone da pessoa, formatado para exibição
	 */
	public String getTelefone() {
		String formato = telefone.length() == 11 ? "($1) $2 $3-$4" : "($1) $2$3-$4";

		return telefone.replaceAll("^(\\d{2})(\\d?)(\\d{4})(\\d{4})$", formato);
	}

	/**
	 * @param telefone O telefone da pessoa sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja nulo ou inválido
	 */
	public void setTelefone(String telefone) {
		if (!validaTelefone(telefone)) {
			throw new IllegalArgumentException("O telefone inserido é inválido!");
		}

		// salvando apenas os números (\D significa tudo o que não é dígito)
		this.telefone = telefone.trim().replaceAll("\\D", "");
	}

	public String getNome() {
		return nome;
	}

	// os métodos setNome e setCpf são privados pois essas informações não podem ser alteradas

	/**
	 * @param nome O nome da pessoa sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja nulo ou vazio
	 */
	private void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("O nome deve ser preenchido!");
		}

		this.nome = nome.trim();
	}

	public String getEmail() {
		return email;
	}

	/**
	 * @param email O e-mail da pessoa sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja nulo ou inválido
	 */
	public void setEmail(String email) {
		if (!validaEmail(email)) {
			throw new IllegalArgumentException("O e-mail inserido é inválido!");
		}

		this.email = email;
	}

	@Override
	public String toString() {
		return """
			Pessoa:
				Nome: %s,
				CPF: %s,
				Telefone: %s,
				E-mail: <%s>
			""".formatted(nome, getCpfFormatado(), getTelefone(), email);
	}
}
