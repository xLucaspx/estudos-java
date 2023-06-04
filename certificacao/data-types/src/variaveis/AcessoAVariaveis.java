package variaveis;

public class AcessoAVariaveis {
  public static void main(String[] args) {
    Carro a = new Carro();
    a.modelo = "Palio"; // acessando diretamente o atributo
    a.setModelo("Palio Fire"); // acessando o atributo por um método

    System.out.println(a.getDadosDeImpressao());
    System.out.println(a.ano);
    System.out.println(a.modelo.length());
  }
}

class Carro {
  String modelo;
  int ano;

  // Uma maneira de acessar as variáveis é utilizar o operador this. antes do nome
  // do campo, servindo como acesso a algum tipo de membro, seja um método ou
  // variável. No caso de um método de instância, como o void reseta(), o this.
  // seria a instância; dentro de um construtor, o this. é o próprio objeto que
  // está sendo construído. lembrando que o this. é opcional
  Carro() {
    modelo = "indefinido"; // acessando variável de instancia sem o this.
    ano = 2023; // acessando com o this.
  }

  void reseta() {
    this.ano = 2023;
  }

  public String getDadosDeImpressao() {
    return modelo + "::" + ano;
  }

  // quando os nomes do parâmetro e da variável local são iguais,
  // o this. é obrigatório
  public void setModelo(String modelo) {
    this.modelo = modelo;
    /*
     * Não existe conflito de nomes entre variável membro e método ou variável
     * membro e variável local. Ao invocar o método setModelo, por causa do
     * shadowing da variável modelo, não acessamos a variável membro, sem alterá-la:
     */
    // modelo = modelo; // warning: The assignment to variable modelo has no effect
  }
}
