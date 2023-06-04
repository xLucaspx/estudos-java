package curso;

public class TestaWhile {
  public static void main(String[] args) {
    System.out.println("loop 1:");
    int i = 1;
    while (i < 10) {
      System.out.print(i + " ");
      i++; // imprime de 1 - 9
    }

    System.out.println("\nloop 2:");
    i = 1;
    while (i < 10) // se tem apenas uma linha não precisa de {}
      System.out.print(i++ + " ");

    i = 11; // não executa o laço: condição é false
    while (i < 10) {
      System.out.println(i);
      i++;
    }

    // o compilador é inteligente para perceber loop eternos expliícitos:

    // final boolean verdadeiro = true; // como a variável é final, é...
    // while (verdadeiro) { // ... a mesma coisa que while(true) ou while(false)
    // System.out.println("loop infinito");
    // }
    // i++; // unreacheable code: não compila!

    /*
     * A primeira coisa para se ter cuidado com while: ele pode fazer um loop
     * infinito;
     * 
     * Em segundo lugar: a primeira coisa que o while faz é verificar o valor da
     * expressão; se for true ele executa uma volta e, quando termina, ele volta
     * para executar a condição novamente. Por exemplo: no loop acima, quando ele
     * faz i++ e passa a valer nove, ele volta para verificar a condição (i < 10) e
     * entra pela última vez no laço; quando chega no i++, i passou a valer 10, ele
     * volta para o while e verifica a condição: i < 10? 10 não é menor do que 10,
     * aí ele cai fora.
     * 
     * Se ele primeiro verifica a condição, quer dizer que se o meu valor de i fosse
     * grande o suficiente (11, por exemplo), ele ia verificar que a condição deu
     * false logo de cara e nem executaria o while.
     * 
     * Terceiro: se tem um while(true) que nunca é quebrado, isto é, é uma condição
     * eterna de verdadeiro sem nenhum tipo de break, o compilador vai falar:
     * "Unreacheable code" e não deixa compilar; mesmo que eu faça uma condição, por
     * exemplo, while(verdadeiro) com final boolean verdadeiro = true;, por causa do
     * final ele vai perceber que o loop será infinito.
     * 
     * Agora, caso a variável não seja final, o compilador não tem como saber se o
     * valor irá mudar ou não, por mais explícito que possa parecer, e o código
     * compila normalmente.
     * 
     * E se eu colocar um while(false), execute isso daqui somente se false. Eu
     * tento compilar e aí ele fala o inverso:
     * "Isso daqui você nunca terá executado". Então, um while(false), também é
     * inteligente e percebe que nunca será executado, tem alguma coisa de errado no
     * seu código, não compila.
     */
  }
}
