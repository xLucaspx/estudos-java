package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambdas {
  public static void main(String[] args) {
    List<Pessoa> pessoas = new ArrayList<>();
    pessoas.add(new Pessoa("Lucas", 20));
    pessoas.add(new Pessoa("Guilherme", 16));
    pessoas.add(new Pessoa("Eduardo", 31));
    pessoas.add(new Pessoa("Vitor", 17));

    FiltradorDePessoas f = new FiltradorDePessoas();
    List<Pessoa> resultado = new ArrayList<>();

    // forma mais antiga:
    Predicate<Pessoa> criterio = new MaioresDeIdade();

    resultado = f.filtra(pessoas, criterio);
    System.out.println(resultado);

    // utilizando classes anônimas:
    Predicate<Pessoa> menoresDe18 = new Predicate<Pessoa>() {
      public boolean test(Pessoa p) {
        return p.getIdade() < 18;
      }
    };

    resultado = f.filtra(pessoas, menoresDe18);
    System.out.println(resultado);

    // utilizando lambdas:
    /*
     * para poder transformar um trecho de código em Lambda, é precisa ter o que o
     * pessoal do Java chama de interface funcional, ou seja, uma interface que tem
     * apenas um método.
     * Se você quiser saber se realmente é uma interface funcional, o pessoal do
     * Java criou uma notation (@FunctionalInterface); se a interface realmente for
     * funcional o código vai compilar normalmente.
     */

    // sintaxe de um Lambda: (parâmetros) -> { código }
    // ex.: (String s1, String s2) -> s1.compareTo(s2);

    // Predicate é uma interface funcional já presente no java, que possui um método
    // boolean test, exatamente igual a interface Matcher que criamos
    Predicate<Pessoa> maiorDeIdade = (Pessoa p) -> {
      return p.getIdade() >= 18;
    };

    resultado = f.filtra(pessoas, maiorDeIdade);
    System.out.println(resultado);

    /*
     * é possível reduzir ainda mais a expressão:
     * - se o código consegue descobrir qual o tipo do parâmetro, você não precisa
     * passar;
     * - se método só recebe um parâmetro, não precisa colocar os parênteses;
     * - se o método não recebe parâmetros, é obrigatório colocar os parênteses;
     * - se há apenas uma linha de código, não é preciso colocar chaves para
     * delimitar;
     * - se essa linha for o retorno do método, também não precisa colocar o return.
     */
    Predicate<Pessoa> vinteAnos = p -> p.getIdade() > 19 && p.getIdade() < 30;

    resultado = f.filtra(pessoas, vinteAnos);
    System.out.println(resultado);

    // é possível passar o lambda diretamente no código:
    resultado = f.filtra(pessoas, p -> p.getNome().startsWith("E"));
    System.out.println(resultado);
  }
}

class Pessoa {
  private String nome;
  private int idade;

  Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  @Override
  public String toString() {
    return String.format("%s, %d anos", this.nome, this.idade);
  }
}

// @FunctionalInterface
// interface Matcher<T> {
// boolean test(T t);
// }

class FiltradorDePessoas {
  List<Pessoa> filtra(List<Pessoa> pessoas, Predicate<Pessoa> matcher) {
    List<Pessoa> resultado = new ArrayList<>();

    for (Pessoa p : pessoas) {
      if (matcher.test(p)) {
        resultado.add(p);
      }
    }
    return resultado;
  }
}

class MaioresDeIdade implements Predicate<Pessoa> {
  public boolean test(Pessoa p) {
    return p.getIdade() >= 18;
  }
}
