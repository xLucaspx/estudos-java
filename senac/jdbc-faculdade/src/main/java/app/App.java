package app;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

import models.Aluno;
import models.Professor;
import models.dto.DadosPessoais;
import services.AlunoServices;
import services.ProfessorServices;

public class App {
  private static AlunoServices alunoServices = new AlunoServices();
  private static ProfessorServices professorServices = new ProfessorServices();

  public static void main(String... args) {
    Scanner s = new Scanner(System.in);
    int opcao = -1;

    while (opcao != 0) {
      try {
        opcao = exibeMenu(s);
        switch (opcao) {
          case 1 -> {
            listaProfessores();
            break;
          }
          case 2 -> {
            listaAlunos();
            break;
          }
          case 3 -> {
            cadastraProfessor(s);
            break;
          }
          case 4 -> {
            cadastraAluno(s);
            break;
          }
          case 5 -> {
            editaProfessor(s);
            break;
          }
          case 6 -> {
            editaAluno(s);
            break;
          }
          case 7 -> {
            deletaProfessor(s);
            break;
          }
          case 8 -> {
            deletaAluno(s);
            break;
          }
          case 0 -> {
            System.out.println("\nPrograma encerrado!");
            break;
          }
          default -> {
            throw new IllegalArgumentException("O valor digitado não corresponde a nenhuma operação!");
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("\nO valor digitado é inválido! Mensagem de erro:\n" + e.getMessage());
        opcao = -1;
      } catch (Exception e) {
        System.out.println("\nOcorreu um erro ao tentar realizar a operação:\n" + e.getMessage());
        opcao = -1;
      }
    }
    s.close();
  }

  private static int exibeMenu(Scanner s) {
    System.out.print("""
        \nFaculdade JDBC  - Menu Principal
        1 - Listar professores
        2 - Listar alunos
        3 - Cadastrar professor
        4 - Cadastrar aluno
        5 - Editar professor
        6 - Editar aluno
        7 - Excluir professor
        8 - Excluir aluno
        0 - Sair
        """);
    System.out.print("\nDigite o número da operação desejada: ");

    return Integer.parseInt(s.nextLine());
  }

  private static void listaProfessores() {
    System.out.println("\nProfessores cadastrados:");
    Set<Professor> professores = professorServices.listaProfessores();

    if (professores.size() <= 0)
      System.out.println("Não existem professores cadastrados!");
    else
      professores.stream().forEach(System.out::println);
  }

  private static void listaAlunos() {
    System.out.println("\nAlunos cadastrados:");
    Set<Aluno> alunos = alunoServices.listaAlunos();

    if (alunos.size() <= 0)
      System.out.println("Não existem alunos cadastrados!");
    else
      alunos.stream().forEach(System.out::println);
  }

  private static void cadastraProfessor(Scanner s) {
    System.out.println("\nCadastro de professor");
    System.out.print("\nDigite o nome do professor: ");
    String nome = s.nextLine();

    System.out.print("Digite o e-mail do professor: ");
    String email = s.nextLine();

    System.out.print("Digite o salário do professor: R$ ");
    BigDecimal salario = new BigDecimal(s.nextLine());

    professorServices.cadastraProfessor(new DadosPessoais(nome, email), salario);
    System.out.println("\nProfessor cadastrado com sucesso!");
  }

  private static void cadastraAluno(Scanner s) {
    System.out.println("\nCadastro de Aluno");
    System.out.print("\nDigite o nome do aluno: ");
    String nome = s.nextLine();

    System.out.print("Digite o e-mail do aluno: ");
    String email = s.nextLine();

    System.out.print("Digite a matrícula do aluno: ");
    int matricula = Integer.parseInt(s.nextLine());

    alunoServices.cadastraAluno(new DadosPessoais(nome, email), matricula);
    System.out.println("\nAluno cadastrado com sucesso!");
  }

  private static void editaProfessor(Scanner s) {
    System.out.println("\nEdição de professor");
    System.out.print("\nDigite o ID do professor: ");
    int id = Integer.parseInt(s.nextLine());

    Professor professor = professorServices.buscaProfessorPorId(id);

    System.out.println("\nNome: " + professor.getNome());
    System.out.print("Digite o novo nome: ");
    String nome = s.nextLine();

    System.out.println("\nE-mail: " + professor.getEmail());
    System.out.print("Digite o novo e-mail: ");
    String email = s.nextLine();

    System.out.println(String.format("\nSalário R$ %.2f", professor.getSalario()));
    System.out.print("Digite o novo salário: R$ ");
    BigDecimal salario = new BigDecimal(s.nextLine());

    professorServices.editaProfessor(new DadosPessoais(nome, email), id, salario);
    System.out.println("\nProfessor atualizado com sucesso!");
  }

  private static void editaAluno(Scanner s) {
    System.out.println("\nEdição de aluno");
    System.out.print("\nDigite a matrícula do aluno: ");
    int matricula = Integer.parseInt(s.nextLine());

    Aluno aluno = alunoServices.buscaAlunoPorMatricula(matricula);

    System.out.println("\nNome: " + aluno.getNome());
    System.out.print("Digite o novo nome: ");
    String nome = s.nextLine();

    System.out.println("\nE-mail: " + aluno.getEmail());
    System.out.print("Digite o novo e-mail: ");
    String email = s.nextLine();

    alunoServices.editaAluno(new DadosPessoais(nome, email), matricula);
    System.out.println("\nAluno atualizado com sucesso!");
  }

  private static void deletaProfessor(Scanner s) {
    System.out.println("\nExcluir professor");
    System.out.print("\nDigite o ID do professor: ");
    int id = Integer.parseInt(s.nextLine());

    Professor professor = professorServices.buscaProfessorPorId(id);

    System.out.println("\nTem certeza que deseja excluir o professor " + professor.getNome() + "?");
    System.out.print("Digite 'S' para confirmar: ");
    String res = s.nextLine();

    if (res.toLowerCase().equals("s")) {
      professorServices.deletaProfessor(id);
      System.out.println("\nProfessor excluído com sucesso!");
      return;
    }
    System.out.println("\nValor inválido, a operação não foi concluída!");
  }

  private static void deletaAluno(Scanner s) {
    System.out.println("\nExcluir aluno");
    System.out.print("\nDigite a matrícula do aluno: ");
    int matricula = Integer.parseInt(s.nextLine());

    Aluno aluno = alunoServices.buscaAlunoPorMatricula(matricula);

    System.out.println("\nTem certeza que deseja excluir o aluno " + aluno.getNome() + "?");
    System.out.print("Digite 'S' para confirmar: ");
    String res = s.nextLine();

    if (res.toLowerCase().equals("s")) {
      alunoServices.deletaAluno(matricula);
      System.out.println("\nAluno excluído com sucesso!");
      return;
    }
    System.out.println("\nValor inválido, a operação não foi concluída!");
  }
}
