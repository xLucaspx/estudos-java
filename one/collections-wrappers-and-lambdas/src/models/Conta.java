package models;

// Todas as classes estendem Object, mesmo que não explicitamente
// public class Conta extends Object { // também funciona, mas é raro de se ver
public class Conta implements Comparable<Conta> {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int totalDeContas;

	public Conta(int agencia, int numero) {
		totalDeContas++;
		setAgencia(agencia);
		setNumero(numero);
	}

	public Conta(int agencia, int numero, Cliente titular) {
		totalDeContas++;
		setAgencia(agencia);
		setNumero(numero);
		setTitular(titular);
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

	public boolean saca(double valor) {
		if (valor > 0 && this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public boolean transfere(Conta destino, double valor) {
		if (this.saca(valor)) { // metodo saca faz as verificações e retorna true or false
			destino.deposita(valor);
			return true;
		}
		return false;
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

	// sobrescrevendo método da classe object para retornar informações mais precisas
	@Override
	public String toString() {
		return "Número: " + this.getNumero() + " Agência: " + this.getAgencia();
	}

	@Override
	public int compareTo(Conta c) {
		return Double.compare(this.saldo, c.getSaldo());
	}
}
