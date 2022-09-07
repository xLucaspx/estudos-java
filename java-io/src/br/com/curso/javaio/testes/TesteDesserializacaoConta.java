package br.com.curso.javaio.testes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.curso.javaio.modelos.ContaCorrente;

public class TesteDesserializacaoConta {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cc.bin"));
		
		ContaCorrente conta = (ContaCorrente) ois.readObject();
		ois.close();
		
		System.out.println(conta + " Saldo R$ " + conta.getSaldo() + " " + conta.getTitular());
	}
}
