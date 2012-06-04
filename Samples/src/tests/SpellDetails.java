package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SpellDetails {
	URL stream = null;
	BufferedReader in = null;

public void getSpellDetails(String spellId) throws IOException{	
		stream = new URL("http://mop.wowhead.com/spell=" + spellId);
		in = new BufferedReader(new InputStreamReader(
				stream.openStream()));
		String inputLine;
		String spellText[];
		String finalSpellText[];
		while ((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			if (inputLine.contains("<meta name=\"description\"")){
				spellText = inputLine.split("content=\"");
				finalSpellText = spellText[1].split("\" />");
				System.out.println(finalSpellText[0]);
			}					
		}
	}

	public static void main(String[] args) throws IOException {
		new SpellDetails().getSpellDetails("78");
	}
}
