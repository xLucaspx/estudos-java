package models;

import java.math.BigDecimal;
import java.util.Objects;

import models.dto.DadosPessoais;

public class Professor {
  private int id;
  private String nome;
  private String email;
  private BigDecimal salario;

  public Professor(DadosPessoais dados, int id, BigDecimal salario) {
    this.nome = dados.nome();
    this.email = dados.email();
    this.id = id;
    this.salario = salario;
  }

  public Professor(DadosPessoais dados, BigDecimal salario) {
    this.nome = dados.nome();
    this.email = dados.email();
    this.salario = salario;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public int getId() {
    return id;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || o.getClass() != getClass())
      return false;

    Professor p = (Professor) o;
    return id == p.getId();
  }

  @Override
  public String toString() {
    return String.format("Professor: { id: %04d, nome: %s, e-mail: %s, salario: R$ %.2f }", id, nome, email, salario);
  }
}
