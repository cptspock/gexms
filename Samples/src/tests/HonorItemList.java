package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HonorItemList {

	String[] itemIdList = {"70623","70624","70625","70626","70627","70256","70255","70254","70253","70252"};
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	
	public void getItemList() throws IOException{
		//URL stream = new URL("http://www.wowhead.com/items?filter=na=vicious+gladiator+plate;minle=371;maxle=371");
		//URL stream = new URL("http://www.wowhead.com/item=70255");
		//URL stream = new URL("http://www.wowhead.com/search?q=bloodthirsty+pyrium");
		/*BufferedReader in = new BufferedReader(new InputStreamReader(stream
				.openStream()));
		String inputLine;		
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}*/
		for (String itemId : itemIdList){
			System.out.println("Cost of  " +itemId + "=" +getItemCost(itemId));
		}

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
			//System.out.println(inputLine);
		}
		return "costNotFound";
		
	}
	
	public static void main(String[] args) throws IOException {
		new HonorItemList().getItemList();	
	}

}
