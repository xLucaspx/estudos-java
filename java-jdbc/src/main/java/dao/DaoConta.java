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

	public Set<Conta> buscaContas() {
		String sql = "SELECT numero, saldo, nome_titular, cpf_titular, email_titular FROM conta;";
		Set<Conta> contas;

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			contas = transformaResultSetEmContas(statement);
			return Collections.unmodifiableSet(contas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Conta buscaPorNumero(int numero) {
		String sql = "SELECT numero, saldo, nome_titular, cpf_titular, email_titular FROM conta WHERE numero = ? LIMIT 1;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, numero);

			Set<Conta> contas = transformaResultSetEmContas(statement);
			
			if (contas.size() == 0) throw new RegraDeNegocioException("Não há conta cadastrada para o número informado!\nNúmero informado: " + numero);
			
			return contas.toArray(new Conta[1])[0];	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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

	private Set<Conta> transformaResultSetEmContas(PreparedStatement ps) throws SQLException {
		Set<Conta> contas = new HashSet<>();

		try (ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int numero = rs.getInt(1);
				BigDecimal saldo = rs.getBigDecimal(2);
				String nome = rs.getString(3);
				String cpf = rs.getString(4);
				String email = rs.getString(5);

				Conta c = new Conta(numero, new Cliente(new DtoCliente(nome, cpf, email)));
				c.depositar(saldo);
				contas.add(c);
			}
			return contas;
		}
	}
}
