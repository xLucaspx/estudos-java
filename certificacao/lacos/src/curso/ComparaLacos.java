package curso;

public class ComparaLacos {
  public static void main(String[] args) {
    // while: usamos quando queremos primeiro ter certeza de alguma coisa, antes de
    // executar o bloco.

    // do/while: usamos quando queremos primeiro executar uma coisa, e depois
    // continuar executando ela enquanto uma condição for verdadeira

    int j = 15;
    while (j <= 10) { // nem executa
      System.out.println("while " + j++);
    }

    do { // executa uma vez
      System.out.println("do/while " + j++);
    } while (j <= 10);

    // for: usamos para percorrer arrays, até mesmo vários ao mesmo tempo; também
    // podemos usar para setar ou modificar valores (array[i] ou list.method(i)).

    // enhanced-for: usado para percorrer um array ou iterável do início ao fim, sem
    // alterações

    int[] arr1 = new int[5];
    int[] arr2 = new int[] { 2, 4, 6, 8, 0 };

    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = i;
      arr2[i] = arr2[i] + (i * 2);
    }

    System.out.println("Conteúdo arr1:");
    for (int n : arr1) { // Não é possível inicializar os valores de um array com o enhanced for
      System.out.print(n + " ");
      n = 0; // modifica apenas a variável local n, não o conteúdo o array!
    }

    System.out.println("\nConteúdo arr2:");
    for (int n : arr2) {
      System.out.print(n + " ");
    }

    // Quando eu quero percorrer alguma coisa e tenho uma inicialização, uma
    // condição e um incremento, costuma-se usar o for. O enhanced for quando eu
    // quero passar por todos os elementos de um array

    // Quando eu sei apenas a condição de parada e mais nada, eu tenho um while
  }
}
