package curso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestaTratamentoException2 {
  public static void main(String[] args) {
    System.out.println("Teste 1: ");
    metodo1();

    System.out.println("\nTeste 2:");
    // try-catch opcional (unchecked exception)
    try {
      new ContaDoBem().sacaUnchecked(500);
    } catch (Exception e) {
      System.out.println("Exception tratada: " + e.getMessage());
    }

    System.out.println("\nTeste 3:");
    // try-catch (ou throws) obrigatório (checked exception)
    try {
      new ContaDoBem().sacaChecked(500);
    } catch (SaldoInsuficienteException e) {
      System.out.println("Exception tratada: " + e.getMessage());
    }
  }

  public static void metodo1() {
    System.out.println("primeiro antes");

    try {
      metodo2();
      System.out.println("primeiro depois");

      // se o try tiver mais de um catch, a ordem de tratamento de exceções importa:
      // por causa do polimorfismo, devemos tratar das mais específicas para as mais
      // genéricas; não é possível tratar, por exemplo, primeiro RuntimeException e
      // depois NullPointerException, pois a segunda é filha da primeira e cairia no
      // primeiro bloco catch, já o inverso poderia ser feito:
    } catch (RuntimeException e) {
      System.out.println("RuntimeException tratada " + e.getMessage());

    } catch (Exception e) {
      System.out.println("Exception tratada: " + e.getMessage());

    } // catch (NullPointerException e) {} // não compila: Unreacheable catch block
    System.out.println("Fim do metodo1");
  }

  public static void metodo2() {
    String s = null;
    System.out.println("segundo antes");
    s.length();
    System.out.println("segundo depois");
  }
}

class ContaDoBem {
  double saldo = 100;

  void sacaUnchecked(double valor) {
    if (this.saldo < valor) {
      throw new IllegalArgumentException("Saldo insuficiente para realizar operação!");
    }
    this.saldo -= valor;
  }

  void sacaChecked(double valor) throws SaldoInsuficienteException {
    if (this.saldo < valor) {
      throw new SaldoInsuficienteException("Saldo insuficiente para realizar operação!");
    }
    this.saldo -= valor;
  }
}

class SaldoInsuficienteException extends Exception {
  // quem herda de Exception é checked, RuntimeException é unchecked!
  SaldoInsuficienteException(String message) {
    super(message);
  }
}

class AcessaArquivo {
  // quando, por exemplo, em uma declaração de variáveis em uma classe, ou na
  // inicialização de um objeto, puder ocorrer uma exception checked, o código só
  // vai compilar se tratarmos o problema no construtor da classe:
  InputStream is = new FileInputStream("a.txt");

  AcessaArquivo() throws FileNotFoundException {
  }
}
