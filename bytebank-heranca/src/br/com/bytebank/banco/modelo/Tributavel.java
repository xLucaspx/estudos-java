package br.com.bytebank.banco.modelo;

// interfaces não precisam ser declaradas como abstract; já é implícito.
public interface Tributavel {

// não precisa de public e abstract pois já está implícito na interface
	double getValorImposto();
}