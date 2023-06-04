package curso;

public class TestaIfElse {
  public static void main(String... args) {
    boolean autentico = true;

    if (autentico) { // a condição (entre parênteses) deve sempre retornar um boolean
      System.out.println("Ok!");
    } else { // o bloco else é opcional
      System.out.println("Não autenticado...");
    }

    int a = 3;
    int b = 0;

    // if(a = b) { // não compila: atribuição
    if (a == b) { // compila, comparação
      System.out.println("iguais");
    }

    if (autentico = false) { // compila pois é uma atribuição de boolean; neste caso retorna false
      System.out.println("não autêntico");
    }

    autentico = true;
    // se os blocos if e else tem apenas uma instrução, é possível omitir as chaves:
    if (autentico)
      System.out.println("if sem chaves");
    // System.out.println("só pode uma instrução"); se tiver mais de uma instrução,
    // não compila
    else
      System.out.println("else sem chaves");
    System.out.println("rodando fora do if/else"); // apenas a primeira linha após o else sem chaves faz parte do bloco

    // O bloco if não pode ser vazio se não utilizarmos chaves:
    // if (!autentico)
    // else -> este trecho de código não compila!
    // System.out.println("ok");

    // múltiplas condições com else if:
    boolean exp = true;
    if (!autentico) {
      System.out.println("não autentico");
    } else if (exp = (1 >= 2)) {
      System.out.println(exp);
    } else {
      System.out.println("bloco else vem sempre por último!");
    }

    if (autentico) {
      System.out.println("if");
    } else {
      System.out.println("else");
      // } else if (exp) { -> não compila, o else deve ser sempre o último bloco,
      // System.out.println("else if"); -> ou seja, else não pode vir antes de else if
      // }
    }

    // cuidado com a identação: o que o código abaixo imprime?

    // int valor = 100;
    // if (valor > 200)
    // if (valor < 400)
    // if (valor > 300)
    // System.out.println("a");
    // else
    // System.out.println("b");
    // else
    // System.out.println("c");

    // resposta: não imprime nada! veja o código devidamente identado:
    int valor = 100;
    if (valor > 200) // como o valor é < 200, nenhuma parte deste if é executado!
      if (valor < 400)
        if (valor > 300)
          System.out.println("a");
        else
          System.out.println("b");
      else
        System.out.println("c");

  }
}

class UnreacheableCode {
  // cuidado com unreacheable code e missing return:

  public int metodo() {
    return 5;
    // System.out.println("oi"); // não compila
  }

  // public int metodo2(int x) {
  // if (x > 200) {
  // return 10;
  // }
  // }
  // método acima não compila pois não adicionamos retorno para todos os caminhos
  // possíveis; uma forma de contornar isso é lançar uma exceprion fora do if:
  public int metodo2(int x) {
    if (false) {
      return 10;
    }
    throw new RuntimeException();
  }
  // método acima compila mesmo sabendo que o if nunca será executado; detalhes do
  // Java! A regra é: em um método, todos os caminhos possíveis devem retornar o
  // tipo indicado pelo método ou lançar exceção; em um if, expressões como
  // if (false){} compilam normalmente
}