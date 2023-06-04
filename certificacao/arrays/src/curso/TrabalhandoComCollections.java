package curso;

import java.util.ArrayList;
import java.util.Iterator;

public class TrabalhandoComCollections {
  public static void main(String... args) {
    ArrayList<String> nomes = new ArrayList<>();
    nomes.add("Java");
    nomes.add("Node");
    nomes.add("SQL");
    nomes.add("C");

    // percorrendo lista com enhanced for
    for (String nome : nomes) {
      if (nome.equals("C")) {
        nome = "C++"; // altera apenas a variável nome, não o conteúdo da lista
      } else if (nome.equals("Node")) {
        nome = "JavaScript";
      }
      System.out.println(nome);
    }

    // A interface Iterator define uma maneira de percorrer coleções. Isso é
    // necessário porque, em coleções diferentes de List, não possuímos métodos para
    // pegar o enésimo elemento; percorrendo lista com iterator:
    Iterator<String> iterator = nomes.iterator();
    while (iterator.hasNext()) {
      String current = iterator.next();
      System.out.println(current);
      // iterator.remove(); // remove o elemento atual (chamado pelo next())
    }
    /*
     * Um detalhe importante quando se está trabalhando com coleções é que alguns
     * dos métodos das coleções dependem de métodos no seu objeto estarem ou não
     * implementados. Por exemplo: o contains do meu ArrayList, para verificar se o
     * elemento está ou não contido ali dentro, fará uma comparação com todos os
     * elementos utilizando o método equals(), que você precisa sobrescrever para
     * verificar se dois objetos são iguais ou não. Então se você não sobrescrever o
     * equals, o que pode acontecer é que o contains não vai funcionar direito
     * dentro do ArrayList.
     * 
     * A mesma coisa ocorre com o index of; como ele vai saber se o elemento está
     * ali e qual a posição dele? Também do método equals(). Toda vez que usamos
     * ArrayList sempre é bom verificar se o equals() foi sobrescrito ou não. Se ele
     * foi sobrescrito e está bem implementado todos os métodos da ArrayList vão
     * funcionar normalmente.
     * 
     * Se o equals() não foi sobrescrito ou foi implementado de maneira errada,
     * sobrecarregado por exemplo, isso vai fazer com que os métodos da ArrayList, e
     * os métodos de quase todas as coleções, se comportem de maneira estranha, que
     * não pode ser prevista. Então sempre que for usar coleções fique de olho se o
     * equals() está implementado para garantir o funcionamento correto dos métodos.
     */

    // alterar um objeto faz com que ele seja alterado também em todos os lugares
    // onde é referenciado:
    Carro c1 = new Carro();
    c1.modelo = "Escort";

    ArrayList<Carro> carros = new ArrayList<>();
    carros.add(c1);

    System.out.println(c1.modelo); // Escort
    System.out.println(carros.get(0).modelo); // Escort

    c1.modelo = "Del Rey";

    System.out.println(c1.modelo); // Del Rey
    System.out.println(carros.get(0).modelo); // Del Rey
  }
}

class Carro {
  String modelo;
}
