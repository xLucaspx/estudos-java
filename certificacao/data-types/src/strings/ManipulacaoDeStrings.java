package strings;

public class ManipulacaoDeStrings {
  public static void main(String[] args) {
    // duas maneiras tradicionais de criar Strings:
    String nomeDireto = "Java";
    String nomeIndireto = new String("Java");
    // outras formas:
    char[] nome = new char[] { 'J', 'a', 'v', 'a' };
    String nome1 = new String(nome);

    StringBuilder sb = new StringBuilder("Java");
    String nome2 = new String(sb);

    System.out.println(nomeDireto);
    System.out.println(nomeIndireto);
    System.out.println(nome1);
    System.out.println(nome2);

    // Como uma String não é um tipo primitivo, ela pode ter valor null:
    String nomeNulo = null; // explicit null
    // nomeNulo.length(); // null pointer exception

    String frase = "frase" + " " + "concatenada";
    String fraseComNull = frase + " com " + nomeNulo;
    System.out.println(frase); // frase concatenada
    System.out.println(fraseComNull); // frase concatenada com null

    String fraseComNumero = "certificação " + 1500;
    System.out.println(fraseComNumero); // certificação 1500
    System.out.println(1500 + " certificação"); // 1500 certificação
    System.out.println(1 + 500 + " certificação"); // 501 certificação (precedência de operadores, esq -> dir)
    System.out.println(1 + (50 + (0 + " certificação")));// 1500 certificação

    // Strings são IMUTÁVEIS:
    String s = "referências";
    s.toUpperCase(); // devolve uma referência a um novo objeto
    System.out.println(s); // não mudou
    s = s.toUpperCase();
    System.out.println(s); // agora mudou pois alteramos a referência da variável s

    System.out.println(s.charAt(5)); // Ê
    // System.out.println(s.charAt(500)); // String index out of bounds exception

    System.out.println(s.length()); // MÉTODO (não é atributo da String) que retorna o tamanho da String
    System.out.println(s.isEmpty()); // Método que retorna se a string está vazia
    System.out.println("".isEmpty()); // true;
    System.out.println("   ".isEmpty()); // false;
    System.out.println("".isBlank()); // true;

    System.out.println("   quero estudar java     ".trim()); // trim() remove os espaços vazios na esq e dir

    System.out.println(fraseComNumero.substring(13));
    System.out.println(fraseComNumero.substring(8, 15));
    // String index out of bounds exception:
    // System.out.println(fraseComNumero.substring(-1, 57));

    // method chaining
    System.out.println(fraseComNumero.substring(8).toUpperCase().trim());

    System.out.println(nomeDireto.equals("java"));
    System.out.println(nomeDireto.equalsIgnoreCase("java"));

    // compareTo compara os caracteres lexicográficamente; na tabela ASCII,
    // maiúsculas vem antes de minúsculas, então UpperCase < LowerCase
    System.out.println(nomeDireto.compareTo("java")); // devolve número negativo (Java < (vem antes de) java)
    System.out.println(nomeDireto.compareTo("JAVA")); // devolve número positivo (Java > (vem depois de) JAVA)
    System.out.println(nomeDireto.compareToIgnoreCase("java")); // devolve 0 (java == java)

    // métodos de busca:
    String texto = "Pretendo fazer a prova de certificação de Java";
    System.out.println(texto.indexOf("ação")); // posição onde encontrou a string, no caso 34
    System.out.println(texto.indexOf("Node")); // se não encontrou retorna -1
    System.out.println(texto.indexOf('a')); // podemos buscar qualquer caractere; saída: 10
    System.out.println(texto.lastIndexOf("a")); // buscando ao contrário; saída: 45
    System.out.println(texto.indexOf("f", 10)); // buscando a partir de uma posição

    System.out.println(texto.contains("Java")); // true
    System.out.println(texto.contains("y")); // false

    System.out.println(texto.startsWith("Pretendo")); // true
    System.out.println(texto.endsWith("C")); // false
    /*
     * Os principais métodos da String que usamos bastante no dia-a-dia são:
     * 
     * length() que nos devolve seu tamanho;
     * 
     * isEmpty() que nos diz se length() é maior do que zero ou não, ou seja, se a
     * String está vazia ou não. A resposta pode ser verdadeira ou falsa;
     * 
     * toUpperCase() que transforma as letras em maiúsculas;
     * 
     * toLowerCase() que transforma as letras em minúsculas;
     * 
     * trim() tira os espaços em branco da esquerda e da direita da String;
     * 
     * substring() recebe um índice de começo e final ou apenas do início, e devolve
     * um trecho da String;
     * 
     * concat() adiciona uma outra String em nossa atual, lembrando que devolve uma
     * nova pois cada uma é imutável;
     * 
     * String replace() recebendo char oldChar e char newChar troca um caractere por
     * outro, devolvendo uma String nova pelo mesmo motivo;
     * 
     * String replace() recebendo CharSequence target e CharSequence replacement
     * troca todas as aparições de uma String por outra, podendo ser também
     * StringBuilder ou StringBuffer;
     */
  }
}
