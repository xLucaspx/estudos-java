package curso;

public class ComparacaoDeStrings {
  public static void main(String[] args) {
    String nome1 = new String("Lucas");
    String nome2 = new String("Lucas");
    System.out.println(nome1 == nome2); // false
    /*
     * quando usamos o operador == em Java para fazer comparação de objetos, o que
     * na verdade estamos fazendo é comparando se aquelas duas variáveis apontam
     * para a mesma referência, para o mesmo objeto.
     */
    nome1 = "Lucas";
    nome2 = "Lucas";
    System.out.println(nome1 == nome2); // true
    /*
     * Quando se trata de Strings o Java é um pouco mais esperto. Ele mantém um pool
     * com os objetos mais utilizados e sempre que for possível ele tenta reutilizar
     * essas strings. Como são objetos muito grandes, ao invés de ficar toda hora
     * recriando vários objetos com o mesmo conteúdo, o Java guarda esses objetos no
     * pool e tenta reutilizá-los sempre que possível.
     * 
     * Quando criamos nome1 ele pegou o conteúdo dessa variável e jogou dentro do
     * pool. Ao criar o nome2, ele viu que esse conteúdo já tem no pool, então criou
     * novamente a variável, simplesmente fez essa variável nome2 apontar para o
     * mesmo objeto que já estava criado anteriormente. Por isso quando rodamos
     * nosso sysout e fazemos a comparação, ele dá true, porque na verdade nós só
     * temos uma string criada na memória e as duas variáveis acabam apontando para
     * o mesmo objeto.
     * 
     * Mas por que ele não fez isso anteriormente com a primeira execução do nosso
     * código? Pois o Java só consegue colocar as strings no pool quando criamos
     * elas usando os literais, ou seja, quando criamos elas usando as aspas duplas.
     * Quando instanciamos Strings usando o operador new, o Java não consegue
     * analisar e verificar se aquela string já existe ou não ali dentro do pool,
     * então ele sempre vai criar um novo objeto na nossa memória, o que faz com que
     * nós tenhamos que ter cuidado redobrado na hora de ficar fazendo comparação
     * entre objetos do tipo string.
     *
     * Se quisermos fazer uma comparação de Strings baseada no conteúdo da string, e
     * não apenas na posição de memória, ao invés de usarmos == para fazermos essa
     * comparação, nós devemos usar o método equals e passar para ele a string que
     * queremos comparar:
     */
    String nome3 = new String("Lucas");
    System.out.println(nome1 == nome3); // false
    System.out.println(nome1.equals(nome3)); // true

    // ao concatenar dois literais o resultado também é um literal
    String ab = "a" + "b"; // "ab" literal: é adicionado ao pool
    System.out.println(ab == "ab"); // true

    // concatenação que envolve uma referência o resultado é uma nova String:
    String a = "a";
    ab = a + "b"; // não é colocada no pool
    System.out.println(ab == "ab"); // false

    // Imutabilidade:
    String texto = "um texto qualquer";
    // Ao chamar um método em uma String, por serm imutáveis, o Java retorna um novo
    // objeto do tipo String
    String sub = texto.substring(3, 8); // texto
    System.out.println(sub == "texto"); // false pois sub não foi adicionada ao pool
    System.out.println(sub.equals("texto")); // true, mesmo conteúdo

    // caso o retorno do método for exatamente o conteúdo atual do objeto, nenhum
    // objeto novo é criado, as duas referências apontarão para o mesmo objeto
    System.out.println(texto.toLowerCase() == texto); // true pois o texto já estava em lower case; mesma referência
    System.out.println(texto.toUpperCase() == texto.toUpperCase()); // false pois foram criados dois objetos;
    System.out.println(texto.toString() == texto); // true pois o texto já era uma String; mesma referência

    // Questão: quantos objetos são criados no seguinte trecho de código:

    // linha 76 - 2 objetos: new instancia uma nova String e "hello ", declarada com
    // aspas duplas (literals) também conta como objeto e é adicionada ao pool:
    String h = new String("hello ");
    // linha 78 - 0 objetos: a String "hello " já estava no pool pela linha acima:
    String h1 = "hello ";
    // linha 80 - 1 objeto: world ainda não existia até esta linha
    String w = "world";

    // linha 83 - nenhum objeto: "hello " está no pool
    System.out.println("hello ");
    // linha 86 - 1 objeto: o retorno da concatenação, pois h1 e "world" já existem;
    // não é adicionada ao pool
    System.out.println(h1 + "world");
    // linha 88 - 1 objeto: "Hello " com H maiúsculo ainda não existia
    System.out.println("Hello " == h1);

    // Resposta: São criados 5 objetos!
    System.out.println(h + w);
  }
}
