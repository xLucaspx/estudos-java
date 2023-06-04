package strings;

public class TestaStringBufferEBuilder {
  public static void main(String[] args) {
    // o construtor pode ser vazio, receber uma string, um int (capacidade) ou outro
    // StringBuilder/StringBuffer;

    System.out.println("StringBuffer:");

    // construtor com string:
    StringBuffer strBuffer = new StringBuffer("Curso");
    strBuffer.append(" de ");
    strBuffer.append("Java - tipos de dados");
    System.out.println(strBuffer.toString());

    // construtor com capacidade; falamos para usar um array com este tamanho
    // inicial, no caso 50, mas que pode ser ultrapassado:
    StringBuffer strBuffer2 = new StringBuffer(50);
    System.out.print(strBuffer2);
    System.out.println(strBuffer2.capacity());

    StringBuffer strBuffer3 = new StringBuffer(strBuffer);
    strBuffer3.append(" para certificação");
    System.out.println(strBuffer3); // o System.out.println chama o toString() do objeto

    /*
     * Podemos alterar todas as ocorrências de StringBuffer no código para
     * StringBuilder. Mesmo assim, possuirão todos os mesmos métodos que serão
     * usados na certificação.
     * 
     * O StringBuffer pertence à uma versão mais antiga do Java, mas é utilizado até
     * hoje, pois realiza o que vimos nesta etapa; já o StringBuilder também tem a
     * mesma ação, porém só surge a partir do Java 5; ele não sincroniza o acesso
     * aos métodos, mas não é uma preocupação imediata para a certificação.
     * 
     * No dia-a-dia, se tivermos StringBuffer ou StringBuilder a ser compartilhada
     * em diversas threads, será mais recomendável utilizarmos a segunda classe,
     * pois possui acesso sincronizado a cada um dos métodos; já o StringBuffer
     * permite o acesso de uma vez só.
     * 
     * Como na maior parte das vezes estamos concatenando Strings e outras coisas do
     * gênero dentro de uma única thread, não precisaremos nos preocupar. Portanto,
     * o StringBuilder é mais utilizado hoje em dia.
     * 
     * É interessante sabermos que quando criamos uma String e a concatenamos com +
     * em Java, o compilador transformará essa concatenação em um append() de um
     * StringBuilder automaticamente, então também não precisaremos nos preocupar
     * com isso.
     * 
     * Os métodos que essas classes fornecem podem ser cobrados na certificação,
     * então precisaremos conhecê-los bem.
     */
    System.out.println("\nStringBuilder:");

    StringBuilder strBuilder = new StringBuilder("Curso");
    strBuilder.append(" de ");
    strBuilder.append("Java - tipos de dados");
    System.out.println(strBuilder.toString());

    StringBuilder strBuilder2 = new StringBuilder(50);
    System.out.print(strBuilder2);
    System.out.println(strBuilder2.capacity());

    StringBuilder strBuilder3 = new StringBuilder(strBuilder);
    strBuilder3.append(" para certificação");
    System.out.println(strBuilder3);
    /*
     * O append() aceita Strings, chars e qualquer sequência de caracteres, como
     * outro StringBuffer ou StringBuilder; isso é possível porque existe uma versão
     * de append() que recebe um object da mesma forma que println(). O object
     * qualquer recebido compilará e chamará o método de toString(), o qual irá
     * devolver o que será concatenado em nossa String.
     * 
     * Lembrando que o toString() padrão é imprimir o tipo da classe e o endereço de
     * referência da variável na memória.
     */
    strBuilder2.append('x');
    strBuilder2.append(78);
    strBuilder2.append(strBuffer2);
    strBuilder2.append(new SemToString());
    strBuilder2.append(new ComToString());
    System.out.println(strBuilder2);

    // Além do append(), poderemos inserir itens com insert(), contando as posições
    // a partir de 0 até onde queremos inserir o novo trecho
    StringBuilder strBuilder4 = new StringBuilder("Curso para certificação");
    strBuilder4.insert(6, "de Java ");
    System.out.println("\n" + strBuilder4);

    // Outro método interessante é o delete() que nos permite excluir caracteres
    // entre uma posição e outra. O array começa na posição 0, portanto, o primeiro
    // caractere possível de ser removido se encontra na posição 0. Ele remove todos
    // os caracteres até a posição final, exceto o da posição final, no caso 9 (J):
    strBuilder4.delete(0, 9);
    System.out.println(strBuilder4);

    // Salvando o valor do SB em um String:
    String valor = strBuilder4.toString();

    // Também podemos inverter uma String:
    System.out.println(new StringBuffer(valor).reverse());

    /*
     * Além desses, há diversos outros métodos que existem na classe String, por
     * exemplo:
     * 
     * trim() remove os espaços em branco na esquerda e na direita;
     * 
     * charAt() pega o caractere em alguma posição;
     * 
     * length() devolve o número de carateres dentro da String;
     * 
     * equal() faz a comparação entre objetos;
     * 
     * indexOf() e lastIndexOf() fazem uma busca da posição de uma outra String a
     * partir de uma posição específica, esteja no início ou no final, para frente
     * ou para trás;
     * 
     * substring() pega um pedaço da String que está dentro.
     * 
     * Todos serão vistos com a classe String, e também existem aqui dentro. Um
     * cuidado importante que devemos ter é que, diferentemente dos outros métodos
     * que vimos até agora, o substring() não altera o StringBuilder ou
     * StringBuffer, assim como o método subSequence(). Apenas devolvem uma nova
     * String com o resultado que esperávamos.
     * 
     * Devemos nos atentar ao "s" minúsculo de substring(), que é uma palavra
     * apenas, e o "S" maiúsculo de subSequence(), que separa duas palavras.
     */

    System.out.println(strBuilder4.substring(0, 4));
    System.out.println(strBuilder4); // não foi alterado
  }
}

class SemToString {
}

class ComToString {
  @Override
  public String toString() {
    return "Classe com método toString";
  }
}
