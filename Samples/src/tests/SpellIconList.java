package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

public class SpellIconList {
	SpellDetails spellDetails;

	/**
	 * @param args
	 * @return
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */

	public SpellIconList() throws ClassNotFoundException, SQLException {
		spellDetails = new SpellDetails();
	}
	private void getIconList() throws IOException, ClassNotFoundException, SQLException {
		//URL stream = new URL("http://mop.wowhead.com/spells=7.10"); //main spells
		URL stream = new URL("http://mop.wowhead.com/spells=-12.10"); //spec spells
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				stream.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			if (inputLine.contains("icon:")) {
				//String iconText[] = inputLine.split("name_enus:");
				String iconText[] = inputLine.split(";");
				//String iconText[] = inputLine.split("_\\[");
				
				String iconName[];
				for (int i = 0; i < iconText.length; i++) {
					
					//System.out.println(i + "icon" + iconText[i]);
					String finalIconText[];
					if (iconText[i].contains("rank_enus")) {
						iconName = iconText[i].split("icon:");
					//	 System.out.println(i + "icon" + iconName[1]);
						finalIconText = iconName[1].split("'");
						System.out
								.println("http://wow.zamimg.com/images/wow/icons/large/"
										+ finalIconText[1] + ".jpg");
						//System.out.println("http://mop.wowhead.com/spell=");
						getSpellId(iconText[i], finalIconText[1]);
					}
					
				}
			}
		}
	}
	
	private void getSpellId(String iconText, String imageName) throws IOException, ClassNotFoundException, SQLException{
		String spellText[];
		spellText = iconText.split("_\\[");
		String spellTextFinal[] = spellText[1].split("]");
		//String spellNameText[] = iconText.split("name_enus:'");
		//String[] finalSpellName = spellNameText[1].split("'");
		//String spellId, String imageName, String className, String spec, String build, String version
		spellDetails.getSpellDetails(spellTextFinal[0], imageName,"Monk","SPEC","build", "5.0");
		System.out.println("Spell id= " + spellTextFinal[0]);		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		new SpellIconList().getIconList();
		
	}

}
