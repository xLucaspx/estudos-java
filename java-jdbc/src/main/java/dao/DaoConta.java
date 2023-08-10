package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Cliente;
import models.Conta;

public class DaoConta {
  private Connection con;

  public DaoConta(Connection con) {
    this.con = con;
  }

  public void salvaConta(Conta c) {
    String sql = "INSERT INTO conta (numero, saldo, nome_titular, cpf_titular, email_titular) VALUES (?, ?, ?, ?, ?);";
    Cliente titular = c.getTitular();

    try (PreparedStatement statement = this.con.prepareStatement(sql)) {

      statement.setInt(1, c.getNumero());
      statement.setBigDecimal(2, c.getSaldo());
      statement.setString(3, titular.getNome());
      statement.setString(4, titular.getCpf());
      statement.setString(5, titular.getEmail());

      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
