package curso;

public class TestaCasting {
  public static void main(String[] args) {
    Object[] objetos = new Object[15];
    String s = "casting";
    objetos[0] = s;

    // String recuperada = objetos[0]; // não compila
    String recuperada = (String) objetos[0]; // compila

    // O casting é opcional quando é óbvio, quando eu estou indo para um tipo igual
    // ou mais genérico na herança.
    // O casting é obrigatório quando eu estou indo do tipo mais genérico para o
    // mais específico.
    // O casting só compila se é para um tipo mais específico que está na ordem da
    // herança; se não estiver na sua linha de herança, estiver em outro branch, uma
    // outra parte da sua árvore de herança, o casting não vai nem compilar.
    Automovel v = new Carro();
    Carro c = new Carro();
    // Moto m = v; // não compila
    // Moto m = (Moto) c; // não compila nem com casting
    // Moto m = (Moto) v; // compila mas joga ClassCastException em runtime

    CarroAutomatico ca = new CarroAutomatico();
    c = ca; // todo carro automático é um carro
    Automatico a = ca; // todo carro automatico é um automático
    // a = c; // não compila pelo TIPO da referência: nem todo carro é automático
    a = (Automatico) c; // compila e roda pois c está referenciando um carro automático

    Moto m = new Moto();
    // a = m; // não compila pois moto não implementa automático
    // a = (Automatico) m; // compila mas joga ClassCastException em runtime
    /*
     * com herança eu não posso fazer o casting para uma classe que está do outro
     * lado da minha árvore; agora, na interface, mesmo que o tipo da referência não
     * implemente a interface, eu posso fazer o casting para toda a interface.
     * isso acontece porque pode ser que daqui um ano, em outro arquivo JAR ou em
     * outro lugar que não tem nessa classe aqui, exista uma classe X que estende
     * Moto e que implementa Automatico. Ela não precisa necessariamente estar nesse
     * arquivo, ela pode estar em qualquer outro arquivo, ele pode já ter sido
     * compilada ou ela pode ser compilada daqui há cinco minutos. A questão é que o
     * compilador não tem como saber se existe ou se existirá uma classe que herda
     * da classe Moto, isso é, ela pode ser uma moto e implementar aquela interface.
     * Nesse caso, eu não eu tenho como saber, assim como o compilador não tem como
     * saber, então ele tem que assumir que é possível. Em tempo de execução pode
     * dar um exception.
     * Só que tem um caso em que isso não pode acontecer: se a sua classe final não
     * implementou a interface; se ela não implementou a interface até agora, ela
     * nunca mais vai implementar. Nesse caso, o compilador não vai deixar o casting
     * ocorrer
     */

    boolean tipoAutomatico = c instanceof Automatico;
    if (tipoAutomatico) {
      System.out.println("é automático");
    } else {
      System.out.println("não é automático");
    }

    // silenciando warnings:
    System.out.println(recuperada);
    System.out.println(a);
    System.out.println(v);
    System.out.println(m);
  }
}

interface Automatico {
}

class Automovel {
}

class Carro extends Automovel {
}

class Moto extends Automovel {
}

class CarroAutomatico extends Carro implements Automatico {
}

class MotoAutomatica extends Moto implements Automatico {
}
