package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<>();
	// private Set<Aluno> alunos = new HashSet<>();
	// private Set<Aluno> alunos = new LinkedHashSet<>(); // guarda a ordem de inserção, mas não é possível acessar elementos pelo índice
	private Set<Aluno> alunos = new TreeSet<>(); // precisa implementar comparable pois guarda os elementos pela ordem natural
	private int quantidadeDeAulas;
	private int quantidadeDeAlunos;
	private int tempoTotal;
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public int getQuantidadeDeAulas() {
		return quantidadeDeAulas;
	}

	public int getQuantidadeDeAlunos() {
		return quantidadeDeAlunos;
	}

	public int getTempoTotal() {
		// return aulas.stream().mapToInt(Aula::getTempo).sum(); // caso tempoTotal não
		// fosse um atributo de curso
		return tempoTotal;
	}

	public void adiciona(Aula aula) {
		aulas.add(aula);
		quantidadeDeAulas++;
		tempoTotal += aula.getTempo();
	}

	public void matricula(Aluno aluno) {
		if (matriculaParaAluno.containsKey(aluno.getNumeroMatricula())) {
			throw new IllegalArgumentException("Este número já está cadastrado no sistema");
		}
		alunos.add(aluno);
		matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
		quantidadeDeAlunos++;
	}

	public boolean estaMatriculado(Aluno aluno) {
		return alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(int numero) {
		// for (Aluno aluno : this.alunos) {
		// if (aluno.getNumeroMatricula() == numero) {
		// return aluno;
		// }
		// }
		//// return null; // não é boa prática retornar null
		// throw new NoSuchElementException("Matricula " + numero + " não encontrada");

		// forma otimizada de busca usando Map:
		if (!matriculaParaAluno.containsKey(numero)) {
			throw new NoSuchElementException("Matricula " + numero + " não encontrada");
		}
		return matriculaParaAluno.get(numero);
	}

	@Override
	public String toString() {
		return "Curso " + nome + ", instrutor " + instrutor + ", " + quantidadeDeAulas + " aulas, " + quantidadeDeAlunos
				+ " alunos, tempo total: " + tempoTotal + " minutos";
	}
}
