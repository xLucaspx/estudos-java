package curso;

public class TesteFor {
  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) { // contador só vale no escopo do for
      System.out.print(i + " ");
    }

    System.out.println(); // quebra de linha
    
    for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
      System.out.print("\nTabuada do " + multiplicador + ":\n");

      for (int i = 1; i <= 10; i++) {
        System.out.println(multiplicador + " x " + i + " = " + multiplicador * i);
      }
    }

    System.out.println(); // quebra de linha

    for (int linha = 0; linha < 10; linha++) {
      // for (int coluna = 0; coluna < 10; coluna++) {
      // if (coluna == linha) break; //para escrever um asterisco a mais que a linha anterior

      // O código comentado acima pode ser substituido por:
      for (int coluna = 0; coluna <= linha; coluna++) {
        System.out.print("*");
      }
      System.out.println(); // quebra de linha 
    }
  }
}
