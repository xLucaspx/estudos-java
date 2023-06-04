package models;

/**
 * Classe que representa um "molde" para as contas do Bytebank.
 * 
 * @author L. paz
 * @version 0.1
 */
public abstract class Conta implements Comparable<Conta> {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int totalDeContas;

	/**
	 * Construtor para inicializar uma Conta a partir dos numeros da agencia e da
	 * conta específica.
	 * 
	 * @param agencia
	 * @param numero
	 */
	public Conta(int agencia, int numero) {
		totalDeContas++;
		System.out.println("Conta nº " + getNumeroDeContas() + ":");
		setAgencia(agencia);
		setNumero(numero);
		System.out.println("-*-*-*-*-*-");
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		if (agencia <= 0) {
			System.out.println("Numero de agência inválido");
			return;
		}
		this.agencia = agencia;
		System.out.println("Agência definida para " + agencia);
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Número de conta inválido");
			return;
		}
		this.numero = numero;
		System.out.println("Número da conta definido para " + numero);
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public static int getNumeroDeContas() {
		return Conta.totalDeContas;
	}

	public void deposita(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException(
					"Valor de depósito R$ " + valor + " inválido; o valor deve ser maior que zero");
		}

		this.saldo += valor;
	}

	/**
	 * Valor precisa ser maior que 0 e maior que o saldo; leve em conta as taxas.
	 * 
	 * @param valor
	 * @throws SemSaldoException
	 */
	public void saca(double valor) throws SemSaldoException {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor de saque R$ " + valor + " inválido; o valor deve ser maior que zero!");
		} else if (valor > this.saldo) {
			throw new SemSaldoException("Saldo insuficiente para realizar esta operação");
		}
		this.saldo -= valor;
	}

	public void transfere(Conta destino, double valor) throws SemSaldoException {
		this.saca(valor); // as verificações já são feitas em saca e deposita e, caso algo falhe, as
											// operações não serão executadas
		destino.deposita(valor);
	}

	@Override
	public boolean equals(Object ref) {
		Conta outraConta = (Conta) ref;
		if (this.agencia != outraConta.agencia) {
			return false;
		}
		if (this.numero != outraConta.numero) {
			return false;
		}
		if (this.getClass() != outraConta.getClass()) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Número: " + this.getNumero() + " Agência: " + this.getAgencia();
	}

	@Override
	public int compareTo(Conta c) {
		return Double.compare(this.saldo, c.getSaldo());
	}

	// métodos substituidos após curso de exceptions:
	//
	// public void deposita(double valor) {
	// if (valor > 0) {
	// this.saldo += valor;
	// }
	// }
	//
	// public boolean saca(double valor) {
	// if (valor > 0 && this.saldo >= valor) {
	// this.saldo -= valor;
	// return true;
	// }
	// return false;
	// }
	//
	// public boolean transfere(Conta destino, double valor) {
	// if (this.saca(valor)) { // metodo saca faz as verificações e retorna true or false
	// destino.deposita(valor);
	// return true;
	// }
	// return false;
	// }
}
