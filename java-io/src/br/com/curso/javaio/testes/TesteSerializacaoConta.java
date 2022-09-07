package br.com.curso.javaio.testes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.curso.javaio.modelos.Cliente;
import br.com.curso.javaio.modelos.ContaCorrente;

public class TesteSerializacaoConta {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Cliente cliente = new Cliente("Lucas");
		cliente.setCpf("01458796574");
		cliente.setProfissao("Programador");
		
		ContaCorrente cc = new ContaCorrente(2547, 87875, cliente);
		cc.deposita(3500);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cc.bin"));
		oos.writeObject(cc);
		
		oos.close();
	}
}
