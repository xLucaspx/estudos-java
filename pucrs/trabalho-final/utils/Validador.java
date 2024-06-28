package utils;

public class Validador {
	public static boolean validaCpf(String cpf) {
		if (cpf == null) {
			return false;
		}

		// removendo tudo o que não é dígito do CPF
		cpf = cpf.trim().replaceAll("\\D", "");

		// verifica se o CPF tem o tamanho correto
		if (cpf.length() != 11) {
			return false;
		}

		// validando se o CPF inserido não está composto do mesmo número repetidas vezes
		if (cpf.matches("^(\\d)\\1*$")) {
			return false;
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
		// se o resto for 10, o dígito é zero; senão, é o resto da divisão por 11
		digitoVerificadorCalculado += resto == 10 ? 0 : resto;

		// calculando segundo dígito verificador do CPF
		soma = 0;

		for (int i = 0; i < 10; i++) {
			int digito = cpf.charAt(i) - '0'; // converte o char para número
			soma += digito * (11 - i);
		}

		resto = (soma * 10) % 11;
		// se o resto for 10, o dígito é zero; senão, é o resto da divisão por 11
		digitoVerificadorCalculado += resto == 10 ? 0 : resto;

		return digitoVerificador.equals(digitoVerificadorCalculado);
	}

	public static boolean validaEmail(String email) {
		if (email == null) {
			return false;
		}

		return email.matches("^\\w+([.\\-]?\\w+)*@\\w+([.\\-]?\\w+)*(\\.\\w{2,3})+$");
	}

	public static boolean validaTelefone(String telefone) {
		if (telefone == null) {
			return false;
		}

		return
			telefone
				.matches(
					"^[(]?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])[)]?\\s?(?:[2-8]|9\\s?[1-9])[0-9]{3}-?\\s?[0-9]{4}$"
				);
	}
}
