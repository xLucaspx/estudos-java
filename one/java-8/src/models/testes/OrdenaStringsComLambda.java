package models.testes;

import java.util.ArrayList;
import java.util.List;

public class OrdenaStringsComLambda {
  public static void main(String[] args) {
    List<String> palavras = new ArrayList<>();

    palavras.add("Beterraba");
    palavras.add("Rúcula");
    palavras.add("Tomate");
    palavras.add("Rabanete");

    // comparator usando classe anônima:
    // Comparator<String> comparador = new Comparator<String>() {
    // @Override
    // public int compare(String s1, String s2) {
    // return s1.length() - s2.length();
    // }
    // };

    // comparator usando lambda:
    palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

    // forEach mais verboso:
    // palavras.forEach((String s) -> {
    // System.out.println(s);
    // });

    // forEach mais enxuto:
    palavras.forEach(palavra -> System.out.println(palavra));

    // usando uma interface funcional:
    // Consumer<String> impressor = s -> System.out.println(s);
    // palavras.forEach(impressor);
  }
}
