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
		String cost[];
		while ((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			if (inputLine.contains("<meta name=\"description\"")){
				spellText = inputLine.split("content=\"");
				finalSpellText = spellText[1].split("\" />");
				System.out.println(finalSpellText[0]);
			}	
			
			if (inputLine.contains("tooltip_enus")){
				cost = inputLine.split("<td>");
				for (int i = 0; i < cost.length; i++){
					if ((cost[i].toLowerCase().contains("rage")) || (cost[i].toLowerCase().contains("mana")) || (cost[i].toLowerCase().contains("energy")) || (cost[i].toLowerCase().contains("chi")) || (cost[i].toLowerCase().contains("frost")) || (cost[i].toLowerCase().contains("unholy")) || (cost[i].toLowerCase().contains("blood"))){
						System.out.println("full cost:" + cost[i]);
						String finalCost[] = cost[i].split("</td>");
						System.out.println("final cost:" + finalCost[0]);
						break;
					}
				}
				
			
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new SpellDetails().getSpellDetails("78");
	}
}
