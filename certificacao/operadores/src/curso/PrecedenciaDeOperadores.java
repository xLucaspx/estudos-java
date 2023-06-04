package curso;

public class PrecedenciaDeOperadores {
  public static void main(String[] args) {
    /*
     * A precedência de operadores do java é:
     * 1. pré-incrementos/decrementos;
     * 2. multiplicação/divisão/mod;
     * 3. soma/subtração;
     * 4. shifts;
     * 5. pós-incrementos/decrementos
     * Porém, podemos utilizar parênteses para alterar isso:
     */
    int a = 15 * 4 + 1; // 61
    int b = 15 * (4 + 1); // 75
    System.out.println(a);
    System.out.println(b);

    // uso de parênteses com concatenação:
    System.out.println(15 + 0 + " é cento e cinquenta"); // 15 é cento e cinquenta
    System.out.println(15 + (0 + " é cento e cinquenta")); // 150 é cento e cinquenta

    System.out.println("Lucas " + "Oliveira".length()); // Lucas 8
    System.out.println(("Lucas " + "Oliveira").length()); // 14
  }
}
