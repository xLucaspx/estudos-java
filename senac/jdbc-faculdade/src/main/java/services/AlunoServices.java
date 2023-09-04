package services;

import java.sql.Connection;
import java.util.Set;

import dao.DaoAluno;
import factory.ConnectionFactory;
import models.Aluno;
import models.dto.DadosPessoais;

public class AlunoServices {
  private ConnectionFactory connectionFactory;
  private Connection connection;
  private DaoAluno daoAluno;

  public AlunoServices() {
    this.connectionFactory = new ConnectionFactory();
    this.connection = connectionFactory.getConnection();
    this.daoAluno = new DaoAluno(connection);
  }

  public Set<Aluno> listaAlunos() {
    return daoAluno.buscaAlunos();
  }

  public Aluno buscaAlunoPorMatricula(int matricula) {
    return daoAluno.buscaPorMatricula(matricula);
  }

  public void cadastraAluno(DadosPessoais dados, int matricula) {
    Aluno a = new Aluno(dados, matricula);
    daoAluno.criaAluno(a);
  }

  public void editaAluno(DadosPessoais dados, int matricula) {
    Aluno a = buscaAlunoPorMatricula(matricula);
    daoAluno.editaAluno(a.getMatricula(), dados);
  }

  public void deletaAluno(int matricula) {
    Aluno a = buscaAlunoPorMatricula(matricula); // joga erro se o aluno não for encontrado!
    daoAluno.deletaAluno(a.getMatricula());
  }
}
