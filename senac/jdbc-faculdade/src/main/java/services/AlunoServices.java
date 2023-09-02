// package services;

// import java.math.BigDecimal;
// import java.sql.Connection;
// import java.util.Set;

// import dao.DaoAluno;
// import factory.ConnectionFactory;

// public class AlunoServices {
// 	private ConnectionFactory connectionFactory;
// 	private Connection connection;
// 	private DaoAluno daoAluno;

// 	public AlunoServices() {
// 		this.connectionFactory = new ConnectionFactory();
// 		this.connection = connectionFactory.getConnection();
// 		this.daoAluno = new DaoAluno(connection);
// 	}

// 	public Set<Aluno> listaContas() {
// 		return daoConta.buscaContasAtivas();
// 	}

// 	public void abreConta(DtoConta dados) {
// 		Cliente titular = new Cliente(dados.dadosCliente());
// 		Conta conta = new Conta(dados.numero(), titular);

// 		daoConta.criaConta(conta);
// 	}

// 	public void desativaConta(int numero) {
// 		Conta c = buscaContaPorNumero(numero);

// 		if (c.possuiSaldo())
// 			throw new RegraDeNegocioException("Não foi possível desativar a conta pois a mesma possui saldo!");

// 		daoConta.desativaConta(numero);
// 	}

// 	public void reativaConta(int numero) {
// 		Conta c = buscaContaPorNumero(numero);

// 		if (c.estaAtiva())
// 			throw new RegraDeNegocioException("A conta " + numero + " já está ativa!");

// 		daoConta.ativaConta(numero);
// 	}

// 	public BigDecimal consultaSaldo(int numeroDaConta) {
// 		Conta conta = buscaContaPorNumero(numeroDaConta);

// 		if (!conta.estaAtiva())
// 			throw new RegraDeNegocioException("A conta " + numeroDaConta + " não está ativa!");

// 		return conta.getSaldo();
// 	}

// 	public void realizaSaque(int numeroDaConta, BigDecimal valor) {
// 		Conta c = buscaContaPorNumero(numeroDaConta);

// 		if (!c.estaAtiva())
// 			throw new RegraDeNegocioException("A conta " + numeroDaConta + " não está ativa!");

// 		if (valor.compareTo(BigDecimal.ZERO) <= 0)
// 			throw new RegraDeNegocioException("O valor do saque deve ser superior zero!");
// 		if (valor.compareTo(c.getSaldo()) > 0)
// 			throw new RegraDeNegocioException("Saldo insuficiente para realizar a operação!");

// 		c.sacar(valor);

// 		daoConta.alteraSaldoConta(c.getNumero(), c.getSaldo());
// 	}

// 	public void realizaDeposito(int numeroDaConta, BigDecimal valor) {
// 		Conta c = buscaContaPorNumero(numeroDaConta);

// 		if (!c.estaAtiva())
// 			throw new RegraDeNegocioException("A conta " + numeroDaConta + " não está ativa!");

// 		if (valor.compareTo(BigDecimal.ZERO) <= 0)
// 			throw new RegraDeNegocioException("O valor do depósito deve ser superior zero!");

// 		c.depositar(valor);

// 		daoConta.alteraSaldoConta(c.getNumero(), c.getSaldo());
// 	}

// 	public void realizaTransferencia(int numeroContaOrigem, int numeroContaDestino, BigDecimal valor) {
// 		Conta origem = buscaContaPorNumero(numeroContaOrigem);
// 		Conta destino = buscaContaPorNumero(numeroContaDestino);

// 		if (!origem.estaAtiva())
// 			throw new RegraDeNegocioException("A conta " + numeroContaOrigem + " não está ativa!");

// 		if (!destino.estaAtiva())
// 			throw new RegraDeNegocioException("A conta " + numeroContaDestino + " não está ativa!");

// 		if (origem.equals(destino))
// 			throw new RegraDeNegocioException("A conta de origem não pode ser a mesma de destino!");

// 		realizaSaque(numeroContaOrigem, valor);
// 		realizaDeposito(numeroContaDestino, valor);
// 	}

// 	private Conta buscaContaPorNumero(int numero) {
// 		return daoConta.buscaPorNumero(numero);
// 	}
// }
