package curso;

public class TesteWhile {
  public static void main(String[] args) {
    int i = 0;

    while (i <= 10) {
      System.out.print(i + " ");
      i++;
    }
    System.out.println("\nContador: " + i); // contador continua acessível após o while (!= for)

    i = 0;
    int total = 0;

    while (i < 10) {
      // total = total + i; o código abaixo faz a mesma coisa:
      total += i;
      i++;
      System.out.print(total + " ");
    }
    System.out.println("\nContador: " + i);
  }
}
