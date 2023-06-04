package classes;

// a primeira coisa que um arquivo Java pode ter é o pacote, que é opcional.
// depois disso eu posso ter os imports, sempre depois do package.
// por fim, vem as classes, interfaces, enums, e quaisquer outras coisas que teremos dentro do Java

// Essas 3 partes, pacote, imports e tipos, são todos opcionais. O pacote só pode ter um, mas imports
// e tipos, podemos ter vários. Sempre nessa ordem específica: pacote, import, tipos.
// Comentários entram em qualquer lugar do meu código.

// package é opcional, posso ter 1 ou 0.
// O import posso ter 0, 1 ou mais.
// classes, enums, interfaces e seja lá o que for que temos abaixo, posso ter 0 ou mais

// Quando eu não estou falando nada sobre o pacote é porque ele está no pacote padrão,
// o pacote sem nome, o package deafult. Ele está no diretório raiz.

// comentário
/* bloco de comentário */
/** javadoc */
public class EstruturaDeClasse {
  // a variável static int total = 0, que começa com zero, não precisa de uma
  // instância para existir; inclusive, não importa a quantidade de instâncias que
  // você tenha, a variável total é uma só, com valor 14, 2, 35, etc. Mas a
  // variável é uma só. Essa variável é a variável estática, variável de classe.
  static int total = 0;
  String nome;

  EstruturaDeClasse(String nome) {
    // construtor NÃO RETORNA NADA pois ele já retorna a instância da classe.
    // EXCETO return vazio
    if (nome == null) {
      nome = "Anônimo";
      return;
    }
    this.nome = nome;
  }

  public String getNome() {
    String sobrenome = "Oliveira";
    return nome + " " + sobrenome;
  }
}

// Um cuidado importante a ser tomado é que dentro de um arquivo .java eu só
// posso ter uma interface, classe ou tipo público. Aqui temos duas classes, uma
// pública e outra padrão.

// Se for público, só pode ter um, e tem mais uma regra: se ele é público ele
// tem que ter o mesmo nome que o arquivo, porque se ele pode ser acessado em
// outro pacote, se ele é público, eu tenho que deixá-lo com o mesmo nome do
// arquivo para ser fácil de descobrir onde ele está.
class A {
  // não existe conflito entre o nome de uma variável e nome de uma classe.
  int A;

  // Repara a diferença entre o construtor e o método, muito importante. O método
  // está falando que devolve void, o construtor não faz nada. Uma “pegadinha”
  // seria ter um construtor e um método com o mesmo nome, ou não colocar o
  // construtor e fazer parecer que o método é o construtor, void A(). Não é o
  // construtor, está escrito void, é o método.
  A(int A) {
    this.A = A;
  }

  // Não há conflito entre o nome da variável membro, o nome do método e o nome da
  // classe.
  void A() {
    System.out.println(A);
  }
}

interface B {
  // Na certificação o que é cobrado que pode ter dentro de uma interface são as
  // variáveis constantes, isso é, uma variável que é final, por exemplo:
  int TAMANHO = 5; // Essa variável final não pode ter o seu valor ou a sua referência alterada.
  // public static final int TAMANHO = 5

  // As variáveis das interfaces por padrão são public static final, e os métodos
  // são public abstract
  void autentica(String nome, String senha);
  // public static void autentica(String nome, String senha);
}
