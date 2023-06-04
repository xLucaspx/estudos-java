package curso;

public class TesteCondicional2 {
  public static void main(String[] args) {
    System.out.println("Testando condicionais 2");

    int idade = 19;
    int quantidadeDePessoas = 3;
    // boolean estaAcompanhado = true;
    boolean estaAcompanhado = quantidadeDePessoas >= 2;

    // if (idade >= 18 || quantidadeDePessoas >= 2) System.out.println("Seja bem vindo!");
    // if (idade >= 18 && quantidadeDePessoas >=2) System.out.println("Pode entrar!");

    if (idade >= 18 && estaAcompanhado) { // estaAcompanhado já é um boolean, portanto não precisa de == true.
      System.out.println("Tudo certo!");
    } else {
      System.out.println("Acesso negado!");
    }
  }
}
