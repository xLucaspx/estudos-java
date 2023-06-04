package metodos_e_encapsulamento;

public class TestaMetodos {
  public static void main(String[] args) {
    ClasseComMetodos c = new ClasseComMetodos();
    int a = 1;

    c.recebeDouble(a); // int pode ser promovido a double
    c.recebeDouble('Z'); // char pode ser promovido a double

    c.referencia(new Object());
    c.referencia("String tb é object (polimorfismo)");

    c.teste(1, 2); // devemos passar todos os parâmetros de um método

    // armazenando retorno de métodos que não são void:
    String r = c.comparaComZero(a);
    System.out.println(r);
  }
}

class ClasseComMetodos {
  /*
   * A assinatura do método sempre tem:
   * - um nome seguindo as regras de identificadores;
   * - um tipo de retorno;
   * - um conjunto de parâmetros (pode ser vazio), cada um com seu nome e seu
   * tipo;
   * - um modificador de visibilidade (nem que seja implícito, package-private).
   * 
   * E, ainda na assinatura, podemos ter:
   * - final: em caso de herança, o método não pode ser sobrescrito nas classes
   * filhas;
   * - abstract: obriga as classes filhas a implementarem o método. O método
   * abstrato não pode ter corpo definido;
   * - static: atributos acessados direto na classe, sem instâncias;
   * - synchronized: lock da instância;
   * - native: não cai nesta prova. Permite a implementação do método em código
   * nativo (JNI);
   * - strictfp: não cai nesta prova. Ativa o modo de portabilidade matemática
   * para contas de ponto flutuante.
   * - throws <EXCEPTIONS>: após a lista de parâmetros, podemos indicar quantas
   * exceptions quisermos para o throws.
   * 
   * A ordem dos elementos na assinatura dos métodos é sempre a seguinte, sendo
   * que os modificadores podem aparecer em qualquer ordem:
   * <MODIFICADORES> <TIPO_RETORNO> <NOME> (<PARÂMETROS>) <THROWS_EXCEPTIONS>
   */
  int getNumero() {
    return 5;
  }

  // em Java, não é possível ter valores default para parâmetros
  void recebeDouble(double d) {
    System.out.println(d);
    // return; // return como última linha de um método void é opcional
  }

  // em um método que tem o tipo do retorno definido, todos os caminhos devem
  // retornar algo ou jogar uma exception:
  String comparaComZero(int a) throws RuntimeException {
    if (a > 0)
      return "maior";
    else if (a < 0)
      return "menor";
    // se remover a linha abaixo o método não compila
    throw new RuntimeException("jogar exception resolve o problema");
  }

  void referencia(Object o) {
  }

  // O único modificador possível de ser marcado em parâmetros é final:
  void teste(final int a, int b) {
    b = 10;
    // a = 5; // não compila: a é final
  }
}
