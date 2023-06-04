package curso;

public class ArrayUniDimensional {
  public static void main(String[] args) {
    // formas válidas de declaração de arrays:
    int[] idades;
    // double pesos[];
    // int []numeros;
    // double[]tamanhos;

    // instânciando array - ou você passa o tamanho, ou passa os valores:
    idades = new int[] { 2, 4, 6, 8, 0 }; // é necessário inicializar com os valores...
    idades = new int[10]; // ... OU declarar a capacidade
    // idades = new int[5] { 2, 4, 6, 8, 0 }; // não compila

    // cada posição do array é iniciado com o valor default do tipo
    System.out.println(idades[0]); // 0
    // As posições de um array são indexadas de 0 até sua capacidade menos um.

    // forma mais sucinta: só funciona se a declaração e a inicialização do array
    // estiverem na mesma linha
    int[] pares = { 2, 4, 6, 8, 0 };
    System.out.println(pares[4]); // 0

    /*
     * é possível criar arrays com posições "inválidas":
     * 
     * pesos = new double[-5]; // compila mas lança exception negative array size
     * 
     * pesos = new double[0];
     * System.out.println(pesos[0]); // exception index out of bounds
     * 
     * acessar uma posição inválida de um array lança uma exceção em runtime
     */

    // adicionando/alterando valor em uma posição do array:
    idades[0] = 20;
    idades[1] = 22;
    System.out.println(idades[0] + " " + idades[1]);

    System.out.println(idades.length); // propriedade que contém o tamanho declarado do array

    // percorrendo array com for:
    for (int i = 0; i < pares.length; i++) {
      System.out.print(pares[i] + " ");
    }
    System.out.println();
    // enhanced for (a partir do Java 5):
    for (int par : pares) {
      System.out.print(par + " ");
    }

    // não é possível fazer cast em arrays de tipos primitivos:
    // int[] valores = new int[10];
    // long[] v2 = (long[]) valores; // type mismatch, até mesmo com casting
  }
}
