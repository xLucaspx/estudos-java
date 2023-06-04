package datas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class CalculoDatas {
  public static void main(String... args) {
    Instant i = Instant.now();
    Duration tenSec = Duration.ofSeconds((10));

    System.out.println(i);
    System.out.println(i.plus(tenSec));

    Instant i2 = Instant.EPOCH; // 01/01/1970 00:00:00
    long segundos = Duration.between(i2, i).getSeconds();
    System.out.println(segundos);

    /*
     * a classe Duration é usada para manipular Instant. Quando estamos falando de
     * outras unidades de tempo, mais complexas, como LocalDate, LocalTime,
     * LocalDateTime, não usamos a classe Duration para fazer contas entre elas;
     * usamos ChronoUnit ou Period, depende bastante do que você quer fazer,
     */

    LocalDate birth = LocalDate.of(2002, 6, 7);
    LocalDate now = LocalDate.now();

    System.out.println(ChronoUnit.YEARS.between(birth, now));
    System.out.println(ChronoUnit.MONTHS.between(birth, now));
    System.out.println(ChronoUnit.DAYS.between(birth, now));

    Period existence = Period.between(birth, now);

    System.out.println(existence.getYears() + " anos");
    System.out.println(existence.getMonths() + " meses");
    System.out.println(existence.getDays() + " dias");
  }
}
