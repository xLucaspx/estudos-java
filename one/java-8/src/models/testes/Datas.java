package models.testes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
  public static void main(String[] args) {

    LocalDate copaQatar = LocalDate.of(2022, Month.NOVEMBER, 20);
    LocalDate proximaCopa = copaQatar.plusYears(4);

    System.out.println("Copa do Qatar " + copaQatar.getYear());
    System.out.println("Próxima copa em " + proximaCopa.getYear());

    LocalDate hoje = LocalDate.now();
    System.out.println("Data atual: " + hoje);

    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println("Data formatada: " + hoje.format(formatador));

    LocalDate fimCurso = LocalDate.of(2024, Month.APRIL, 30);

    String valorFormatado = fimCurso.format(formatador);
    System.out.println("Fim do curso: " + valorFormatado);

    int anos = fimCurso.getYear() - hoje.getYear();
    System.out.println("Faltam " + anos + " anos para o fim do curso");

    Period periodo = Period.between(hoje, fimCurso);
    System.out.println("Faltam " + periodo.toTotalMonths() + " meses para o fim do curso");

    LocalDateTime agora = LocalDateTime.now();

    DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm");
    System.out.println("Data e hora: " + agora.format(formatadorComHoras));

    LocalTime aula = LocalTime.of(19, 00);
    System.out.println("Horário das aulas: " + aula);
  }
}
