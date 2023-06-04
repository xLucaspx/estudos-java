package curso;

import java.util.ArrayList;

public class TestaArrayList {
  public static void main(String... args) {
    ArrayList<String> nomes = new ArrayList<>();
    nomes.add("Java");
    nomes.add("Node");
    nomes.add("Ruby");
    nomes.add("Python");
    // add com index desloca os outros elementos para a frente
    nomes.add(1, "Python");

    System.out.println(nomes.contains("Java")); // true
    System.out.println(nomes.contains("C++")); // false

    System.out.println(nomes.remove(1)); // retorna "Phyton", que foi removido no índice 1
    System.out.println(nomes.remove("Python")); // true, pois haviam 2 ocorrências de "Python"
    System.out.println(nomes.remove("Python")); // false, não haviam mais ocorrências
    // remover itens também faz com que os elementos da lista se desloquem para
    // preencher espaços vazios:
    System.out.println(nomes.get(1)); // Node agora ocupa o índice 1
    System.out.println(nomes.size()); // 3: imprime quantos elementos tem na lista

    // forma default de toArray() devolve array de Object:
    // Object[] arrNomes = nomes.toArray();

    // se quisermos um array mais específico, podemos fazer algo como:
    // String[] arrNomes = nomes.toArray(new String[nomes.size()]);

    // ou de forma mais simples: o toArray() verifica o tamanho do array passado
    // como parâmetro e, se não for o suficiente, ele mesmo cria um array do tipo
    // passado e com o tamanho certo para colocar todos os elementos
    String[] arrNomes = nomes.toArray(new String[0]);
    for (String nome : arrNomes) {
      System.out.println(nome);
    }

    ArrayList<String> paises = new ArrayList<>();
    paises.add("Brasil");
    paises.add("Argentina");
    paises.add("Uruguai");

    // Juntando listas:
    ArrayList<String> tudo = new ArrayList<>();
    tudo.addAll(nomes);
    tudo.addAll(paises);

    System.out.println(tudo.size()); // 6

    // Lendo listas:
    for (int i = 0; i < tudo.size(); i++) {
      System.out.println(tudo.get(i));
    }

    // set != add; set recebe um índice e um elemento e SUBSTITUI o elemento da
    // lista naquele índice pelo elemento passado como parâmetro:
    nomes.set(2, "C");

    // descobrir índice de elemento:
    System.out.println(nomes.indexOf("C")); // 2
    System.out.println(nomes.lastIndexOf("Ruby")); // -1 pq não encontrou
  }
}
