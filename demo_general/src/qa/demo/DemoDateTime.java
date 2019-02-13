package qa.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
//import static java.time.temporal.ChronoUnit.* ;


public class DemoDateTime {

	public static void main ( String[] args ) throws InterruptedException {
//		Instant start = Instant.now();
//
//		Thread.sleep ( 5000 ) ;
//
//		Instant end = Instant.now();
//
//		Duration elapsed = Duration.between(start, end) ;
//
//		System.out.println("Elapsed time "
//					+ elapsed.toNanos() );

//		LocalDate ld = LocalDate.of(2016, 6, 9);
//
//		System.out.println(ld.isLeapYear());
//
//		System.out.println("Day of week " + ld.get(ChronoField.DAY_OF_WEEK));
//
//		DateTimeFormatter df = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
//
//		LocalDateTime now = LocalDateTime.now();
//
//		System.out.println(df.format(now));

		DateTimeFormatter df = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALY);

		LocalDate ld = LocalDate.of(1970, 11, 13) ;
		DayOfWeek dw = ld.getDayOfWeek();

		System.out.println("Birth Date " + ld.format(df));

		System.out.println("Day of week born " + dw) ;

		LocalDate today = LocalDate.now();

		Period p = Period.between(ld, today ) ;

		long daysOld = ChronoUnit.DAYS.between(ld, today) ;
//		long daysOld = DAYS.between(ld, today) ;
		
		System.out.println("Number of days old " + daysOld );

		System.out.println("You are "
					+ p.getYears()
					+ " years "
					+ p.getMonths()
					+ " months "
					+ p.getDays()
					+ " days old!");

		Map<String, String> zones = ZoneId.SHORT_IDS ;

		LocalTime lt = LocalTime.now();
		for ( Entry<String, String> e : zones.entrySet() ) {
			System.out.println(e.getKey() + " " + e.getValue());
			ZoneId z = ZoneId.of(e.getValue());
			System.out.println("Time in " + e.getValue() + " is " + LocalTime.now(z));
		}


	}






}
