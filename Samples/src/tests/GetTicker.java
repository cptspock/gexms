package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class GetTicker {
	public static void main(String args[]) throws Exception {
		String symbol = "AAPL";
		URL itemStream = new URL("http://www.google.com/finance?q=" + symbol);
		String inputLine;
		final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		while (true) {
			BufferedReader in2 = new BufferedReader(new InputStreamReader(
					itemStream.openStream()));

			while ((inputLine = in2.readLine()) != null) {
				if (inputLine.contains("<span class=\"pr\">")) {
					// System.out.println(inputLine);
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
					System.out.println(sdf.format(cal.getTime()) + " "
							+symbol + " " +callNext(in2));
					//System.out.println(" " + symbol);
				}
			}

			/*
			 * while ((inputLine = in2.readLine()) != null){
			 * System.out.println(inputLine); }
			 */
			Thread.sleep(10L);
		}
		// in2.close();
	}

	private static String callNext(BufferedReader in) throws IOException {
		String stockPriceLine = in.readLine();
		String[] stockPrice = stockPriceLine.split("<span id=\"ref_.*\">");
		String[] stockPriceFinal = stockPrice[1].split("</span>");
		return stockPriceFinal[0];
		//return stockPriceLine;
	}
}
