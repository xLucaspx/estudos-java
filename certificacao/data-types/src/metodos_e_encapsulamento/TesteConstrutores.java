package metodos_e_encapsulamento;

public class TesteConstrutores {
  public static void main(String[] args) {
    // A a1 = new A(); // não compilaria pois alteramos o construtor padrão
    A a2 = new A("n");
    A a3 = new A(); // agora compila pq adicionamos um construtor sem argumentos

    System.out.println(a2.nome);
    System.out.println(a3.sobrenome);
  }
}

class A {
  // as variáveis são inicializadas ANTES do construtor
  String nome; // começa valendo null
  // int tamanho = tamanhoDoNome(); // nullPointerException
  String sobrenome = "default";
  // se tamanho estivesse antes de sobrenome, teríamos outra nullPointerException,
  // pois sobrenome não teria sido inicializada ainda quando o método foi chamado,
  // e valeria null:
  int tamanho = tamanhoDoSobrenome();
  /*
   * se você ver variável membro sendo inicializada chamando método, se você ver
   * construtor chamando método, herança envolvida, toma bastante cuidado, olha
   * com calma e vê se as variáveis acessadas já foram inicializadas no instante
   * em que elas são acessadas, segue o fluxo, linha a linha do que está
   * acontecendo.
   */

  // o nome do construtor é EXATAMENTE o nome da classe + possíveis modificadores
  // de ACESSO e parâmetros; construtor NÃO TEM RETORNO, poi ele, por padrão,
  // retornaa instância da classe que está sendo criada

  // o construtor, por padrão, chama super(); todas as classes herdam de Object
  // o construtor, por padrão, tem a mesma visibilidade que a classe
  // no momento em que adicionamos um construtor personalizado, o compilador deixa
  // de adicionar o construtor padrão
  A(String nome) {
    this.nome = nome;
  }

  // podemos sobrecarregar o construtor; também podemos adicionar um construtor
  // sem argumentos:
  A() {
    // um construtor pode entrar em looping infinito chamando ele mesmo:
    // new A(); // loop infinito
  }

  int tamanhoDoNome() {
    return this.nome.length();
  }

  int tamanhoDoSobrenome() {
    return this.sobrenome.length();
  }
}
