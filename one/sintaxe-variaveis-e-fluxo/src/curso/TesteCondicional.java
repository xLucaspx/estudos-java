package curso;

public class TesteCondicional {
  public static void main(String[] args) {
    System.out.println("testando condicionais");

    int idade = 20;
    int quantidadeDePessoas = 3;

    if (idade >= 18) {
      System.out.println("seja bem vindo!");
    } else if (quantidadeDePessoas >= 2) {
      System.out.println("Você está acompanhado!");
    } else {
      System.out.println("Você não pode entrar!");
    }
  }
}
