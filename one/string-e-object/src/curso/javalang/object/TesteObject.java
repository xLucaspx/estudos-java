package curso.javalang.object;

public class TesteObject {
  public static void main(String[] args) {
    Conta conta = new Conta(2547, 75456);
    Object contaO = new Conta(7895, 25468); // Object é o tipo mais genérico; todas as classes herdam dele

    System.out.println(conta); // equivale a chamar o metodo .toString() (que sobrescrevemos em Conta)
    System.out.println(contaO);
  }
}
