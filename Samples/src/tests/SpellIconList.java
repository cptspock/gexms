package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SpellIconList {

	/**
	 * @param args
	 * @return
	 * @throws IOException
	 */

	private void getIconList() throws IOException {
		//URL stream = new URL("http://mop.wowhead.com/spells=7.1"); //main spells
		URL stream = new URL("http://mop.wowhead.com/spells=-12.11"); //spec spells

		BufferedReader in = new BufferedReader(new InputStreamReader(
				stream.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			if (inputLine.contains("icon:")) {
				String iconText[] = inputLine.split("name_enus:");
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
					}

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new SpellIconList().getIconList();

	}

}
