package curso;

public class IncrementosEDecrementos {
  public static void main(String[] args) {
    int i = 5;
    // pós-incremento/decremento:
    // imprime o valor primeiro e aplica o decremento depois
    System.out.println(i--); // 5
    System.out.println(i); // 4

    // mesma coisa com o incremento
    System.out.println(i++); // 4
    System.out.println(i); // 5

    // pré-incremento/decremento
    // aplica a operação primeiro, depois devolve o valor
    System.out.println(--i); // 4
    System.out.println(++i); // 5

    /*
     * Precedência de operadores no Java:
     * pré-incrementos/decrementos
     * multiplicação/divisão/mod
     * soma/subtração
     * shifts (<<, >>, >>>)
     * pós-incrementos/decrementos
     */

    // outras operações: encurta atribuições como i = i + 5; para i += 5
    // lembrando que atribuições também geram um retorno
    System.out.println(i += 2); // 7
    System.out.println(i -= 3); // 4
    System.out.println(i *= 5); // 20
    System.out.println(i /= 4); // 5
    System.out.println(i %= 2); // 1

    // o compilador sabe se virar:
    byte b = 10;
    // b = b + 3; // não compila pois devolve um int
    System.out.println(b += 4); // 14; compila pois o compilador resolve;
    System.out.println(b += 200); // -42
    // byte vai de -128 a 127, e o resultado desta operação seria 214; para resolver
    // isso, o compilador "vira" o número, e o resultado sai como -42;

    // uma coisa que pode ocorrer é diversas alterações na mesma linha:
    int a = 10;
    a += ++a + a + ++a;
    System.out.println(a); // 44
    // a resolução desta operação se dá da seguinte forma:
    a = a + ++a + a + ++a;
    a = 10 + 11 + 11 + 12;
    a = 44;

    // outro exemplo, cuidado com operadores de pós incremento:
    int j = 0;
    int k = (j++ * j + j++);

    System.out.println(k); // 1
    System.out.println(j); // 2
    // resolução:
    k = (0 * j + j++); // j++: atribui zero e agora j vale 1
    k = (0 * 1 + j++); // j continua valendo 1
    k = (0 * 1 + 1); // j++: atribui 1 e agora j vale 2
    k = 1; // j = 2

    // também pode ocorrer atribuiçao múltipla:
    int x = 15, y = 20, z = 30;
    y = z;
    System.out.println(x); // 15
    System.out.println(y); // 30
    System.out.println(z); // 30

    x = 15;
    y = 20;
    z = 30;
    x = (y = z); // o resultado de uma atribuição é o valor que foi atribuído
    System.out.println(x); // 30
    System.out.println(y); // 30
    System.out.println(z); // 30

    x = 15;
    y = 20;
    z = 30;
    x = y = z; // y = z retorna 30, x = 30
    System.out.println(x); // 30
    System.out.println(y); // 30
    System.out.println(z); // 30

    x = 15;
    y = 20;
    z = 30;
    x = (y = z) + 1; // y = z = 30; x = 30 + 1
    System.out.println(x); // 31
    System.out.println(y); // 30
    System.out.println(z); // 30
  }
}
