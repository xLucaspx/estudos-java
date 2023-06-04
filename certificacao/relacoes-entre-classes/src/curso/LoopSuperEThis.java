package curso;

import java.io.IOException;

public class LoopSuperEThis {
  public static void main(String[] args) throws IOException {
    System.out.println("debug");
    new B().metodo();
  }
}

class A {
  public void metodo() {
    System.out.println("a");
    this.metodo2();
    // com ou sem this, quando B chama super.metodo() e este, por sua vez, chama
    // metodo2() ou this.metodo2(), não estamos chamando o metodo2 da classe A, mas
    // sim o da classe B, e o metodo2 da classe B chama super.metodo e criamos um
    // loop; cuidado com o escopo do this, ele vale para o Objeto que está chamando.
    // Lembrando que o binding dos métodos é feito em tempo de EXECUÇÃO
  }

  public void metodo2() {
    System.out.println("metodo 2 do pai");
  }
}

class B extends A {
  public void metodo() {
    System.out.println("b");
    super.metodo();
  }

  public void metodo2() {
    System.out.println("c");
    metodo();
    super.metodo();
  }
}
