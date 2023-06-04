package variaveis;

public class VariavelDeInstancia {
  /*
   * variável de instância, ou variável de objeto, às vezes também chamada de
   * atributo, ou variável membro, é declarada dentro da classe; quando eu tenho
   * uma variável de instância, ela pode ser acessada em qualquer lugar dentro do
   * meu objeto, dentro da minha classe, desde que eu tenha um objeto instanciado,
   * porque ela é uma variável do meu objeto.
   */

  String nome = "Lucas";

  public VariavelDeInstancia() {
    System.out.println(nome);
  }

  public void m1() {
    System.out.println(nome);
  }

  public static void main(String[] args) {
    VariavelDeInstancia teste = new VariavelDeInstancia();
    teste.m1();
    // Posso acessar também a variável de instância através da instância:
    teste.nome = "novo nome";
    System.out.println(teste.nome);
  }
}
