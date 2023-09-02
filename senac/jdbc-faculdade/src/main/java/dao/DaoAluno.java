package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import models.Aluno;
import models.dto.DadosPessoais;

public class DaoAluno {
	private Connection con;

	public DaoAluno(Connection con) {
		this.con = con;
	}

	public Set<Aluno> buscaAlunos() {
		String sql = "SELECT matricula, nome, email FROM aluno;";
		Set<Aluno> alunos;

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			alunos = transformaResultSetEmAlunos(statement);
			return Collections.unmodifiableSet(alunos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Aluno buscaPorMatricula(int matricula) {
		String sql = "SELECT matricula, nome, email FROM aluno WHERE matricula = ? LIMIT 1;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, matricula);

			Set<Aluno> alunos = transformaResultSetEmAlunos(statement);

			if (alunos.size() == 0)
				throw new RuntimeException("Não há aluno cadastrado para a matrícula " + matricula);

			return alunos.toArray(new Aluno[1])[0];
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void criaAluno(Aluno a) {
		String sql = "INSERT INTO aluno (matricula, nome, email) VALUES (?, ?, ?);";

		try (PreparedStatement statement = this.con.prepareStatement(sql)) {
			statement.setInt(1, a.getMatricula());
			statement.setString(2, a.getNome());
			statement.setString(3, a.getEmail());

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editaAluno(int matricula, DadosPessoais dados) {
		String sql = "UPDATE aluno SET nome = ?, email = ? WHERE matricula = ?;";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, dados.nome());
			statement.setString(2, dados.email());
			statement.setInt(3, matricula);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletaAluno(int matricula) {
		String sql = "DELETE FROM aluno WHERE matricula = ?";

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, matricula);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Set<Aluno> transformaResultSetEmAlunos(PreparedStatement ps) throws SQLException {
		Set<Aluno> alunos = new HashSet<>();

		try (ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int matricula = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);

				Aluno a = new Aluno(new DadosPessoais(nome, email), matricula);
				alunos.add(a);
			}
			return alunos;
		} catch (Exception e) {
			throw e;
		}
	}
}
