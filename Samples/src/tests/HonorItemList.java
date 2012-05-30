package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HonorItemList {

	//String[] itemIdList = {"70623","70624","70625","70626","70627","70256","70255","70254","70253","70252"};
	//String[] itemIdList = {"70573","70574","70513","70514","70667","70668","70538","70539"};
	String[] itemIdList = {"70630","70045"};
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	
	public void getItemList() throws IOException{
		//URL stream = new URL("http://www.wowhead.com/npc=40336#comments");
		//URL stream = new URL("http://www.wowhead.com/item=70633");
		URL stream = new URL("http://mop.wowhead.com/spells=7.1");
		BufferedReader in = new BufferedReader(new InputStreamReader(stream
				.openStream()));
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		/*for (String itemId : itemIdList){
			System.out.println("Cost of  " +itemId + "=" +getItemCost(itemId));
		}*/

	}
	
	public String getItemCost(String itemId) throws IOException{
		URL stream = new URL("http://www.wowhead.com/item=" + itemId);
		BufferedReader in = new BufferedReader(new InputStreamReader(stream
				.openStream()));
		String inputLine = null, itemCost = null;		
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.contains("Cost: [money=0][currency=")){
				String amountLine[] = inputLine.split("amount=");				
				String[] costLine = amountLine[1].split("\\]\\[");
				itemCost = costLine[0];
				return itemCost;
			}
			System.out.println(inputLine);
		}
		return "costNotFound";
		
	}
	
	public static void main(String[] args) throws IOException {
		new HonorItemList().getItemList();	
	}

}
