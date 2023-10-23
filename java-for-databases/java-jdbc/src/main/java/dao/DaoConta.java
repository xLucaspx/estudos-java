package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import exceptions.RegraDeNegocioException;
import models.Cliente;
import models.Conta;
import models.dto.DtoCliente;

public class DaoConta {
	private Connection con;

	public DaoConta(Connection con) {
		this.con = con;
	}

	public Set<Conta> buscaContasAtivas() {
		String sql = "SELECT numero, saldo, nome_titular, cpf_titular, email_titular, ativa FROM conta WHERE ativa = true;";
		Set<Conta> contas;

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			contas = transformaResultSetEmContas(statement);
			return Collections.unmodifiableSet(contas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Conta buscaPorNumero(int numero) {
		String sql = "SELECT numero, saldo, nome_titular, cpf_titular, email_titular, ativa FROM conta WHERE numero = ? LIMIT 1;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, numero);

			Set<Conta> contas = transformaResultSetEmContas(statement);

			if (contas.size() == 0)
				throw new RegraDeNegocioException(
						"Não há conta cadastrada para o número informado!\nNúmero informado: " + numero);

			return contas.toArray(new Conta[1])[0];
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void criaConta(Conta c) {
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

	public void desativaConta(int numero) {
		String sql = "UPDATE conta SET ativa = false WHERE numero = ?";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, numero);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void ativaConta(int numero) {
		String sql = "UPDATE conta SET ativa = true WHERE numero = ?";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, numero);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alteraSaldoConta(int numero, BigDecimal saldo) {
		String sql = "UPDATE conta SET saldo = ? WHERE numero = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setBigDecimal(1, saldo);
			statement.setInt(2, numero);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Set<Conta> transformaResultSetEmContas(PreparedStatement ps) throws SQLException {
		Set<Conta> contas = new HashSet<>();

		try (ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int numero = rs.getInt(1);
				BigDecimal saldo = rs.getBigDecimal(2);
				String nome = rs.getString(3);
				String cpf = rs.getString(4);
				String email = rs.getString(5);
				boolean ativa = rs.getBoolean(6);

				Conta c = new Conta(numero, saldo, new Cliente(new DtoCliente(nome, cpf, email)), ativa);
				contas.add(c);
			}
			return contas;
		} catch (Exception e) {
			throw e;
		}
	}
}
