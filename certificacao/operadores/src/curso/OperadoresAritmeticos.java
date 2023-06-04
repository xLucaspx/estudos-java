package curso;

public class OperadoresAritmeticos {
  public static void main(String[] args) {
    int dois = 2;
    int dez = 10;

    int doze = dois + dez; // soma
    int oito = dez - dois; // subtração
    int vinte = 10 * 2; // multiplicação
    int cinco = 10 / 2; // divisão
    int restoDeCincoPorDois = cinco % dois; // mod

    System.out.println(oito + vinte);
    System.out.println(restoDeCincoPorDois);

    /*
     * quando eu faço uma operação aritmética qual é o tipo retornado? Para sabermos
     * isso temos que dar uma olhada no tipo dos dois caras que estamos usando nessa
     * operação aritmética. REGRA GERAL: vai devolver NO MÍNIMO um int, mas SEMPRE o
     * maior dos tipos envolvidos na operação; ex.:
     * byte com byte retorna int
     * int com int retorna int
     * int com long retorna long
     * int com float retorna float
     */

    // não existe divisão por 0 (numeros inteiros - arithmeic exception):
    // int divisao1 = 5 / 0; // compila mas lança erro de EXECUÇÃO

    // mas existe divisão por 0.0 (números com ponto flutuante):
    double infinitoPositivo = 5 / 0.0;
    double infinitoNegativo = -5 / 0.0;
    double divisao4 = (doze + 0.0) / 0; // int + 0.0 = double
    // double divisao4 = (doze + 0) / 0; // exception (int + int = int)

    System.out.println(infinitoPositivo); // Infinity
    System.out.println(infinitoNegativo); // -Infinity
    System.out.println(divisao4); // Infinity

    System.out.println(infinitoPositivo + infinitoNegativo); // NaN
    // as regras de sinal (+/-) se aplicam nas contas envolvendo Infinity
    // ex.: infinity - (-infinity) = infinity
    // -infinity + (-infinity) = infinity
    // -infinity - infinity = -infinity
  }
}
