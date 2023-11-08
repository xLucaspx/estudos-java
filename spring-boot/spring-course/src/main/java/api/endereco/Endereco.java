package api.endereco;

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

	@Override
	public String toString() {
		String strComplemento = complemento != null && !complemento.trim().isEmpty() ? ", " + complemento + ", " : "";
		String strNumero = numero != null && !numero.trim().isEmpty() ? numero : "S/Nº";

		return "%s, %s%s, %s, %s, %s - %s".formatted(cep, logradouro, strComplemento, strNumero, bairro, cidade, uf);
	}
}
