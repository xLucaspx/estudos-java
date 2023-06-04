package curso;

public class TestaHeranca {
  public static void main(String[] args) {
    Filha f = new Filha();
    Neta n = new Neta();

    // atributos protected, acessíveis por quem herda; se fosse private, por
    // exemplo, não compilaria
    f.x = 10;
    n.x = 35;

    // métodos public; se fossem default e a classe Mãe estivesse em outro pacote,
    // por exemplo, não compilaria
    f.y();
    n.y();

    // referenciando método estático da classe Mae:
    Mae.metodo();
    Filha.metodo();
    // não foi herdado, foi "sobrescrito"/redefinido na classe Neta:
    Neta.metodo();
    // lembrando que, para métodos estáticos, o binding do método é feito em tempo
    // de COMPILAÇÃO:
    Mae mComoN = n; // polimorfismo
    mComoN.metodo();

    // o toString tende a ser chamado automaticamente quando usamos um Objeto no
    // contexto de uma String:
    System.out.println(f);
    String s = "método " + mComoN;
    System.out.println(s);
  }
}

// toda classe, por padrão, herda de object; para que uma classe possa ser
// herdada, ela não pode ser final!
class Mae {
  protected int x;

  Mae() {
  };

  public void y() {
    System.out.println("invocando y em um objeto");
  }

  // métodos estáticos não são herdados, mas podem ser referênciados; o Java
  // referencia em tempo de compilação, então vai chamar o método do tipo da
  // variável que está referenciada.
  public static void metodo() { // metodos estáticos não podem ser abstratos, pois não podem ser sobrescritos
    System.out.println("método estático da classe Mae");
  }

  // o método toString padrão devolve o tipo_do_obj@endereco_na_memoria, por isso
  // o sobrescrevemos:
  @Override
  public String toString() {
    return "toString sobrescrito";
  }
}

class Filha extends Mae {
  // todo construtor, por padrão, chama o construtor da classe mãe; se não herdar
  // de ninguém, chama o construtor de Object. Além disso, o construtor da classe
  // mãe DEVE ser acessível pela classe filha (public ou protected), senão o
  // código não compila. Se a classe mãe não possui um construtor sem argumentos,
  // devemos passar os argumentos necessários no super(), senão também não compila
  Filha() {
    super();
  }
}

// só podemos herdar de UMA classe
class Neta extends Filha {
  // Não existe sobrescrita de atributos. Podemos ter um atributo na classe filha
  // com mesmo nome da mãe, mas não chamamos de sobrescrita. Nesses casos, o
  // objeto vai ter 2 atributos diferentes, um da mãe (acessível com super) e um
  // na filha (acessível com this):
  int x;

  Neta() {
    this.x = 15;
    super.x = 50;
  }

  // reescrevendo metodo estático da classe Mae:
  public static void metodo() {
    // super.metodo(); // não compila: can't use super in a static context
    System.out.println("método estático da classe Neta");
  }
}
