package testes;

import models.Cliente;
import models.ContaCorrente;

public class TesteContasComException {
	public static void main(String[] args) {
		ContaCorrente conta1 = new ContaCorrente(1023, 77889, new Cliente("Felipe"));
		ContaCorrente conta2 = new ContaCorrente(1024, 78945, new Cliente("Bruna"));

		// conta1.deposita(-850);
		conta1.deposita(850);

		try {
			// conta1.saca(900);
			// conta1.transfere(conta2, 0);

			conta1.transfere(conta2, 150);
			conta1.saca(200);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			System.out.println("Saldo " + conta1.getTitular().getNome() + ": R$ " + conta1.getSaldo());
			System.out.println("Saldo " + conta2.getTitular().getNome() + ": R$ " + conta2.getSaldo());
		}
	}
}
