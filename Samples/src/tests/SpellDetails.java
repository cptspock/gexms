package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

public class SpellDetails {
	URL stream = null;
	BufferedReader in = null;

	public void getSpellDetails(String spellId, String imageName, String className, String spec, String build, String version) throws IOException, ClassNotFoundException, SQLException {
		stream = new URL("http://mop.wowhead.com/spell=" + spellId);
		in = new BufferedReader(new InputStreamReader(stream.openStream()));
		String inputLine;
		String spellText[];
		String finalSpellText[];
		String cost[];
		String range[];
		String fullSpellName[];
		String finalSpellName[];
		String spellName="";;
		String finalCost[]=null;
		String finalTime[]=null;
		String finalRange[]=null;

		while ((inputLine = in.readLine()) != null) {
			// System.out.println(inputLine);
			if (inputLine.contains("<title>")) {
				fullSpellName = inputLine.split("<title>");
				finalSpellName = fullSpellName[1].split("- Spell");
				spellName = finalSpellName[0];
				System.out.println("Spell name: " + spellName);
			}

			if (inputLine.contains("<meta name=\"description\"")) {
				spellText = inputLine.split("content=\"");
				finalSpellText = spellText[1].split("\" />");
				System.out.println(finalSpellText[0]);
			}

			if (inputLine.contains("tooltip_enus")) {
				cost = inputLine.split("<td>");
				for (int i = 0; i < cost.length; i++) {
					if ((cost[i].toLowerCase().contains("rage"))
							|| (cost[i].toLowerCase().contains("mana"))
							|| (cost[i].toLowerCase().contains("energy"))
							|| (cost[i].toLowerCase().contains("chi"))
							|| (cost[i].toLowerCase().contains("frost"))
							|| (cost[i].toLowerCase().contains("unholy"))
							|| (cost[i].toLowerCase().contains("blood"))) {
						// System.out.println("full cost:" + cost[i]);
						finalCost = cost[i].split("</td>");
						System.out.println("final cost:" + finalCost[0]);
						break;
					}
				}
			}
			
			//find cast range
			if (inputLine.contains("<th>Range</th>")) {
				range = inputLine.split("<th>Range</th>");		
				String tempRange[] = range[1].split("<td>");
				finalRange = tempRange[1].split("<");
				System.out.println("final range:" + finalRange[0]);
				// break;
				// }
			}
			String time[];
			// find cast time
			if (inputLine.contains("<th>Cast time</th>")) {
				time = inputLine.split("<th>Cast time</th>");		
				String tempTime[] = time[1].split("<td>");
				finalTime = tempTime[1].split("<");
				System.out.println("final time:" + finalTime[0]);
				// break;
				// }
			}

		}
		insertDb(spellId, spellName, imageName, finalCost[0], finalRange[0], finalTime[0], className, spec, build, version);
	}
	
	private void insertDb(String spellId, String spellName, String imageName, String cost, String range, String time, String className, String spec, String build, String version) throws ClassNotFoundException, SQLException{
		SpellDAO spellDAO = new SpellDAO();
		spellDAO.DBInsert(spellId, spellName, imageName, cost, range, time, className, spec, build, version);
		
	}

	public static void main(String[] args) throws IOException {
		//new SpellDetails().getSpellDetails("78");
	}
}
