package datas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class ConversaoDateTime {
  public static void main(String... args) {
    // do maior para o menor
    LocalDateTime dt = LocalDateTime.now();
    LocalDate d = dt.toLocalDate();
    LocalTime t = dt.toLocalTime();

    // do menor para o maior
    LocalDateTime dt2 = d.atTime(14, 45);
    LocalDateTime dt3 = t.atDate(d);

    System.out.println(dt2);
    System.out.println(dt3);

    // conversão da api velha para a nova
    Date d2 = new Date();
    Instant i = d2.toInstant();
    LocalDateTime dt4 = LocalDateTime.ofInstant(i, ZoneId.systemDefault());

    Calendar c = Calendar.getInstance();
    Instant i2 = c.toInstant();
    LocalDateTime dt5 = LocalDateTime.ofInstant(i2, ZoneId.systemDefault());

    System.out.println(dt4);
    System.out.println(dt5);

    // conversão da api nova para a velha

    /*
     * diferença entre o ZoneOffset e o ZoneId: O ZoneId representa certo local com
     * um certo fuso horário, por exemplo, São Paulo e mais o fuso horário de São
     * Paulo, que é GMT-3. O ZoneOffset só representa a parte do GMT-3, não se
     * importa com o local onde aquela hora está valendo. É um pouco diferente entre
     * um e outro, e por uma decisão de design eles resolveram que o ofInstant
     * recebe ZoneId e o toInstant recebe offset.
     */

    Instant i3 = dt.toInstant(ZoneOffset.UTC);
    Date d3 = Date.from(i3);
    Calendar c2 = Calendar.getInstance();
    c2.setTime(d3);

    System.out.println(d3);
  }
}
