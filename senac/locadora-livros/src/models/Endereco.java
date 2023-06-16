package models;

public class Endereco {
	private String logradouro;
	private String numero;
	private String bairro;

	public Endereco(String logradouro, String numero, String bairro) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, bairro %s", logradouro, numero, bairro);
	}
}
