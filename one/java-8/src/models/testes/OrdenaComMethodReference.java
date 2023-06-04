package models.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaComMethodReference {
  public static void main(String[] args) {
    List<String> palavras = new ArrayList<>();

    palavras.add("Beterraba");
    palavras.add("Rúcula");
    palavras.add("Tomate");
    palavras.add("Rabanete");

    // comparator usando um método default:
    // palavras.sort(Comparator.comparing(s -> s.length()));

    // equivale ao comparator usando method reference:
    palavras.sort(Comparator.comparing(String::length));

    // e os dois acima equivalem a:
    // Function<String, Integer> funcao = s -> s.length();
    // Comparator<String> comparador = Comparator.comparing(funcao);
    // palavras.sort(comparador);

    // forEach com method reference:
    palavras.forEach(System.out::println);
    // o println recebe objetos e o Java invoca esse método, passando a String da vez
  }
}
