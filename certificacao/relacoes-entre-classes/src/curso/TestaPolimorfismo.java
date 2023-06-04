package curso;

public class TestaPolimorfismo {
  // método polimórfico:
  static void metodo(Veiculo v) {
    // A regra é: para saber se um método de um objeto pode ser chamado, olhamos
    // para o tipo da referência em tempo de compilação, ou seja, somente podemos
    // acessar os métodos de acordo com o tipo da referência. Para realmente chamar
    // o método em tempo de execução, devemos olhar para o objeto ao que demos new;
    v.liga();
    // v.desliga(); // não compila: desliga() is undefined for the type Veiculo.
    // Um ponto muito importante é que o compilador nunca sabe o valor das variáveis
    // depois da linha que as cria, ou seja, o compilador não sabe se estamos
    // passando um Helicoptero ou uma HexaDroid. O que ele sabe é apenas o tipo da
    // variável; no caso, Veiculo. E como Veiculo não tem o método desliga, o código
    // não pode compilar.
  }

  public static void main(String[] args) {
    Helicoptero h1 = new Helicoptero();
    Veiculo h2 = h1;
    // binding do método feito em tempo de execução:
    h1.liga(); // método da classe Helicoptero
    h2.liga(); // método da classe Helicoptero

    metodo(new HexaDroid());
    metodo(new Veiculo());
  }
}

interface X {
  // todo método de interface, por padrão, é public abstract; isso significa que,
  // ao implementar este método em uma classe, ele DEVE SER public:
  void x();
}

class Veiculo implements X {
  public void liga() {
    System.out.println("O veículo foi ligado!");
  }

  @Override
  // void x() { // não compila
  public void x() {
    System.out.println("método da interface x implementado em Veiculo");
  }
}

class Helicoptero extends Veiculo {
  // Overload (sobrecarga) é quando tenho dois métodos com o mesmo nome e valores
  // diferentes, com parâmetros diferentes. Overwrite (sobrescrita) é quando tenho
  // o mesmo nome, mesmos tipos e quantidade de parâmetros em classes distintas em
  // que uma herda da outra; para reescrever o método existem algumas regras: tem
  // que ter exatamente o mesmo nome, a mesma quantidade, ordem e tipo de
  // parâmetros, a visibilidade do método filho tem que ser pelo menos igual à do
  // pai ou mais aberta, as exceptions checked lançadas têm que ser iguais às da
  // mãe ou menos (você não pode de repente definir que vai lançar mais
  // exceptions) e o método da mãe não pode ser final.
  // private void liga() { // não compila
  // public void liga() throws IOException { // não compila
  public void liga() {
    System.out.println("O helicóptero foi ligado!");
  }

  public void desliga() {
    System.out.println("Helicóptero desligado");
  }
}

abstract class Droid extends Veiculo {
  // métodos definidos na classe mãe podem ser reescritos como abstract em classes
  // filhas (no caso, aclasse também deve ser abstrata)
  public abstract void liga();
}

class HexaDroid extends Droid {
  @Override
  public void liga() {
    System.err.println("HexaDroid foi ativado!");
  }

  public void desliga() {
    System.out.println("HexaDroid desligado");
  }
}
