package curso;

public class TestaDoWhile {
  public static void main(String[] args) {
    System.out.println("Loop 1:");
    int i = 1;
    do {
      System.out.print(i++ + " ");
    } while (i <= 5);

    // do/while, diferentemente do while, sempre executa o bloco pelo menos uma vez,
    // pois só verifica a condição no final:
    System.out.println("\nLoop 2:");
    i = 10;
    do {
      System.out.println(i++);
    } while (i <= 5);

    // chaves são opcionais, mas se não usarmos podemos passar apenas uma instrução,
    // senão não compila; ATENÇÃO: o ; após a condição do while NÃO É opcional!
    System.out.println("Loop 3:");
    i = 0;
    do
      System.out.print(i++ + " ");
    while (i <= 5);
  }
}
