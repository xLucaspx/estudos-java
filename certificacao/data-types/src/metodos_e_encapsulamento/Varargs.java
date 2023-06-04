package metodos_e_encapsulamento;

public class Varargs {
  public static void main(String[] args) {
    Calculadora calculadora = new Calculadora();
    System.out.println(calculadora.soma(3, 5));
    System.out.println(calculadora.soma(1, 2, 3, 9, 8, 7, 6, 4));
    System.out.println(calculadora.soma(5));
    System.out.println(calculadora.soma(new int[] { 2, 5, 3 }));
    System.out.println(calculadora.soma()); // output: 0;
    // com varargs, em todos os casos, um array será criado; nunca será null
  }
}

class Calculadora {
  /*
   * para termos um número variável de argumentos, basta escrevermos o tipo
   * seguido de ... na definição do método; com isso, dizemos que ele pode receber
   * um array com qualquer quantidade de argumentos daquele tipo. Por exemplo, o
   * metodo soma pode receber qualquer quantidade de int como argumento:
   */
  public int soma(int... numeros) {
    int soma = 0;
    // Os argumentos de quantidades variáveis (varargs) são array e
    // são acessados como um array
    for (int i = 0; i < numeros.length; i++) {
      soma += numeros[i];
    }
    return soma;
  }

  /*
   * É preciso tomarmos alguns cuidados com varargs:
   * Um varargs é um array, um array NÃO É UM VARARGS! podemos, por exemplo,
   * passar um array em um argumento varargs, mas o inverso não é válido:
   * 
   * void metodo1(int ... x) {}
   * metodo1(new int[] {1,2,3,4}); // compila
   * 
   * void metodo2(int[] x) {}
   * metodo2(1,2,3); // não compila
   * 
   * Se podemos receber qualquer quantidade como um array, também poderemos passar
   * zero argumentos.
   * 
   * Outro ponto importante é que o varargs não permite a mistura de tipos, então
   * não podemos falar diretamente que queremos ints e strings na mesma soma por
   * exemplo; para isso, teríamos que usar a referência genérica Object como
   * argumento dentro de soma(), o que tornaria o trabalho mais complexo com cast
   * e outras técnicas.
   * 
   * O varargs deve ser o último argumento do método, para evitar ambiguidade;
   * isso implica que apenas um dos parâmetros de um método seja varargs. Também
   * não poderíamos colocar, por exemplo, uma String nome ao final de soma(), pois
   * o programa não compilará.
   * 
   * Será dada a prioridade para o método que já podia existir antes no Java 1.4:
   * 
   * void metodo(int ... x) {}
   * void metodo(int x) {}
   * metodo(5); // vai invocar o segundo método.
   */
}
