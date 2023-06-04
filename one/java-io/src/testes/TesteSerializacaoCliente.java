package testes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Cliente;

public class TesteSerializacaoCliente {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Cliente cliente = new Cliente("Lucas");
		cliente.setCpf("01458796574");
		cliente.setProfissao("Programador");

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
		oos.writeObject(cliente);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
		cliente = (Cliente) ois.readObject();

		ois.close();

		System.out.println(cliente);
	}
}
