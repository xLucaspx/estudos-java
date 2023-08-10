package services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import dao.DaoConta;
import exceptions.RegraDeNegocioException;
import factory.ConnectionFactory;
import models.Cliente;
import models.Conta;
import models.dto.DtoConta;

public class ContaServices {
	private Set<Conta> contas;
	private ConnectionFactory connectionFactory;

	public ContaServices() {
		this.contas = new HashSet<>();
		this.connectionFactory = new ConnectionFactory();
	}

	public Set<Conta> listaContas() {
		try (Connection con = connectionFactory.getConnection()) {
			return new DaoConta(con).buscaContas();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void abreConta(DtoConta dados) {
		Cliente titular = new Cliente(dados.dadosCliente());
		Conta conta = new Conta(dados.numero(), titular);

		try (Connection con = connectionFactory.getConnection()) {
			new DaoConta(con).criaConta(conta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void encerraConta(int numero) {
		Conta c = buscaContaPorNumero(numero);

		if (c.possuiSaldo())
			throw new RegraDeNegocioException("Não foi possível encerrar a conta pois a mesma possui saldo!");

		contas.remove(c);
	}

	public BigDecimal consultaSaldo(int numeroDaConta) {
		Conta conta = buscaContaPorNumero(numeroDaConta);
		return conta.getSaldo();
	}

	public void realizarSaque(int numeroDaConta, BigDecimal valor) {
		Conta c = buscaContaPorNumero(numeroDaConta);

		if (valor.compareTo(BigDecimal.ZERO) <= 0)
			throw new RegraDeNegocioException("O valor do saque deve ser superior zero!");
		if (valor.compareTo(c.getSaldo()) > 0)
			throw new RegraDeNegocioException("Saldo insuficiente para realizar a operação!");

		c.sacar(valor);

		try (Connection con = connectionFactory.getConnection()) {
			new DaoConta(con).alteraSaldoConta(c.getNumero(), c.getSaldo());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void realizarDeposito(int numeroDaConta, BigDecimal valor) {
		Conta c = buscaContaPorNumero(numeroDaConta);

		if (valor.compareTo(BigDecimal.ZERO) <= 0)
			throw new RegraDeNegocioException("O valor do depósito deve ser superior zero!");

		c.depositar(valor);

		try (Connection con = connectionFactory.getConnection()) {
			new DaoConta(con).alteraSaldoConta(c.getNumero(), c.getSaldo());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Conta buscaContaPorNumero(int numero) {
		try (Connection con = connectionFactory.getConnection()) {
			return new DaoConta(con).buscaPorNumero(numero);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
