package quests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QuestScrapper {
	private QuestDAO questDAO;

	public static void getQuestDetails() throws IOException {
		URL stream = null;
		BufferedReader in = null;

		String questId = "38878";
		stream = new URL("http://legion.wowhead.com/quest=" + questId);
		Document doc = Jsoup.connect("http://legion.wowhead.com/quest=" + questId).get();
		// stream = new URL("http://www.google.com");

		Elements all = doc.getElementsByTag("h2");
		all = doc.getElementsContainingText("Description");
		for (Element element : all) {
			if (element.tag().toString() == "h2") {
				// System.out.println(element.data().toString());
			}
		}
		// System.out.println("All elements: " + all.text());
		in = new BufferedReader(new InputStreamReader(stream.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {

			// grab title
			if (inputLine.contains("<h1 class=\"heading-size-1\">")) {
				String[] titleLine = inputLine.split("<h1 class=\"heading-size-1\">");
				String title = titleLine[1];
				title = title.replaceAll("</h1>", ""); 
				//TODO: If title contains Deprecated, don't add
				// System.out.println(title);
			}

			// grab description
			if (inputLine.contains("<h2 class=\"heading-size-3\">Description</h2>")) {
				String descLine = null;
				StringBuffer descbuff = new StringBuffer();
				while (!(descLine = in.readLine()).contains("<h2 class=\"heading-size-3\">")) {
					descbuff.append(descLine);
				}
				System.out.println(descbuff.toString()); //persist this

			}
			// grab rewards - if gear grab gear
			// grab experience

			String[] gold;
			String goldValue = null;
			if (inputLine.contains("moneygold")) {
				gold = inputLine.split("moneygold\">");
				goldValue = gold[1];
				String[] fullGoldLine = gold[1].split("</span>");
				if (fullGoldLine[])
				// System.out.println(fullGoldLine[0]);
			}
		}
	}

	public static void main(String[] args) {
		try {
			QuestScrapper.getQuestDetails();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
