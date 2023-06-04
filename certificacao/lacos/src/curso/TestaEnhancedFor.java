package curso;

import java.util.ArrayList;

public class TestaEnhancedFor {
  public static void main(String[] args) {
    System.out.println("Loop 1:");
    int[] numeros = { 1, 2, 3, 4, 5 };

    for (int numero : numeros) {
      System.out.print(numero + " ");
    }

    System.out.println("\nLoop 2:");
    ArrayList<String> nomes = new ArrayList<>();
    nomes.add("Java");
    nomes.add("C++");
    nomes.add("SQL");

    for (String nome : nomes) {
      System.out.println(nome);
    }
    /*
     * o enhanced for recebe a declaração de uma variável, sendo que o tipo dela tem
     * que ser compatível com o tipo do array ou coleção que queremos iterar sobre.
     * No caso acima temos um array de ints, então eu estou criando um int para cada
     * elemento dentro daquele array, e aí imprimimos cada um desses elementos.
     * 
     * Assim como o for, chaves é opcional. O enhanced for funciona tanto para
     * arrays quanto para coleções. Como é que funciona o enhanced for para uma
     * lista? O que ele vai usar por baixo do pano é um iterator.
     * 
     * O enhanced for tem algumas restrições. A primeira delas é que temos que
     * passar por todos os elementos, do primeiro até o último. Se eu quiser pular
     * elementos de dois em dois, não dá. Se eu quiser ir de trás para frente, não
     * dá. Ele sempre vai passar do primeiro até o último, um a um, quer você
     * queira, quer você não queira.
     * 
     * Também devemos evitar remover itens, com remove() por exemplo, pois não temos
     * como prever o que irá acontecer; alterar a referência usando a variável local
     * dentro do for também não altera permanentemente a lista
     * 
     * Por fim, uma outra limitação é que eu não tenho um contador que está rolando
     * a medida que eu estou dentro desse meu laço; eu não tenho como saber se eu
     * estou no primeiro, segundo ou terceiro item. Se eu quiser saber em qual item
     * estou, se eu quero um contador, eu vou ter que criar uma variável i e ficar
     * somando um a um, mas aí é o for tradicional, então faz o for tradicional.
     */
  }
}
