package models.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
  public static void main(String[] args) {
    List<String> palavras = new ArrayList<>();

    palavras.add("Beterraba");
    palavras.add("Rúcula");
    palavras.add("Tomate");
    palavras.add("Rabanete");

    Comparator<String> comparador = new ComparadorPorTamanho();
    palavras.sort(comparador);

    Consumer<String> consumidor = new ImprimeNaLinha();
    palavras.forEach(consumidor);
  }
}

class ComparadorPorTamanho implements Comparator<String> {
  @Override
  public int compare(String s1, String s2) {
    return (s1.length() - s2.length());
  }
}

class ImprimeNaLinha implements Consumer<String> {
  @Override
  public void accept(String s) {
    System.out.println(s);
  }
}
