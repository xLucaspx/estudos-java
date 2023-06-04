package executaveis;

public class AplicacoesExecutaveis {
  /*
   * discutiremos qual a diferença entre uma classe normal e uma classe que pode
   * ser executada pela linha de comando, uma aplicação Java que tem o método
   * main. Create executable java applications with a main method: Para ser
   * executável tem que ter o metódo main, é a primeira coisa. Toda classe que for
   * chamada na linha de comando tem que ter esse método main.
   */

  // o padrão quando costumamos colocar a classe e o método main é fazer tudo
  // public. Classe pública, método público.
  public static void main(String[] args) {
    // Ao executarmos uma classe pela linha de comando, podemos passar parâmetros
    // para o método main. Esses valores serão recebidos no array do método main
    for (int i = 0; i < args.length; i++) {
      System.out.println(i + " => " + args[i]);
    }
  }
}
