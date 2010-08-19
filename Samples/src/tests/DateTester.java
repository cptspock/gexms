package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class DateTester {

	public static void main(String args[]) {
		List<Calendar> dateList = new ArrayList<Calendar>();
		Calendar d1 = new GregorianCalendar();
		d1.set(1980, 5, 4);
		dateList.add(d1);
		Calendar d2 = new GregorianCalendar();
		d2.set(1981, 5, 4);
		dateList.add(d2);
		System.out.println(d1.compareTo(d2));
		Collections.sort(dateList);

		for (Calendar c : dateList) {
			System.out.println(c.get(Calendar.YEAR));
		}

		Date date = new Date();
		DateFormat pstFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss z");
		DateFormat gmtFormat = new SimpleDateFormat();
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		TimeZone pstTime = TimeZone.getTimeZone("PST");

		pstFormat.setTimeZone(pstTime);
		gmtFormat.setTimeZone(gmtTime);
		System.out.println("GMT Time: " + (date));
		System.out.println("PST Time: " + pstFormat.format(date));
	}
}