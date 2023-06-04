package testes;

import models.Cliente;
import models.ContaCorrente;
import models.ContaPoupanca;
import models.Conta;

public class TesteArrayDeReferencia {
	public static void main(String[] args) {
		System.out.println("Array do tipo ContaCorrente:");

		ContaCorrente[] contasC = new ContaCorrente[3];

		ContaCorrente cc1 = new ContaCorrente(2547, 22558);
		ContaCorrente cc2 = new ContaCorrente(6547, 11445);

		contasC[0] = cc1;
		contasC[1] = cc2;

		System.out.println("Conta 1: " + contasC[0]);
		System.out.println("Conta 2: " + contasC[1]);
		System.out.println("Conta 3: " + contasC[2]); // null

		// System.out.println(contasC[2].getNumero());
		// NullPointerException; não definimos contas na posição 2, então não podemos
		// chamar o metodo

		// System.out.println(contasC[3].getNumero());
		// ArrayIndexOutOfBoundsException; nosso array só vai até a posição 2

		ContaCorrente ref1 = contasC[1]; // ref1 e cc2 são referências para o mesmo objeto, assim como contasC[1]
		System.out.println("Conta ref1: " + ref1);

		System.out.println("/---/---/---/---/---/---/---/---/---/---/---/---/---/");
		System.out.println("Array do tipo Conta:");

		Conta[] contas = new Conta[5]; // mais genérico: pode receber Conta, CC ou CP

		ContaPoupanca cp1 = new ContaPoupanca(2548, 13125);

		contas[0] = cc1;
		contas[1] = cc2;
		contas[2] = cp1;

		System.out.println("Conta 1: " + contas[0]);
		System.out.println("Conta 2: " + contas[1]);
		System.out.println("Conta 3: " + contas[2]);

		// ContaCorrente ref2 = contas[0]; // assim não compila pois o tipo do array é
		// Conta; temos que avisar o compilador com type casting:
		ContaCorrente ref2 = (ContaCorrente) contas[0];

		// ContaPoupanca ref3 = (ContaPoupanca) contas[1]; // ClassCastException;
		// tentando fazer type casting de uma CC em uma CP

		System.out.println("Conta ref2: " + ref2);

		System.out.println("/---/---/---/---/---/---/---/---/---/---/---/---/---/");
		System.out.println("Array do tipo Object:");

		Object[] referencias = new Object[5];

		Cliente cl1 = new Cliente("Roberto Carlos");

		referencias[0] = cc1;
		referencias[1] = cc2;
		referencias[2] = cp1;
		referencias[3] = cl1;

		Object referenciaGenerica = referencias[2];
		// System.out.println(referenciaGenerica.getNumero()); // não compila pois
		// Object não possui o metodo getNumero

		ContaPoupanca referenciaEspecifica = (ContaPoupanca) referencias[2];
		// System.out.println(referenciaEspecifica.getNumero()); // funciona pois agora
		// a referencia é para uma CP, que possui o metodo

		System.out.println("Referência genérica  (Obj): " + referenciaGenerica);
		System.out.println("Referência específica (CP): " + referenciaEspecifica);

		System.out.println("Conteúdo do array referências: ");
		for (int i = 0; i < referencias.length; i++) {
			System.out.println(i + ": " + referencias[i]);
		}
	}
}
