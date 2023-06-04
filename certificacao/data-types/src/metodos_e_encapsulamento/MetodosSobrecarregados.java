package metodos_e_encapsulamento;

public class MetodosSobrecarregados {
  public static void main(String[] args) {
    Overloader o = new Overloader();
    // o método sobrecarregado sempre chama a versão mais específica na invocação, a
    // não ser quando forçamos uma interpretação diferente:
    o.metodo(); // void
    o.metodo(2); // com int
    o.metodo(5.0); // com double
    o.metodo((short) 7); // com int
    o.metodo((float) 7); // com double

    o.metodo2(""); // com String
    o.metodo2(new Object()); // com Object
    o.metodo2((Object) ""); // com Object

    // trocar a ordem dos parâmetros também é uma sobrecarga válida de método:
    o.metodo3("", 12); // com String e int
    o.metodo3(12, ""); // com int e String

    // se o compilador não entender qual invocação você quer, ele não deixa o código
    // compilar; por ex: int pode ser promovido a double, se o método tem uma
    // chamada que recebe int e double e uma que recebe double e int, e você passa
    // dois int como parâmetros, não compila pois ele não sabe qual chamar:
    o.metodo4(1, 2.0); // com int e double
    o.metodo4(2.0, 1); // com double e int
    // o.metodo4(1, 2); //não compila: the method is ambiguous

    // No caso de sobrecarga com tipos que possuem polimorfismo, como
    // em Object ou String, o compilador sempre invoca o método com o tipo mais
    // específico (menos genérico)
    o.metodo5("", ""); // String e String
    o.metodo5(new Object(), new Object()); // Object e Object
    o.metodo5("", new Object()); // Object e Object
  }
}

class Overloader {
  public void metodo() {
    System.out.println("void");
  }

  // Um método só é sobrecarregado se ele possui um mesmo nome e tipos ou
  // quantidade de parâmetros diferentes; então, nesse caso, como eu não estou
  // sobrecarregando, eu estou criando um mesmo método, não compila!
  // public int metodo() {}

  public int metodo(int i) {
    System.out.println("com int");
    return i;
  }

  public double metodo(double d) {
    System.out.println("com double");
    return d;
  }

  public void metodo2(String s) {
    System.out.println("com String");
  }

  public void metodo2(Object o) {
    System.out.println("com Object");
  }

  public void metodo3(String s, int i) {
    System.out.println("com String e int");
  }

  public void metodo3(int i, String s) {
    System.out.println("com int e String");
  }

  public void metodo4(int i, double d) {
    System.out.println("com int e double");
  }

  public void metodo4(double d, int i) {
    System.out.println("com double e int");
  }

  public void metodo5(String s1, String s2) {
    System.out.println("String e String");
  }

  public void metodo5(Object o1, Object o2) {
    System.out.println("Object e Object");
  }
}
