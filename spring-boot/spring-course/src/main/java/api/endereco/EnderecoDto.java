package api.endereco;

public record EnderecoDto(String cep, String logradouro, String complemento, String bairro, String cidade, String uf,
		String numero) {}
