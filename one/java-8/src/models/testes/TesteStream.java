package models.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import models.Curso;

public class TesteStream {
  public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<>();

    cursos.add(new Curso("Lógica de programação", 895));
    cursos.add(new Curso("Javascript", 1325));
    cursos.add(new Curso("Expressões regulares", 789));
    cursos.add(new Curso("Orientação a objetos", 1005));

    cursos.sort(Comparator.comparing(Curso::getAlunos));

    System.out.println("Cursos com mais de 1000 alunos:");
    cursos.stream().filter(c -> c.getAlunos() > 1000).forEach(System.out::println);

    System.out.println("Imprimndo número de alunos quando menor que 1000:");
    cursos.stream().filter(c -> c.getAlunos() < 1000).map(Curso::getAlunos).forEach(System.out::println);

    System.out.println("Somando número de alunos:");
    int totalAlunos = cursos.stream().mapToInt(Curso::getAlunos).sum();
    // mapToInt devolve um IntStream (proprio para int), enquanto map devolve um
    // Stream<Integer> e precisa fazer boxing
    System.out.println(totalAlunos);

    System.out.println("Criando um Stream apenas com o nome dos cursos:");
    Stream<String> nomesCursos = cursos.stream().map(Curso::getNome);
    nomesCursos.forEach(nome -> System.out.println(nome));

    System.out.println("Todos os cursos");
    cursos.forEach(curso -> System.out.println(curso)); // stream não altera o objeto original
  }
}
