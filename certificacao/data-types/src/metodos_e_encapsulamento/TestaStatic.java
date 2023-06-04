package metodos_e_encapsulamento;

public class TestaStatic {
  public static void main(String[] args) {
    Moto m1 = new Moto();
    Moto m2 = new Moto();
    Moto m3 = new Moto();
    System.out.println(Moto.getTotalDeMotos());

    // Moto.marca = "Honda"; // não compila: marca não é static
    m1.marca = "Honda";
    m2.marca = "Harley";
    m3.marca = "Yamaha";

    // Caso o tipo referenciado de uma variável seja A em tempo de compilação, o
    // método será o da classe A. Se for referenciado como B, será o método da
    // classe B:
    Motocicleta mc1 = new Motocicleta();
    m2 = mc1;
    System.out.println(mc1.getTotalDeMotos()); // 100000 (Motocicleta)
    System.out.println(m2.getTotalDeMotos()); // 13 (Moto)
  }

  static void x() {
  }
}

class Moto {
  // como static, ela vira uma variável da classe e não uma variável de instância
  private static final int PADRAO_TOTAL_DE_MOTOS = 9;
  // A definição de uma variável static pode invocar métodos e variáveis static
  private static int totalDeMotos = PADRAO_TOTAL_DE_MOTOS;
  String marca;

  Moto() {
    totalDeMotos++;
  }

  // Quando o método é estático, quando a variável é estática, o escopo dela é a
  // classe e não o objeto
  public static int getTotalDeMotos() {
    // marca = "Honda"; erro: não pode acessar algo não static
    return totalDeMotos;
  }
}

class Motocicleta extends Moto {
  // não compila - não pode sobrescrever o metodo static da classe mãe:
  // int getTotalDeMotos() {
  // return 1;
  // }

  // mas se for static e tiver a mesma visibilidade, compila; não é sobrescrita,
  // são dois métodos diferentes, cada um chamado pela sua classe
  public static int getTotalDeMotos() {
    return 100000;
  }
  /*
   * Métodos estáticos não tem a sobrescrita da mesma maneira que métodos de
   * classe terão, no método estático se eu sobrescrever ele na minha classe
   * filha, eu vou ter dois métodos diferentes, ou chamo um ou eu chamo outro. Se
   * eu chamar através da instância, eu estou sempre chamando através do tipo da
   * variável e não do tipo referenciado em tempo de execução.
   */
}
