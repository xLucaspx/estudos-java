package models.testes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Curso;

public class TesteCollect {

  public static void main(String[] args) {
    List<Curso> cursos = new ArrayList<>();

    cursos.add(new Curso("Lógica de programação", 895));
    cursos.add(new Curso("Javascript", 1325));
    cursos.add(new Curso("Expressões regulares", 789));
    cursos.add(new Curso("Orientação a objetos", 1005));

    System.out.println("Cursos cheios:");
    List<Curso> cursosCheios = cursos.stream().filter(c -> c.getAlunos() > 1000).collect(Collectors.toList());
    System.out.println(cursosCheios);

    System.out.println("Cursos disponíveis:");
    List<Curso> cursosDisponiveis = cursos.stream().filter(c -> c.getAlunos() < 1000).collect(Collectors.toList());
    System.out.println(cursosDisponiveis);

    System.out.println("Map de cursos:");
    cursos.stream()
        .collect(Collectors.toMap(
            c -> c.getNome(),
            c -> c.getAlunos()))
        .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
  }
}
