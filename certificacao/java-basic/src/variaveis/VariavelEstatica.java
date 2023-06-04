package variaveis;

public class VariavelEstatica {
  // uma variável estática, uma variável de classe, existe uma única para todos os
  // objetos daquela classe; se eu criar 5 instâncias diferentes, eu tenho uma
  // única variável de instância, uma única variável estática.
  static int id = 1;
  // Não pode ter uma variável estática e uma variável membro, uma variável de
  // instância, com o mesmo nome na mesma classe:
  // int id;

  // eu posso ter um método que receba um parâmetro ou que tenha uma variável
  // local com o mesmo nome de uma variável de instância ou estática:
  public static void setId(int id) {
    VariavelEstatica.id = id;
  }

  // Quando temos o shadowing, quando escondemos uma das variáveis porque
  // colocamos duas variáveis com o mesmo nome, uma de instância e uma local, uma
  // de estática e uma local, eu vou usar o nome da classe, ou this, para dizer
  // que eu quero referenciar essa variável:
  int y;

  public void setY(int y) {
    this.y = y;
  }

  static void metodo() {
    System.out.println(id);
  }

  public static void main(String[] args) {
    VariavelEstatica teste = new VariavelEstatica();
    // Se eu tenho uma instância posso acessar através dela; senão, posso acessar
    // através da minha classe:
    System.out.println(teste.id);
    System.out.println(VariavelEstatica.id);

    VariavelEstatica.metodo();

    // A regra geral é: variáveis estáticas podem ser acessadas a partir de qualquer
    // lugar desde que sejam respeitados os modificadores de acesso
  }
}
