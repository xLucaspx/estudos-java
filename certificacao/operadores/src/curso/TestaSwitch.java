package curso;

public class TestaSwitch {
  public static void main(String[] args) {
    int zero = 0;
    int opcao = zero;
    final int ZERO = 0;
    /*
     * O switch funciona da seguinte maneira: passamos para ele uma variável e ele
     * vai analisar o valor dela; o valor dessa variável, no caso, é 1, então ele
     * vai passar por cada um dos cases na sequência, achando algum dos cases que
     * seja o match perfeito. Case 1, opção vale um? Sim, então é nesse case que ele
     * vai entrar; entrou no case, imprime a mensagem.
     * 
     * Acontece que ele não sai sozinho, ele não vai executar só isso e sair, ele
     * vai continuar executando os próximos cases até ele encontrar um break. O
     * break sai do switch. No caso do switch não existe continue, só existe break.
     */
    switch (opcao) {
      // case zero: // variáveis não são permitidas
      case ZERO: // apenas se forem final
        // para ser considerada uma constante em um case, a variável, além de ser final,
        // também deve ter sido inicializada durante a sua declaração. Inicializar a
        // variável em outra linha faz com que ela não possa ser usada como valor em
        // um case
        System.out.println("Nenhuma opção...");

      case 1:
        System.out.println("Primeira opção!");
        break;

      case (2): // podemos usar parenteses
        System.out.println("Segunda opção!");

      case (2 + 1): // e realizar operações com literais ou constantes
        System.out.println("Terceira opção!");

      case 4: // também podemos ter um case vazio

      default:
        // default só é executado como ponto de entrada se nenhum outro case der match
        // com o valor, independente da ordem ou posição que se encontra dentro do bloco
        System.out.println("Outra opção");
    }
    // O switch aceita tipos inteiros menores ou iguais a int, Strings e enums;
    // números com ponto flutuante não são aceitos. Os cases sempre devem ser do
    // mesmo tipo do switch, ou teremos erro de compilação (type mismatch);
    // ex. de switch com byte
    Byte b = 15;
    switch (b) {
      default:
        System.out.println("Default: 0");
        break;
      case 10: // mesmo sendo int, 10 cabe em um byte, o compilador fará o cast automaticamente
        System.out.println("Dez");
        break;
      case 20: { // podemos usar {}, mas não podemos esquecer os dois pontos (:)
        System.out.println("Vinte");
        break;
      }
      case 30:
        System.out.println("Trinta");
        break;
      // case 400: neste caso, o número é muito grande, o compilador não fará o cast e
      // teremos um erro de compilação pois os tipos são incompatíveis
    }
    /*
     * Resumindo: o switch funciona como um if else if else if, só que enquanto não
     * tem break ele continua executando a partir da condição que ele deu o match.
     * 
     * Qual condição ele dá match? Se tiver algum caso igual essa condição; se
     * nenhum caso for igual, ele dá match no default; se não tem default ele não
     * executa nada e fica quieto.
     * 
     * Então ele vai procurar um caso igual, senão ele vai procurar o default;
     * quando encontrar em qual ele vai entrar, ele entra, e a partir daí ele
     * executa tudo até encontrar o break.
     */
  }
}
