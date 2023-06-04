package metodos_e_encapsulamento;

public class InvocacaoDeMetodos {
  public static void main(String[] args) {
    Pessoa p = new Pessoa();
    // chamamos métodos do objeto invocando-os por meio do operador ., assim como
    // fazemos para acessar uma variável membro:
    p.setNome("Juraci");

    // Quando um método recebe argumentos, temos que passar todos que existem;
    p.define("Pafúncio", 20);

    // quando devolve algo, não precisaremos necessariamente usar o retorno.
    String nome = p.getNome();
    System.out.println(nome);
    System.out.println(p.getNome());

    p.imprime();
  }
}

class Pessoa {
  String nome;
  int idade;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  // quando um método recebe argumentos, todos eles são obrigatórios. Sempre são
  // separados por vírgula, e pode haver espaços em branco entre eles (tab, enter)
  public void define(
      String nome,
      int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public void imprime() {
    // System.out.println(getNome());
    System.out.println(this.getNome()); // this. é opcional
  }
}
