package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

public class SpellDetails {
	URL stream = null;
	BufferedReader in = null;
	SpellDAO spellDAO;

	public SpellDetails() throws ClassNotFoundException, SQLException {
		spellDAO = new SpellDAO();
	}

	public void getSpellDetails(String spellId, String imageName,
			String className, String spec, String build, String version)
			throws IOException, ClassNotFoundException, SQLException {
		stream = new URL("http://mop.wowhead.com/spell=" + spellId);
		in = new BufferedReader(new InputStreamReader(stream.openStream()));
		String inputLine;
		String spellText[];
		String finalSpellText[] = null;
		String cost[];
		String range[];
		String fullSpellName[];
		String finalSpellName[];
		String spellName = "";
		;
		String finalCost[] = null;
		String finalTime[] = null;
		String finalRange[] = null;
		String finalCooldown = "";

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

			// to change to support NO cost spells <th
			// style="border-top: 0">Cost</th><td
			// style="border-top: 0">None</td>
			if (inputLine.contains("<th style=\"border-top: 0\">Cost</th>")) {
				cost = inputLine.split("<td style=\"border-top: 0\">");
				// System.out.println("full cost:" + cost[i]);
				finalCost = cost[1].split("</td>");
				System.out.println("final cost:" + finalCost[0]);

			}

			// find cast range
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
			// find spell cooldown
			String cooldown[];
			String cooldownFull[];
			if (inputLine.contains("<th>Cooldown</th>")) {
				if (inputLine.contains("<span class=\"q0\">")
						&& !inputLine.contains("seconds")
						&& !inputLine.contains("minutes")) {
					cooldown = inputLine.split("<span class=\"q0\">");
					String tempCooldown[] = cooldown[1].split("<");
					finalCooldown = tempCooldown[0];
					System.out.println("final cooldown:" + finalCooldown);
				} else {
					String fullCooldown[];
					cooldownFull = inputLine.split("<th>Cooldown</th>");
					String tempCooldown[] = cooldownFull[1].split("</div>-->");
					fullCooldown = tempCooldown[1].split("<");
					finalCooldown = fullCooldown[0];
					System.out.println("final cooldown:" + finalCooldown);
				}
			}

		}
		if (finalSpellText != null){
			ImageCopier.copySpellImage(spellName, spellId, imageName, className);
			insertDb(spellId, spellName, finalSpellText[0], imageName,
					finalCost[0], finalCooldown, finalRange[0], finalTime[0],
					className, spec, build, version);
		}
			
	}

	private void insertDb(String spellId, String spellName, String desc,
			String imageName, String cost, String cooldown, String range,
			String time, String className, String spec, String build,
			String version) throws ClassNotFoundException, SQLException {

		spellDAO.DBInsert(spellId, spellName, desc, imageName, cost, cooldown,
				range, time, className, spec, build, version);

	}

	public static void main(String[] args) throws IOException {
		// new SpellDetails().getSpellDetails("78");
	}
}
