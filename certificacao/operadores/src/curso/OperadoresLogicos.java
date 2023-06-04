package curso;

public class OperadoresLogicos {
  public static void main(String[] args) {
    System.out.println(1 == 2 & 1 > 2); // E
    System.out.println(1 == 2 | 1 < 2); // OU

    System.out.println(1 == 2 ^ 1 < 2); // OU EXCLUSIVO: 1V e 1F
    // os dois não podem ter o mesmo valor (V e V = F; F e F= F)

    System.out.println(!(1 == 2)); // NEGAÇÃO

    /*
     * Da forma acima, o Java vai compilar e executar os dois lados da operação,
     * mesmo que a deireita do & seja false ou a direita do | seja true; Para fazer
     * o chamado short-circuit, ou seja, pular o resto da operação quando já
     * sabemos o resultado final, usamos dois operadores:
     */
    System.out.println(1 <= 2 && 1 != 2);
    System.out.println(1 == 2 || 1 >= 2);

    // não existe short-circuit para o oue exclusivo (^) pois
    // ele sempre executa os dois lados da operação

    // Usando métodos:
    // true && true imprime: primeiro true
    System.out.println(!(1 == 2) && metodo("primeiro"));
    // false & true imprime: segundo false
    System.out.println(1 == 2 & metodo("segundo"));
    // false && true imprime apenas false, pois o short-circuit nem executa o metodo
    System.out.println(1 == 2 && metodo("terceiro"));

    // true || true imprime apenas true, pois o short-circuit nem executa o metodo
    System.out.println(!(1 == 2) || metodo("quarto"));
    // true | true imprime: quinto true
    System.out.println(!(1 == 2) | metodo("quinto"));
    // false || true imprime: sexto true
    System.out.println(1 == 2 || metodo("sexto"));
  }

  static boolean metodo(String msg) {
    System.out.print(msg + " ");
    return true;
  }
}
