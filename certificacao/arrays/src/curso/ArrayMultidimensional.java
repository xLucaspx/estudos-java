package curso;

public class ArrayMultidimensional {
  public static void main(String[] args) {
    // declarações válidas: para cada dimensão que você quer colocar no array você
    // coloca um conjunto de colchetes
    int[][] tabela; // 2 dimensões
    int[] cubo[][]; // 3 dimensões
    // int[][] hipercubo[][]; // 4 dimensões

    // inicialização:
    tabela = new int[10][5]; // inicializando com as duas dimensões

    // inicializando com apenas uma dimensão, deixando as outras para inicializar
    // depois:
    cubo = new int[10][][];

    System.out.println(tabela.length);
    System.out.println(cubo.length);

    // inicializando um int[3][3] já com os valores: *usa apenas dois colchetes
    // na declaração, e chaves para separar os valores
    int[][] teste = new int[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
    for (int i = 0; i < teste.length; i++) {
      for (int j = 0; j < teste.length; j++) {
        System.out.print(teste[i][j] + " ");
      }
      System.out.println();
    }

    // nem todo array precisa ser necessariamente retangular:
    int[][] estranho = new int[2][];
    // se você não inicializa o array direto, passando as duas dimensões, você
    // precisa em cada posição inicializar com o outro array ali dentro
    estranho[0] = new int[20];
    estranho[1] = new int[10];
    for (int i = 0; i < estranho.length; i++) {
      System.out.println(estranho[i].length); // 10 e 20
    }
  }
}
