package metodos_e_encapsulamento;

class ModificadoresDeAcessoEEncapsulamento {
  /*
   * O Java possui quatro modificadores de acesso:
   * 
   * - Public: qualquer um pode acessar;
   * 
   * - Protected: Quem herda, está dentro ou no mesmo pacote pode acessar
   * 
   * - Default: modificador padrão, não usa palavra-chave. Apenas quem está dentro
   * ou no mesmo pacotepode acessar.
   * 
   * - Private: apenas quem está dentro pode acessar;
   * 
   * classes e interfaces (top-level) podem ser public ou default;
   * membros e classes internas (inner) podem ter qualquer um dos modificadores.
   * 
   * Variáveis locais - isso é, variáveis definidas dentro de um bloco ou
   * definidas como parâmetro de métodos - não tem modificador de acesso,
   * principalmente porque não faz sentido: elas só irão viver dentro daquele
   * código, então só quem está dentro do bloco tem acesso ao seu escopo.
   */
}

class Pessoa {
  /*
   * A especificação do Java Beans é composta por diversas coisas, e uma delas é
   * dizer que o construtor tem que ser sem argumentos e que nós devemos ter as
   * variáveis private e getters e setters públicos; no dia a dia, como uma boa
   * pratica, só colocamos público se realmente precisamos.
   * 
   * um outro termo além de encapsulamento (encapsulation) pode ser esconder
   * informações (information hiding).
   * 
   * o termo de encapsulamento básico cobrado na prova é: deixar os métodos
   * públicos de acesso e deixar as variáveis privadas para ninguém acessar;
   * esconde o acesso às variáveis com private e libera o acesso às coisas através
   * de métodos, no Java Beans esse padrão é feito através de variáveis privadas,
   * getters e setters públicos.
   */
  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (nome == null) {
      nome = "";
    }
    this.nome = nome;
  }
}