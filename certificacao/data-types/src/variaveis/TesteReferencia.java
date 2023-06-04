package variaveis;

public class TesteReferencia {
  public static void main(String[] args) {
    // Variáveis de tipo primitivo COPIAM o valor na atribuição
    int a = 10;
    int b = a;
    a = a + 5;

    System.out.println(a); // 15
    System.out.println(b); // 10

    // Variáveis de referência APONTAM para o objeto, ou seja, criam uma nova
    // referência para o mesmo objeto
    Objeto o1 = new Objeto();
    o1.valor = 10;
    Objeto o2 = o1; // não usamos construtor
    o1.valor = o1.valor + 5;

    System.out.println(o1.valor); // 15
    System.out.println(o2.valor); // 15
  }
}

class Objeto {
  int valor;
}
