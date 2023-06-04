package curso;

public class TesteConversao {
  public static void main(String[] args) {
    double salario = 1270.50;
    int valor = (int) salario; // type casting

    System.out.println(valor);

    // float pontoFlutuante = (float) 3.14; pode ser feito de maneira mais simples:
    float pontoFlutuante = 3.14f;
    System.out.println(pontoFlutuante);

    double valor1 = 0.1;
    double valor2 = 0.2;
    double soma = valor1 + valor2; // floating point math

    System.out.println(soma);
  }
}
