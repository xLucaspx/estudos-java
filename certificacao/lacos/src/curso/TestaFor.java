package curso;

public class TestaFor {
  public static void main(String... args) {
    System.out.println("loop 1:");
    // for tem as três partes de um laço na sua declaração:
    // cria e inicializa a variável; condição; incremento
    for (int i = 0; i < 10; i++) {
      System.out.print(i + " "); // imprime de 0 a 9
    }

    // atenção com as condições:
    System.out.println("\nloop 2:");
    for (int i = 0; i <= 10; ++i) // apenas uma linha de expressões n precisa de {}
      System.out.print(i + " "); // imprime de 0 a 10

    // loop infinito - j nunca é incrementado:
    // int j = 1;
    // for (int i = 0; j <= 10; i++) {
    // System.out.println("loop infinito " + i);
    // }

    // podemos declarar mais de uma variável no for, desde que todas sejam do MESMO
    // TIPO; também podemos declarar mais de um incremento/decremento. No campo de
    // condição, podemos passar qualquer expressão que resulte em um boolean:
    System.out.println("\nloop 3:");
    for (int i = 0, j = 3; i <= 3 && j >= 0; i++, j--) {
      System.out.println(i + " - " + j);
    }

    // se já temos variáveis declaradas, podemos apenas inicializá-las no for; desta
    // forma, podem ser variáveis de tipos diferentes:
    System.out.println("loop 4:");
    int c;
    long d;
    for (c = 0, d = 3; c <= 3; c++, d--) {
      System.out.println(c + " - " + d);
    }

    // porém não podemos misturar inicialização e declaração; ou um ou outro!
    // int a;
    // for (int b = 10, a = 0; b > 0; b--) {} // duplicate local variable: n compila

    // na última parte do for podemos colocar qualquer statement, até um sysout:
    System.out.println("loop 5:");
    for (int i = 0; i < 3; System.out.println("Olá " + i++))
      ;

    // Todas as partes da declaração do for são OPCIONAIS:
    System.out.println("loop 6:");
    int i = 0;
    for (; i < 10;) {
      System.out.print(i++ + " "); // 0-9
    }

    // caso não tenha condição explicita, é como se valesse true, fazendo com que o
    // loop seja infinito; até compila, mas se tiver algo abaixo o compilador acusa
    // unreacheable code e para de compilar:

    // for (;;) {
    // System.out.println("loop infinito!");
    // }
    // int j = 2; // unreacheable code: não compila

    // for (;;i++) {
    // System.out.println(i);
    // }
    // // int j = 2; // unreacheable code: não compila

    // for (int j = 1; ;) {
    // System.out.println(j);
    // }
    // int j = 2; // unreacheable code: não compila
  }
}
