/* -> Number of Hours, days, months, year passed after 1st Jan 1970 */

import java.time.*;

public class DateExample {

	public static void main(String[] args) {
		LocalDate from_date = LocalDate.of(1970, 01, 01);
		LocalDate now = LocalDate.now();

        Period diff = Period.between(from_date, now);

        long years = diff.getYears();
        Long months = years * 12 + diff.getMonths();
        Long days = months * 30 + diff.getDays();
        Long hours = days * 24;

        System.out.println("Hours: " + hours);
        System.out.println("Days: " + days);
        System.out.println("Months: " + months);
        System.out.println("Years: " + years);		
	}
}
