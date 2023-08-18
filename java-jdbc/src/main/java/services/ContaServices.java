package services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Set;

import dao.DaoConta;
import exceptions.RegraDeNegocioException;
import factory.ConnectionFactory;
import models.Cliente;
import models.Conta;
import models.dto.DtoConta;

public class ContaServices {
	private ConnectionFactory connectionFactory;

	public ContaServices() {
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void encerraConta(int numero) {
		Conta c = buscaContaPorNumero(numero);

		if (c.possuiSaldo())
			throw new RegraDeNegocioException("Não foi possível encerrar a conta pois a mesma possui saldo!");

		try (Connection con = connectionFactory.getConnection()) {
			new DaoConta(con).deletaConta(numero);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		} catch (Exception e) {
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void realizarTransferencia(int numeroContaOrigem, int numeroContaDestino, BigDecimal valor) {
		try {
			Conta origem = buscaContaPorNumero(numeroContaOrigem);
			Conta destino = buscaContaPorNumero(numeroContaDestino);

			if (origem.equals(destino))
				throw new RegraDeNegocioException("A conta de origem não pode ser a mesma de destino!");

			realizarSaque(numeroContaOrigem, valor);
			realizarDeposito(numeroContaDestino, valor);
		} catch (Exception e) {
			throw e;
		}
	}

	private Conta buscaContaPorNumero(int numero) {
		try (Connection con = connectionFactory.getConnection()) {
			return new DaoConta(con).buscaPorNumero(numero);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
