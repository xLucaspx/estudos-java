package curso;

public class TestaBreakEContinue {
  public static void main(String[] args) {
    System.out.println("break:");
    int i = 0;
    while (i < 10) {
      if (i == 5)
        break;
      System.out.print(i++ + " ");
    }

    System.out.println("\ncontinue:");
    i = 0;
    while (i < 10) {
      i++;
      if (i == 5)
        continue;
      System.out.print(i + " ");
    }

    System.out.println("\nbreak e continue com for:");
    for (int j = 0; j < 10; j++) {
      if (j == 5)
        continue;
      if (j == 8)
        break;
      System.out.print(j + " ");
    }

    // break/continue afetam o laço MAIS PRÓXIMO, no caso abaixo o laço do j:
    System.out.println("\ncontinue no laço interno:");
    for (i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        if (i * j == 20) {
          System.out.println("CONTINUE");
          continue;
        }
        System.out.println(i + " * " + j + " = " + (i * j));
      }
    }

    // todo statement pode ter um nome (label); podemos usar essa label para dar
    // break ou continue neste laço específico; a label pode se repetir, desde que
    // não haja conflito de escopos; também podem existir labels e variáveis com o
    // mesmo nome, pois cada coisa é uma coisa
    System.out.println("\nbreak em laço específico:");
    tabuada: for (i = 1; i <= 10; i++) {
      for (int j = 1; j <= 10; j++) {
        if (i * j == 21) {
          System.out.println("BREAK tabuada");
          break tabuada;
        }
        System.out.println(i + " * " + j + " = " + (i * j));
      }
    }
    // ATENÇÃO: se utilizar break/continue com uma label, o Java vai procurar um
    // for, while ou switch com aquela label, e se não encontrar dará erro de
    // compilação (missing label);

    // Statements podem ter mais de uma label!

    // em casos de loops infinitos com break,
    // o compilador não acusa unreacheable code:
    System.out.println("loop infinito com break:");
    while (true) {
      i++;
      if (i == 25)
        break;
      System.out.print(i + " ");
    }
    i = 0; // compila

    // mas se trocarmos o break por continue, não compila:
    // while(true) {
    // i++;
    // if (i == 25) continue;
    // System.out.println(i);
    // }
    // i = 0; // unreacheable code: não compila

    System.out.println("\nPEGADINHA: switch não tem continue:");
    for (i = 0; i < 4; i++) {
      System.out.println("Antes do switch!");
      switch (i) {
        case 0:
        case 1:
          System.out.println("Caso " + i);
          break; // break do switch
        case 2:
          System.out.println("Agora é o " + i);
          continue; // continue é do for, pula para próx. iteração
        case 3:
          System.out.println("Chegamos no " + i);
          break;
        default:
          System.out.println("Estranho...");
          break;
      }
      System.out.println("Depois do switch!");
    }
  }
}
