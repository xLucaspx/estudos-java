package curso;

public class TesteCaracteres {
  public static void main(String[] args) {
    char letra = 'a'; // deve ser aspas simples. valor de apenas um caractere
    System.out.println(letra);

    char valor = 66; // char na verdade é um tipo numérico que remete à tabela ASCII
    System.out.println(valor);

    valor = (char) (valor + 1); // type casting pois int é maior que char, e quero a resposta como char
    System.out.println(valor);

    String palavra = "Curso de sintaxe Java"; // deve ser aspas duplas. quantos caracteres quiser
    System.out.println(palavra);
  }
}
