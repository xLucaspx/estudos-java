package datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class EstudosDateTime {
	public static void main(String... args) {
		/*
		 * LocalDate = data sem hora;
		 * LocalTime = hora;
		 * LocalDateTime = data com hora;
		 * MonthDay = dia de um mês;
		 * YearMonth = mês e ano;
		 */

		// cria objetos a partir do momento atual
		// formato ISO, que vai da maior unidade de tempo até a menor:
		LocalDate d = LocalDate.now(); // aaaa-mm-dd
		LocalTime t = LocalTime.now(); // hh:MM:ss.ms
		LocalDateTime dt = LocalDateTime.now(); // aaaa-mm-ddThh:MM:ss.ms

		System.out.println(d);
		System.out.println(t);
		System.out.println(dt);

		// utilizando fuso-horários:
		LocalDateTime dt1 = LocalDateTime.now(ZoneId.of("Europe/London"));
		LocalDateTime dt2 = LocalDateTime.now(ZoneId.of("America/New_York"));

		System.out.println("Londres: " + dt1);
		System.out.println("Nova York: " + dt2);

		// criar a partir de um momento específico:
		LocalTime noon = LocalTime.of(12, 0);
		LocalDate birthday = LocalDate.of(2023, 06, 07);
		LocalDateTime xmas = LocalDateTime.of(2023, Month.DECEMBER, 25, 0, 0, 0);
		LocalDateTime birthdayLunch = LocalDateTime.of(birthday, noon);

		// extraindo partes da data:
		System.out.println(xmas.getDayOfMonth());
		System.out.println(xmas.getYear());
		System.out.println(birthdayLunch.getMonth());
		System.out.println(birthdayLunch.getDayOfYear());

		System.out.println(dt1.get(ChronoField.DAY_OF_WEEK)); // segunda (01) a domingo (07)
		System.out.println(dt1.get(ChronoField.DAY_OF_YEAR));

		// quando o tipo não tem determinada unidade de tempo, o código não compila ou
		// lança exception:

		// System.out.println(d.getHour()); // não compila
		// System.out.println(d.get(ChronoField.HOUR_OF_DAY)); // lança exception

		// Utilizando is:
		MonthDay day1 = MonthDay.of(1, 1); // jan 1
		MonthDay day2 = MonthDay.of(1, 2); // jan 2

		System.out.println(day1.isBefore(day2));
		System.out.println(day1.isAfter(day2));
		System.out.println(day1.equals(day2));

		// Os objetos são imutáveis, então os métodos que alteram uma data retornam um
		// novo objeto:
		LocalDate date1 = LocalDate.of(2023, 5, 29);
		LocalDate date2 = date1.withMonth(Month.OCTOBER.getValue());
		LocalDate date3 = date1.withMonth(6).withYear(2020);

		System.out.println(date1); // 2023-05-29
		System.out.println(date2); // 2023-10-29
		System.out.println(date3); // 2020-06-29

		// realizando operações com as datas
		System.out.println(date3.plusYears(5)); // 2025-06-29
		System.out.println(date3.plusDays(10).minusMonths(2).plusYears(3)); // 2023-05-09
		System.out.println(date3.plusDays(75)); // 2020-09-12

		// atenção para a diferença entre ChronoUnit e ChronoField
		System.out.println(date3.minus(5, ChronoUnit.MONTHS));

		// também existem métodos para indicar o que o objeto suporta:
		LocalDate aprilFools = LocalDate.of(2023, 4, 1);

		System.out.println(aprilFools.isSupported(ChronoField.DAY_OF_MONTH)); // este objeto suporta dias?
		System.out.println(aprilFools.isSupported(ChronoField.HOUR_OF_DAY)); // este objeto suporta horas?
		System.out.println(aprilFools.isSupported(ChronoUnit.DAYS)); // posso fazer operações com dias?
		System.out.println(aprilFools.isSupported(ChronoUnit.HOURS)); // posso fazer operações com horas?
	}
}
