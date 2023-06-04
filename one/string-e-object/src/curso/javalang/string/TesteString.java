package curso.javalang.string;

public class TesteString {
  public static void main(String[] args) {
    // String é uma classe do pacote java.lang (único pacote que não precisa ser importado)

    String nome = "LUCAS"; // Chamamos essa sintaxe de objeto literal.

    // String nome = new String("Lucas"); = é má prática e não deve ser usado

    nome.toLowerCase(); // não funciona: uma vez instanciada, uma string não pode ser alterada dessa forma
    System.out.println(nome + " - não alterou");

    // todos os metodos de uma string retornam outra string:

    String nomeAlterado = nome.toLowerCase(); // agora alteramos com outra referência, então funciona
    System.out.println(nomeAlterado + " - alterou");

    System.out.println(nome.indexOf("AS")); // retorna a posição onde a expressão passada começa na string

    char x = 'x'; // char: um uníco caractere entre aspas SIMPLES
    char a = nome.charAt(3); // retorna 'A'

    String nomeReplaced1 = nome.replace(a, x); // replace usando chars
    String nomeReplaced2 = nome.replace("AS", "RA"); // replace usando charsequence

    System.out.println(nomeReplaced1 + " e " + nomeReplaced2 + " - usando replace");

    int comprimentoNome = nome.length();
    System.out.println(nome + " tem " + comprimentoNome + " letras; são elas:");

    for (int i = 0; i < nome.length(); i++) {
      System.out.print(nome.charAt(i) + " ");
    }

    String emp = ""; // string vazia - isEmpty() = true
    String tab = "	"; // string com 1 tab - isEmpty = false; isBlank() = true

    String vazio = tab.trim(); // trim remove espaços

    System.out.println(tab);
    System.out.println(emp.isEmpty() + " - " + tab.isEmpty() + " - " + vazio.isEmpty());
    System.out.println(emp.isBlank() + " - " + tab.isBlank() + " - " + vazio.isBlank());

    String nomeEspacado = "  	L u c a s      ";
    String nomeNormal = nomeEspacado.trim();

    System.out.println("sem trim:" + nomeEspacado + ".");
    System.out.println("com trim: " + nomeNormal + ".");

    String sub = nome.substring(3); // cria uma substring a partir do numero passado. saída: AS

    System.out.println(nome.contains("LU")); // pesquisa uma substring dentro de uma string
    System.out.println(nome.contains(sub));
  }
}
