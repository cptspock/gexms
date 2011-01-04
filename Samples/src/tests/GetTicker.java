package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetTicker {
	public static void main(String args[]) throws Exception{
		URL itemStream = new URL("http://www.google.com/finance?q=crm");
		String inputLine;
		final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		while(true){
			BufferedReader in2 = new BufferedReader(
					new InputStreamReader(
					itemStream.openStream()));
			
		while ((inputLine = in2.readLine()) != null){
			if (inputLine.contains("<span class=\"pr\">")){
				//System.out.println(inputLine);
				Calendar cal = Calendar.getInstance();
			    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			    System.out.println(sdf.format(cal.getTime()) + " " + callNext(in2));
			}				
		}
			
		/*while ((inputLine = in2.readLine()) != null){
			System.out.println(inputLine);
		}	*/
		Thread.sleep(5000);
		}
		//in2.close();
	}
	
	private static String callNext(BufferedReader in) throws IOException{
		return in.readLine();	
	}
}
