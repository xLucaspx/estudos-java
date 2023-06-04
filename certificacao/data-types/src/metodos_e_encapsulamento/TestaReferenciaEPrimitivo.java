package metodos_e_encapsulamento;

public class TestaReferenciaEPrimitivo {
  // determine the effect upon object references ad primitive values
  // when they're passed into methods that change the values
  public static void main(String[] args) {
    // quando crio uma variável, o que estou fazendo é criar um espaço de memória
    // que tem uma variável, e essa variável tem um valor. Se o tipo é primitivo,
    // esse é o valor direto que temos para essa variável e ponto final.
    int i = 2;
    // Para entendermos o que acontece exatamente quando invocamos um método, temos
    // que dar uma olhada na pilha de execução: que método invocou qual e onde está
    // agora. Nessa pilha de execução, em cada uma das chamadas de método eu tenho
    // um conjunto de variáveis locais que estão visíveis só dentro daquele escopo
    teste(i); // 5
    // imprimiu 5: o método main é executado, então está bem embaixo na pilha; o
    // único método que está sendo executado nesse instante, ele não invocou ninguém
    // ainda. Dentro do método main executamos a linha 10, criando um espaço de
    // memória com o conteúdo da variável i. Como ela é um tipo primitivo, já é o
    // valor dela, 2, lá dentro. Vou para a linha 15, que vai chamar o método teste
    // passando o valor. Quando chamamos um método passando um tipo primitivo, nós
    // estamos passando o valor (2), e não a variável i. Na stack agora temos o
    // método main que chamou logo acima dele o método teste, que tem uma variável
    // local i; então agora dentro do método teste o conjunto de variáveis locais é
    // outro, diferente daquele conjunto de variáveis locais que eu tinha quando
    // estava dentro do método main. Quando ele sai do método, nós tiramos da pilha
    // o último método (teste), e com isso se tem variáveis que não são mais
    // referenciadas, podem ser garbage coletadas. Então essa segunda variável i,
    // que só existia no escopo do método teste, foi embora; voltamos para o método
    // main, assim que termina a linha 15 temos novamente no escopo a variável i,
    // aquela primeira de todas com valor dois, impressa abaixo:
    System.out.println(i); // 2
    // se quisermos modificar o valor da variável, podemos usar um método com
    // retorno de mesmo tipo e atribuir à variável o retorno deste método:
    i = soma3(i);
    System.out.println(i); // i agora vale 5

    // Referências:
    Prova p = new Prova();
    p.tempo = 100;
    teste(p);
    System.out.println(p.tempo); // 520
    // Na memória, na linha 39, crio o espaço com um objeto do tipo Prova, isso é
    // new prova; agora criamos a variável p, então cria um outro espaço de memória
    // que é a variável que está referenciando objeto do tipo Prova. Lembra: o
    // objeto já tinha sido inicializado com valores padrões! Agora falamos p.tempo
    // = 100, então pega o objeto referenciado por p e coloca o valor 100 dentro do
    // espaço de memória da variável tempo. Ao chamar o método teste passando a
    // referência do meu objeto, ele cria outra variável do tipo Prova; empilhamos
    // agora o método teste, e dentro dele temos outro espaço de variáveis locais,
    // os objetos foram instanciados na memória, a variável local está lá, uma nova
    // variável p que não está referenciando nada ainda, mas passamos uma referência
    // de parâmetro, então agora p também está referenciando aquela Prova, o mesmo
    // objeto; ou seja, não foi crado um segundo objeto, apenas uma nova variável
    // referenciando o mesmo objeto de antes. Portanto quando fizermos agora p.tempo
    // e alteramos seu valor, colocamos o número 520 dentro do único objeto do tipo
    // Prova que existia na minha memória; existem duas variáveis do tipo prova
    // referenciando o mesmo objeto, cada uma está em um escopo diferente no meu
    // stack trace, uma está na chamada de método atual, que é o método teste, e a
    // outra está na chamada de método anterior, que é o método main. Ao sair do
    // método teste, aquela referência acabou e tirei da minha pilha. Agora ao
    // imprimir p.tempo, a mesma variável p que tinha antes, imprime 520.

    // Percebeu a diferença? A diferença é que quando eu chamo um método com tipo
    // primitivo, eu estou copiando o valor lá de dentro. Quando chamo um método com
    // uma referência, estou copiando a referência, a seta para o mesmo objeto, não
    // o objeto em si!

    teste2(p);
    System.out.println(p.tempo); // 520
    // o metodo teste2 não altera o valor dentro do Objeto prova pois ele cria um
    // novo objeto e passa a referenciá-lo; quando voltamos ao método main, este
    // objeto criado dentro de teste2 e a variável local podem ser descartados, e a
    // variável p no método main ainda referencia o objeto Prova criado
    // anteriormente; por isso, ao imprimir o valor de p.tempo, ele permanece com o
    // valor inalterado pelo método teste2
  }

  static void teste(int i) {
    i = i + 3;
    System.out.println(i);
  }

  static void teste(Prova p) {
    p.tempo = 520;
  }

  static void teste2(Prova p) {
    p = new Prova();
    p.tempo = 250;
  }

  static int soma3(int i) {
    return i + 3;
  }
}

class Prova {
  int tempo;
}
