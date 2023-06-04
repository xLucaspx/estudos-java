package models;

public class Aluno implements Comparable<Aluno> {
	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatricula) {
		if (nome == null) {
			throw new NullPointerException("O nome não pode ser null");
		}

		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return this.nome;
	}

	public int getNumeroMatricula() {
		return this.numeroMatricula;
	}

	@Override
	public String toString() {
		return "Aluno: " + this.nome + ", matrícula: " + this.numeroMatricula;
	}

	@Override
	public boolean equals(Object obj) {
		Aluno outro = (Aluno) obj;
		return this.nome.equals(outro.getNome());
	}

	@Override
	public int hashCode() {
		// return this.nome.charAt(0); forma ingênua de reescrever o metodo hashcode
		return this.nome.hashCode(); // forma já implementada na clase String
	}

	@Override
	public int compareTo(Aluno outro) {
		// return this.nome.compareTo(outro.getNome());
		return Integer.compare(this.numeroMatricula, outro.getNumeroMatricula());
	}
}
