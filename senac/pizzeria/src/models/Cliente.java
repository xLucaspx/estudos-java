package models;

public class Cliente {
  private String nome;
  private String telefone;
  private String endereco;
  private String cidade;
  
  public Cliente(String nome, String telefone, String endereco, String cidade) {
    setNome(nome);
    setTelefone(telefone);
    setEndereco(endereco);
    setCidade(cidade);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (nome == null || nome.trim().isEmpty())
      throw new IllegalArgumentException("O nome do cliente deve ser preenchido!");

    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    if (telefone == null || !telefone.matches("^\\(?(?:[14689][1-9]|2[12478]|3[1234578]|5[1345]|7[134579])\\)? ?(?:[2-8]|9 ?[1-9])[0-9]{3}\\-?[0-9]{4}$"))
      throw new IllegalArgumentException("O telefone inserido é inválido! Valor inserido: " + telefone);

    this.telefone = telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    if (endereco == null || endereco.trim().isEmpty())
      throw new IllegalArgumentException("O endereço do cliente deve ser preenchido!");

    this.endereco = endereco;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    if (cidade == null || cidade.trim().isEmpty())
      throw new IllegalArgumentException("A cidade do cliente deve ser selecionada!");

    this.cidade = cidade;
  }

  @Override
  public String toString() {
    return String.format("Cliente: %s\nTelefone: %s\nEndereço: %s, %s", nome, telefone, endereco, cidade);
  }
}
