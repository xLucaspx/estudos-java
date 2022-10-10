package br.com.curso.jdbc.main;

import javax.swing.JFrame;

import br.com.curso.jdbc.view.ProdutoCategoriaFrame;

public class App {
	public static void main(String[] args) {
		ProdutoCategoriaFrame produtoCategoriaFrame = new ProdutoCategoriaFrame();
		produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
