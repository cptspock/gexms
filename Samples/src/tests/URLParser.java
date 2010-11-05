package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class URLParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		URLParser p = new URLParser();
		p.constructGearList(272, "Plate", "", false);
	    System.out.println("***********************");
	    //p.constructGearList(272, "Mail", "Heal", false);
	    //p.constructGearList(272, "Mail", "Physical", false);
		
		

	}
	
	private List<String> getItemIdList(int itemLevel, String armorType, String role, boolean PvP) throws IOException{
		URL stream = new URL("http://www.mmo-champion.com/content/1841/");
		BufferedReader in = new BufferedReader(	new InputStreamReader(stream.openStream()));
		String inputLine;		
		List<String> itemIdList = new ArrayList<String>();		

		
			if ((!role.equalsIgnoreCase("Heal")) && !PvP){
				while ((inputLine = in.readLine()) != null){
				if ((inputLine.contains(armorType)) && (!inputLine.contains("Tank")) && (!inputLine.contains("PvP") && (!inputLine.contains("Spell"))) 
						&& (inputLine.contains((new Integer(itemLevel)).toString()))){
					String inputLines[] = inputLine.split("db\\.mmo-champion\\.com\\/i\\/");				
					String something = inputLines[1];
					String itemLine[] = something.split("\\/");				
					itemIdList.add(itemLine[0]);				
				}
				}
			}
			else if (role.equalsIgnoreCase("Heal")){
				while ((inputLine = in.readLine()) != null){
				if ((inputLine.contains(armorType)) && (!inputLine.contains("PvP") && (inputLine.contains("Heal"))) 
						&& (inputLine.contains((new Integer(itemLevel)).toString()))){
					String inputLines[] = inputLine.split("db\\.mmo-champion\\.com\\/i\\/");				
					String something = inputLines[1];
					String itemLine[] = something.split("\\/");				
					itemIdList.add(itemLine[0]);				
				}	
				}
			}
				       
		in.close();
		
		return itemIdList;		
	}
	
	private String getQuestId(String itemId) throws IOException{		
			URL itemStream = new URL("http://cata.wowhead.com/item=" + itemId);
			BufferedReader in2 = new BufferedReader(
					new InputStreamReader(
					itemStream.openStream()));
			String inputLine;
			String questId = "";
			while ((inputLine = in2.readLine()) != null){
				if (inputLine.contains("/quest")){
					String questLine[] = inputLine.split("\\/quest=");
					String[] questIdLine = questLine[1].split("&quot;");
					questId = questIdLine[0];
				}
				else continue;
			}	
			in2.close();
		
		return questId;
		
	}
	
	private String constructGearList(int itemLevel, String armorType, String role, boolean PvP) throws IOException{
		StringBuffer finalString = new StringBuffer();
		List<String> itemIdList = getItemIdList(itemLevel, armorType, role, PvP);
		int i=1;
		String questId;
		for (String itemId : itemIdList){
			StringBuffer temp = new StringBuffer("<a href=\"http://cata.wowhead.com/item=");
			temp.append(itemId);
			temp.append("\">");			
			temp.append("item" + i++);
			temp.append("</a>: ");
			temp.append("<a href=\"http://cata.wowhead.com/quest=");
			questId = getQuestId(itemId);
			temp.append(questId);
			temp.append("\">");
			if (!questId.isEmpty())temp.append(getQuestTitle(questId));
			temp.append("</a>");
			temp.append("\n");
			finalString = finalString.append(temp);			
		}
		System.out.println(finalString.toString());
		return finalString.toString();
	}
	
	private String getQuestTitle(String questId) throws IOException{
		URL itemStream = new URL("http://cata.wowhead.com/quest=" + questId);
		BufferedReader in2 = new BufferedReader(
				new InputStreamReader(
				itemStream.openStream()));
		String inputLine=null, questTitle = null;		
		while ((inputLine = in2.readLine()) != null){
			if (inputLine.contains("<title>")){
				String questTitleLine[] = inputLine.split("<title>");
				StringTokenizer t = new StringTokenizer(questTitleLine[1], "-");
				questTitle = t.nextToken().trim();
			}
		}		
		return questTitle;			
	}

}
