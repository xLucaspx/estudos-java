package curso;

public class ReferenciaEConcatenacao {
  public static void main(String[] args) {
    // o ponto é o operador de refêrencia:
    String nome = "Lucas";
    System.out.println(nome.length());

    // o sinal de adição é o operador de concatenação de Strings
    String nomeCompleto = nome + " " + "Oliveira";
    System.out.println(nomeCompleto);
    /*
     * A classe String é a única que aceita um operador, fora o operador de
     * referência (.), sem ser os operadores para os tipos primitivos. E como ela é
     * a única que pode fazer isso, quer dizer que não tenho como criar uma classe
     * em Java que possa ter o meu próprio operador, ou seja, em Java não há
     * sobrecarga de operadores.
     */
  }
}
