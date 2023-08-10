package app;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Set;

import exceptions.RegraDeNegocioException;
import models.Conta;
import models.dto.DtoCliente;
import models.dto.DtoConta;
import services.ContaServices;

public class App {
  private static ContaServices contaServices = new ContaServices();

  public static void main(String... args) {
    Scanner s = new Scanner(System.in);
    int opcao = 0;

    while (opcao != 7) {
      try {
        opcao = exibeMenu(s);
        switch (opcao) {
          case 1 -> {
            listaContas(s);
            break;
          }
          case 2 -> {
            abreConta(s);
            break;
          }
          case 3 -> {
            encerraConta(s);
            break;
          }
          case 4 -> {
            consultaSaldo(s);
            break;
          }
          case 5 -> {
            realizaDeposito(s);
            break;
          }
          case 6 -> {
            realizaSaque(s);
            break;
          }
          case 7 -> {
            System.out.println("\nPrograma encerrado!");
            break;
          }
          default -> {
            throw new IllegalArgumentException("O valor digitado não corresponde a nenhuma operação!");
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("O valor digitado é inválido! Mensagem de erro:\n" + e.getMessage());
        opcao = 0;
      } catch (RegraDeNegocioException e) {
        System.out.println("Ocorreu um erro ao tentar realizar a operação:\n" + e.getMessage());
        opcao = 0;
      } catch (Exception e) {
        System.out.println("Ocorreu um erro durante a execução do programa:\n" + e.getMessage());
        opcao = 0;
      }
    }
    s.close();
  }

  private static int exibeMenu(Scanner s) {
    System.out.print("""
        \nByteBank - Menu Principal
        1 - Listar contas
        2 - Abrir uma conta
        3 - Encerrar uma conta
        4 - Consulta de saldo
        5 - Realizar depósito
        6 - Realizar saque
        7 - Sair
        """);
    System.out.print("Digite o número da operação desejada: ");

    return Integer.parseInt(s.nextLine());
  }

  private static void listaContas(Scanner s) {
    System.out.println("\nContas abertas:");
    Set<Conta> contas = contaServices.listaContas();

    if (contas.size() <= 0)
      System.out.println("Não existem contas abertas no momento");
    else
      contas.stream().forEach(System.out::println);

    System.out.print("\nPressione ENTER para retornar ao menu principal...");
    s.nextLine();
  }

  private static void abreConta(Scanner s) {
    System.out.print("\nDigite o número da conta: ");
    int numero = Integer.parseInt(s.nextLine());

    System.out.print("Digite o nome do titular: ");
    String nome = s.nextLine();

    System.out.print("Digite o CPF do titular: ");
    String cpf = s.nextLine();

    System.out.print("Digite o e-mail do titular: ");
    String email = s.nextLine();

    contaServices.abreConta(new DtoConta(numero, new DtoCliente(nome, cpf, email)));
    System.out.print("\nConta aberta com sucesso!\n\nPressione ENTER para retornar ao menu principal...");
    s.nextLine();
  }

  private static void encerraConta(Scanner s) {
    System.out.print("\nDigite o número da conta: ");
    int numero = Integer.parseInt(s.nextLine());

    contaServices.encerraConta(numero);
    System.out.print("\nConta encerrada com sucesso!\n\nPressione ENTER para retornar ao menu principal...");
    s.nextLine();
  }

  private static void consultaSaldo(Scanner s) {
    System.out.print("\nDigite o número da conta: ");
    int numero = Integer.parseInt(s.nextLine());
    BigDecimal saldo = contaServices.consultaSaldo(numero);

    System.out.println(String.format("\nO saldo da conta é de R$ %.2f", saldo));
    System.out.print("\nPressione ENTER para retornar ao menu principal...");
    s.nextLine();
  }

  private static void realizaSaque(Scanner s) {
    System.out.print("\nDigite o número da conta: ");
    int numero = Integer.parseInt(s.nextLine());

    System.out.print("Digite o valor do saque: ");
    BigDecimal valor = BigDecimal.valueOf(Float.parseFloat(s.nextLine()));

    contaServices.realizarSaque(numero, valor);

    System.out.print("\nOperação realizada com sucesso!\n\nPressione ENTER para retornar ao menu principal...");
    s.nextLine();
  }

  private static void realizaDeposito(Scanner s) {
    System.out.print("\nDigite o número da conta: ");
    int numero = Integer.parseInt(s.nextLine());

    System.out.print("Digite o valor do depósito: ");
    BigDecimal valor = BigDecimal.valueOf(Float.parseFloat(s.nextLine()));

    contaServices.realizarDeposito(numero, valor);

    System.out.print("\nOperação realizada com sucesso!\n\nPressione ENTER para retornar ao menu principal...");
    s.nextLine();
  }
}
