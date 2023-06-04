package curso;

import java.util.ArrayList;
import java.util.Date;

public class ErrorsAndExceptions {
  public static void main(String[] args) {
    /* ArrayIndexOutOfBoundsException: */
    // int[] x = new int[10];
    // x[10] = 3; // lembrando que vai de 0 até length - 1

    /* IndexOutOfBoundsException (não confundir!): */
    // ArrayList<Integer> x = new ArrayList<>();
    // x.add(0);
    // x.add(1);
    // x.get(2); // mesma coisa: index começa em 0 até length - 1

    /* NullPointerException: */
    // String s = null;
    // s.length(); // tentando acessar props, metodos, etc. de um valor nulo

    /* ClassCastException: */
    // Object o = "String";
    // Date d = (Date) o; // forçando casting impossível de dar certo

    /* NumberFormatException: */
    // String n = "1a";
    // int um = Integer.parseInt(n); // string contém valor inválido para um Integer

    /* IllegalArgumentException: */
    // new Conta().saca(500); // geralmente nós mesmos lançamos essa Exception

    /* IllegalStateException: */
    // Tarefa t = new Tarefa();
    // t.start();
    // t.start(); // Estado atual do Objeto não permite que o método seja executado

    /* ExceptionInInitializerError: */
    // new BlocoEstatico(); // causado por uma exception em um bloco estático da
    // classe, que foi executado quando ela foi carregada

    /* StackOverflowError: */
    // new ErrorsEExceptions().metodo();

    /* OutOfMemoryError: */
    // boolean sempre = true;
    // ArrayList<String> l = new ArrayList<>();
    // String s = "String";
    // while(sempre) {
    // s += s;
    // l.add(s);
    // }
  }

  void metodo() {
    // recursão; do jeito que está, os métodos serão empilhados eternamente e a
    // pilha de execução vai estourar:
    metodo();
  }
}

class Conta {
  double saldo = 100;

  void saca(double valor) {
    if (saldo < valor) {
      throw new IllegalArgumentException();
    }
    saldo -= valor;
  }
}

class Tarefa {
  boolean rodando = false;

  void start() {
    if (rodando) {
      throw new IllegalStateException();
    }

    rodando = true;
  }

  void stop() {
    if (!rodando) {
      throw new IllegalStateException();
    }

    rodando = false;
  }
}

class BlocoEstatico {
  /*
   * No momento em que a máquina virtual é disparada, ela não carrega todo o
   * conteúdo do *classpath*, em outras palavras, ela não carrega em memória todas
   * as classes referenciadas pela sua aplicação; uma classe é carregada no
   * momento da sua primeira utilização. Isso se dá quando algum método estático
   * ou atributo estático são acessados ou quando um objeto é criado a partir da
   * classe em questão.
   * 
   * No carregamento de uma classe, a JVM pode executar um trecho de código
   * definido pelo programador. Esse trecho deve ficar no que é chamado bloco
   * estático. É totalmente possível que algum erro de execução seja gerado no
   * bloco estático. Se isso acontecer, a JVM vai "embrulhar" esse erro em
   * um ExceptionInInitializerError e dispará-lo.
   */
  static {
    String s = null;
    s.length();
  }
}
