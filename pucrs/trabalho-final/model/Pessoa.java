package model;

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
	 * @return O CPF da pessoa, formatado para exibição
	 */
	public String getCpf() {
		// utilizando RegExp para formatar o CPF
		return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
	}

	/**
	 * @param cpf O CPF da pessoa sendo cadastrada
	 * @throws IllegalArgumentException Caso o valor passado seja nulo ou inválido
	 */
	public void setCpf(String cpf) {
		if (cpf == null) {
			throw new IllegalArgumentException("O CPF não pode ser nulo");
		}

		// removendo tudo o que não é dígito do CPF
		cpf = cpf.trim().replaceAll("\\D", "");

		// verifica se o CPF tem o tamanho correto
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("O CPF deve ser preenchido!");
		}

		// validando se o CPF inserido não está composto do mesmo número repetidas vezes
		if (cpf.matches("^(\\d)\\1*$")) {
			throw new IllegalArgumentException("O CPF inserido é inválido!");
		}

		String digitoVerificador = cpf.substring(9); // últimos dois dígitos

		// calculando primeiro dígito verificador do cpf
		int soma = 0;
		int resto = 0;
		String digitoVerificadorCalculado = "";

		for (int i = 0; i < 9; i++) {
			int digito = cpf.charAt(i) - '0'; // converte o char para número
			soma += digito * (10 - i);
		}

		resto = (soma * 10) % 11;
		// se o resto for 10, o dígito é zero; senão, é o resta da divisão por 11
		digitoVerificadorCalculado += resto == 10 ? 0 : resto;

		// calculando segundo dígito verificador do CPF
		soma = 0;

		for (int i = 0; i < 10; i++) {
			var digito = cpf.charAt(i) - '0'; // converte o char para número
			soma += digito * (11 - i);
		}

		resto = (soma * 10) % 11;
		// se o resto for 10, o dígito é zero; senão, é o resta da divisão por 11
		digitoVerificadorCalculado += resto == 10 ? 0 : resto;

		if (!digitoVerificador.equals(digitoVerificadorCalculado)) {
			throw new IllegalArgumentException("O CPF inserido não é válido!");
		}

		this.cpf = cpf;
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
		if (telefone == null) {
			throw new IllegalArgumentException("O telefone deve ser preenchido!");
		}

		if (!telefone.matches(
			"^[(]?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])[)]?\\s?(?:[2-8]|9 ?[1-9])[0-9]{3}-? ?[0-9]{4}$")) {
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
		if (email == null) {
			throw new IllegalArgumentException("O e-mail deve ser preenchido!");
		}

		if (!email.matches("^\\w+([.\\-]?\\w+)*@\\w+([.\\-]?\\w+)*(\\.\\w{2,3})+$")) {
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
			""".formatted(nome, getCpf(), getTelefone(), email);
	}
}
