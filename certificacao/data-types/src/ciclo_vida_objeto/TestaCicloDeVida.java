package ciclo_vida_objeto;

public class TestaCicloDeVida {
  public static void main(String[] args) {
    // INACESSÍVEL: sem referências diretas ou indiretas.
    // GC (Garbage Collector): pode descartar objetos da memória a qualquer momento
    // após se tornarem inacessíveis; isso não quer dizer que ele necessáriamente
    // faça isso. Não é possível saber quando ele vai rodar, apenas quando objetos
    // se tornam elegíveis para serem descartados pelo GC.

    Carro c; // aqui, nenhum carro foi criado, apenas uma variável do tipo carro.

    // para realmente criar um objeto, precisamos chamar seu construtor:
    c = new Carro(); // aqui, apenas UM carro foi criado na memória.
    // LEMBRANDO QUE a variável c é apenas uma REFERÊNCIA ao objeto carro, que está
    // na memória e não podemos pegar, apenas referenciar

    new Carro(); // aqui dois carros foram criados na memória

    Carro[] arrCarros = new Carro[50];
    System.out.println(arrCarros[0]);
    // como não chamamos nenhum construtor, apenas criamos um array do tipo Carro,
    // com 50 espaços. Nenhum objeto é criado. Note que para criar devemos, por
    // padrão, invocar o construtor.

    // quando temos uma variável referenciando um objeto, ele é acessível:
    c.ano = 1979;
    c.modelo = "Opala";

    c = new Carro();
    // agora, no código, apenas um carro está acessível. O primeiro e segundo carro
    // criados não estão sendo referenciados, portanto não podem ser acessados

    c = null; // agora nenhum carro está acessível e c não referencia nada.

    // acessíveis apenas dentro do bloco em que foram criados:
    if (15 > 10) {
      Carro c2 = new Carro();
      c2.ano = 2000;
    }

    Carro c3 = null;
    for (int i = 0; i < 10; i++) {
      c3 = new Carro();
    }
    System.out.println(c3); // só pra silenciar os warnings

    // Q: quantos carros foram criados até este ponto do código? A: 14

    // Q: quantos carros estão acessíveis neste ponto do código?
    // A: Apenas 1, pois a variável c3 foi declarada fora do bloco e referencia o
    // último carro criado no for;

    // Q: quantos objetos do tipo Carro podem ser "garbage coletados" neste ponto do
    // código? A: 13

    // Q: quantos objetos do tipo Carro foram "garbage coletados" neste ponto do
    // código? A: Não é possível definir

    Carros carros = new Carros();
    c = new Carro("Opala", 1979);
    carros.c1 = c;
    c = null;

    if (10 > 1) {
      Carro c2 = new Carro("Escort", 1993);
      carros.c2 = c2;
    }
    // agora carros.c1 aponta para a mesma referência de c e carros.c2 aponta para a
    // mesma referência de c2; mesmo que tenhamos alterado o valo de c e c2 só
    // estaja acessível dentro do bloco if, as referências para os objetos Carro
    // ainda são acessíveis pela classe Carros; portanto, devemos prestar atenção às
    // referências indiretas: os objetos ainda não podem ser garbage coletados pois
    // podem estar sendo usados.

    // Q: quantos carros estão acessíveis neste ponto do código?
    // A: 3: c3, Carros.c1 e Carros.c2
  }
}

class Carro {
  String modelo;
  int ano;

  Carro() {
    modelo = "Polo";
    ano = 2019;
  }

  Carro(String modelo, int ano) {
    this.modelo = modelo;
    this.ano = ano;
  }
}

class Carros {
  Carro c1, c2;
}
