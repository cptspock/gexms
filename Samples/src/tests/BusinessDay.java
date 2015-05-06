package tests;

import java.time.DayOfWeek;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;

public class BusinessDay {

	static DateTime BusinessDayFinder(DateTime today, int n) {
		/*int count = 0;
		while (count < n - 1) {
			if (today.getDayOfWeek() == DateTimeConstants.SATURDAY
					|| today.getDayOfWeek() == DateTimeConstants.SUNDAY) {
				today = today.plusDays(1);

			} else {
				count++;
				today = today.plusDays(1);
			}
		}

		return today;*/
		
		  if (today.getDayOfWeek() == DateTimeConstants.SATURDAY ||
		  today.getDayOfWeek() == DateTimeConstants.SUNDAY) { return
		  BusinessDayFinder(today.plusDays(1), n); }
		  
		  if (n == 0) return today;
		  
		  return BusinessDayFinder(today.plusDays(1), n - 1);
		 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DateTime(DateTimeZone.getDefault())
				.getDayOfMonth());
		System.out.println(BusinessDayFinder(
				new DateTime(DateTimeZone.getDefault()), 2).getDayOfMonth());

	}

}
