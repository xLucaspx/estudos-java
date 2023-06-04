package datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatacaoDatas {
  public static void main(String[] args) {
    LocalDateTime datetime = LocalDateTime.now();
    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    System.out.println(dtFormatter.format(datetime));
    System.out.println(datetime.format(dtFormatter));

    // convertendo a partir de strings
    DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd-MM-yy");

    System.out.println(LocalDate.parse("31-05-23", dFormatter));
    System.out.println(LocalDateTime.parse("31/05/2023 15:45", dtFormatter));
  }
}
