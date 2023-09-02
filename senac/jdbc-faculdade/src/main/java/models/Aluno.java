package models;

import java.util.Objects;

import models.dto.DadosPessoais;

public class Aluno {
  private String nome;
  private String email;
  private int matricula;

  public Aluno(DadosPessoais dados, int matricula) {
    this.nome = dados.nome();
    this.email = dados.email();
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public int getMatricula() {
    return matricula;
  }

  @Override
  public int hashCode() {
    return Objects.hash(matricula);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || o.getClass() != getClass())
      return false;

    Aluno a = (Aluno) o;
    return matricula == a.getMatricula();
  }

  @Override
  public String toString() {
    return String.format("Aluno: { nome: %s, matricula: %010d, e-mail: %s }", nome, matricula, email);
  }
}
