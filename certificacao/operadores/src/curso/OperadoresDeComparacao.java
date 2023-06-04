package curso;

public class OperadoresDeComparacao {
  public static void main(String[] args) {
    // comparações de tipos primitivos:

    // booleanos só podem ser comparados em quesito de igualdade:
    System.out.println(true == false); // igual (==)
    System.out.println(true != false); // diferente (!=)

    // numericos podem ser comaparados em igualdade e matematicamente:
    System.out.println(2 > 1); // maior que (>)
    System.out.println(2 < 1); // menor que (<)
    System.out.println(2 >= 1); // maior ou igual (>=)
    System.out.println(2 <= 1); // menor ou igual (<=)

    // comparações de referências também só existem em quesito de igualdade; os
    // operadores comparam se as duas referências apontam para o mesmo objeto

    // cada tipo - numéricos, booleanos e referências - só podem ser comparados
    // entre si, de outra forma temos um erro de compilação; Porém, podemos comparar
    // char com numéricos, pois chars possuem valores numéricos
  }
}
