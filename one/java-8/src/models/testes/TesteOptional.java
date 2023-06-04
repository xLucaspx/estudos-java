package models.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import models.Curso;

public class TesteOptional {
  public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<>();

    cursos.add(new Curso("Lógica de programação", 895));
    cursos.add(new Curso("Javascript", 1325));
    cursos.add(new Curso("Expressões regulares", 789));
    cursos.add(new Curso("Orientação a objetos", 1005));

    cursos.sort(Comparator.comparing(Curso::getAlunos));

    // Optional ajuda a trabalhar com possóveis valores null
    Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() > 1000).findAny();

    // Curso curso = optionalCurso.get();
    Curso curso = optionalCurso.orElse(null);
    System.out.println(curso.getNome());

    // sem declarar variáveis temporárias:
    cursos.stream().filter(c -> c.getAlunos() < 1000).findFirst().ifPresent(c -> System.out.println(c.getNome()));

    System.out.println("Calculando a média de alunos por curso:");
    OptionalDouble mediaAlunos = cursos.stream().mapToInt(Curso::getAlunos).average();
    System.out.println(mediaAlunos);
  }
}
