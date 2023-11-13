package api.domain.endereco;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String numero;

	public Endereco(EnderecoDto dados) {
		this.cep = dados.cep();
		this.logradouro = dados.logradouro();
		this.complemento = dados.complemento();
		this.bairro = dados.bairro();
		this.cidade = dados.cidade();
		this.uf = dados.uf();
		this.numero = dados.numero();
	}

	public Endereco() {}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		String strComplemento = complemento != null && !complemento.trim().isEmpty() ? ", " + complemento + ", " : "";
		String strNumero = numero != null && !numero.trim().isEmpty() ? numero : "S/Nº";

		return "%s, %s%s, %s, %s, %s - %s".formatted(cep, logradouro, strComplemento, strNumero, bairro, cidade, uf);
	}
}
