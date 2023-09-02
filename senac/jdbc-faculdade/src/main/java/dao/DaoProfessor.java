package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import models.Professor;
import models.dto.DadosPessoais;

public class DaoProfessor {
  private Connection con;

  public DaoProfessor(Connection con) {
    this.con = con;
  }

  public Set<Professor> buscaProfessores() {
    String sql = "SELECT id, nome, email, salario FROM professor;";
    Set<Professor> professores;

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      professores = transformaResultSetEmProfs(statement);
      return Collections.unmodifiableSet(professores);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Professor buscaPorId(int id) {
    String sql = "SELECT id, nome, email, salario FROM Professor WHERE id = ? LIMIT 1;";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setInt(1, id);

      Set<Professor> professores = transformaResultSetEmProfs(statement);

      if (professores.size() == 0)
        throw new RuntimeException("Não há Professor cadastrado para o ID " + id);

      return professores.toArray(new Professor[1])[0];
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void criaProfessor(Professor p) {
    String sql = "INSERT INTO Professor (nome, email, salario) VALUES (?, ?, ?);";

    try (PreparedStatement statement = this.con.prepareStatement(sql)) {
      statement.setString(1, p.getNome());
      statement.setString(2, p.getEmail());
      statement.setBigDecimal(3, p.getSalario());

      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void editaProfessor(int id, DadosPessoais dados, BigDecimal salario) {
    String sql = "UPDATE Professor SET nome = ?, email = ?, salario = ? WHERE matricula = ?;";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setString(1, dados.nome());
      statement.setString(2, dados.email());
      statement.setBigDecimal(3, salario);
      statement.setInt(4, id);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void deletaProfessor(int id) {
    String sql = "DELETE FROM Professor WHERE id = ?";

    try (PreparedStatement statement = con.prepareStatement(sql)) {
      statement.setInt(1, id);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private Set<Professor> transformaResultSetEmProfs(PreparedStatement ps) throws SQLException {
    Set<Professor> professores = new HashSet<>();

    try (ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        int id = rs.getInt(1);
        String nome = rs.getString(2);
        String email = rs.getString(3);
        BigDecimal salario = rs.getBigDecimal(4);

        Professor p = new Professor(new DadosPessoais(nome, email), id, salario);
        professores.add(p);
      }
      return professores;
    } catch (Exception e) {
      throw e;
    }
  }
}
