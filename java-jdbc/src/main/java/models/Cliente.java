package models;

import java.util.Objects;

import models.dto.DtoCliente;

public class Cliente {
  private String nome;
  private String cpf;
  private String email;

  public Cliente(DtoCliente dados) {
    this.nome = dados.nome();
    this.cpf = dados.cpf();
    this.email = dados.email();
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpf);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || o.getClass() != getClass()) return false;

    Cliente c = (Cliente) o;
    return cpf.equals(c.getCpf());
  }

  @Override
  public String toString() {
    return String.format("Cliente: { nome: %s, cpf: %s, e-mail: %s }", nome, cpf, email);
  }
}
