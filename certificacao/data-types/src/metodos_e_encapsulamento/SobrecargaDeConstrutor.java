package metodos_e_encapsulamento;

public class SobrecargaDeConstrutor {
  public static void main(String[] args) {
    Livro l1 = new Livro();
    System.out.println();

    Livro l2 = new Livro("");
    System.out.println();

    Livro l3 = new Livro(new int[] { 1, 2, 4 });
    System.out.println();

    Livro l4 = new Livro(1);
    // para silenciar warnings:
    System.out.println(l1 + "\n" + l2 + "\n" + l3 + "\n" + l4);
  }
}

class Livro {
  // overload de construtores respeita as mesmas regras que overload de métodos
  Livro() {
    // this(""); // não compila: recursive constructor invocation
    // new Livro(""); // compila e entra em loop infinito
    System.out.println("construtor sem argumentos");
  }

  Livro(String s) {
    // se queremos invocar outro construtor dentro de um construtor, o this() deve
    // ser a PRIMEIRA instrução, senão não compila; podemos chamar apenas um this();
    this(); // chamando construtor sem argumentos
    System.out.println("construtor com String");
  }

  Livro(int... i) {
    this(valor()); // compila porque valor é static
    System.out.println("construtor com varargs de int");
  }

  Livro(int i) {
    System.out.println("construtor com int");
  }

  static int valor() {
    return 65;
  }
}
