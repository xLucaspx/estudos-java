package models;

public class Curso {
  private String nome;
  private int alunos;

  public Curso(String nome, int alunos) {
    this.nome = nome;
    this.alunos = alunos;
  }

  public String getNome() {
    return nome;
  }

  public int getAlunos() {
    return alunos;
  }

  @Override
  public String toString() {
    return "Curso: " + this.nome + ", " + this.alunos + " alunos";
  }
}
