package models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
  private DadosPessoais dadosPessoais;
  private LocalDate dataUltimoReajuste;

  public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
    this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
  }

  public void atualizaSalario(BigDecimal novoSalario) {
    this.dadosPessoais.setSalario(novoSalario);
    dataUltimoReajuste = LocalDate.now();
  }

  public void promoveFuncionario(Cargo novoCargo) {
    this.dadosPessoais.setCargo(novoCargo);
  }

  public String getNome() {
    return dadosPessoais.getNome();
  }

  public String getCpf() {
    return dadosPessoais.getCpf();
  }

  public Cargo getCargo() {
    return dadosPessoais.getCargo();
  }

  public BigDecimal getSalario() {
    return dadosPessoais.getSalario();
  }

  public LocalDate getDataUltimoReajuste() {
    return dataUltimoReajuste;
  }
}
