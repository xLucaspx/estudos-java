package curso;

public class TestaAbstractEInterface {
  public static void main(String[] args) {
    // Uma classe abstrata não pode ser instanciada sem ser herdada:
    // new SemMetodo(); // não compila
    ComMetodoAbstrato h = new Herdada();
    h.imprime(42);

    // acessando variável da interface
    System.out.println(K.X);
    // K.X = 100; // não compila pois é public static final
  }
}

// uma classe abstrata pode ser declarada sem métodos:
abstract class SemMetodo {
}

// mas uma classe com métodos abstratos DEVE SER abstrata:
abstract class ComMetodoAbstrato {
  abstract void imprime(int i);

  abstract void m(double d);
}

// classes que herdam de classes abstratas: ou implementam todos os métodos da
// classe abstrata que herdaram e podem ser consideradas concretas, ou devem ser
// declaradas como abstratas:
class Herdada extends ComMetodoAbstrato {

  @Override
  void imprime(int i) {
    System.out.println(i);
  }

  @Override
  void m(double d) {
    System.out.println(d);
  }
}

// se implementar todos os métodos abstratos em uma classe, é possíver ter outra
// classe que herda desta, e que pode ser abstrata; além disso, esta classe pode
// sobrescrever métodos para torná-los novamente abstratos, ou implementá-los:
abstract class HerdadaAbstrata extends Herdada {
  abstract void imprime(int i);

  void m(double d) {
    System.out.println("double: " + d);
  }
}

// em uma interface, todos os métodos de instância implementados são abstratos:
interface I {
  // public e abstract são opcionais pois todos os métodos de interface já são
  // definidos desta forma por padrão:
  void metodo1(int i);

  public abstract void metodo2(double d);
}

interface J {
  void metodo3(String s);
}

// Assim como em classes abstratas, não pe possível instanciar uma interface sem
// herdar dela, sem implementá-la. Além disso, uma interface pode HERDAR (não
// implementar) de várias interfaces:
interface K extends I, J {
  // variáveis de interfaces são, por padrão, public static final:
  int X = 10;
  public static final int Y = 50;
}
