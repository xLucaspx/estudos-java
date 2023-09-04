package services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Set;

import dao.DaoProfessor;
import factory.ConnectionFactory;
import models.Professor;
import models.dto.DadosPessoais;

public class ProfessorServices {
  private ConnectionFactory connectionFactory;
  private Connection connection;
  private DaoProfessor daoProfessor;

  public ProfessorServices() {
    this.connectionFactory = new ConnectionFactory();
    this.connection = connectionFactory.getConnection();
    this.daoProfessor = new DaoProfessor(connection);
  }

  public Set<Professor> listaProfessores() {
    return daoProfessor.buscaProfessores();
  }

  public Professor buscaProfessorPorId(int id) {
    return daoProfessor.buscaPorId(id);
  }

  public void cadastraProfessor(DadosPessoais dados, BigDecimal salario) {
    Professor p = new Professor(dados, salario);
    daoProfessor.criaProfessor(p);
  }

  public void editaProfessor(DadosPessoais dados, int id, BigDecimal salario) {
    Professor p = buscaProfessorPorId(id); // joga erro se o professor não for encontrado!
    daoProfessor.editaProfessor(p.getId(), dados, salario);
  }

  public void deletaProfessor(int id) {
    Professor p = buscaProfessorPorId(id);
    daoProfessor.deletaProfessor(p.getId());
  }
}
