package quests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class QuestsByZoneScrapper {

	private List<String> zoneList = new ArrayList<>();

	public void getAllZones() {
		zoneList.add(Zones.AZSUNA_URL_1);
		zoneList.add(Zones.AZSUNA_URL_2);
		zoneList.add(Zones.HIGH_MOUNTAIN_URL_1);
		zoneList.add(Zones.HIGH_MOUNTAIN_URL_2);
		zoneList.add(Zones.HIGH_MOUNTAIN_URL_3);
		zoneList.add(Zones.HIGH_MOUNTAIN_URL_4);
		zoneList.add(Zones.STORMHEIM_URL_1);
		zoneList.add(Zones.STORMHEIM_URL_2);
		zoneList.add(Zones.STORMHEIM_URL_3);
		zoneList.add(Zones.SURAMAR_URL_1);
		zoneList.add(Zones.SURAMAR_URL_2);
		zoneList.add(Zones.SURAMAR_URL_3);
		zoneList.add(Zones.SURAMAR_URL_4);
		zoneList.add(Zones.VALSHARAH_URL_1);
		zoneList.add(Zones.VALSHARAH_URL_2);
		zoneList.add(Zones.VALSHARAH_URL_3);
		zoneList.add(Zones.VALSHARAH_URL_4);
	}

	public List<String> getAllQuestsInZone() {
		for (String zone : zoneList) {
			// call the url
			URL stream = null;
			BufferedReader in = null;
			try {
				//Document doc = Jsoup.connect(zone).get();
				stream = new URL(zone);
				in = new BufferedReader(new InputStreamReader(stream.openStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
				}
				System.out.println("ONE");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// for each quest id, call quest scrapper
			/*
			 * for (String questId : questList) {
			 * QuestScrapper.getQuestDetails(questId); }
			 */

		}
		return null;
	}

	public List<String> scrapForQuestIds() {
		return null;
	}

	public static void main(String[] args) {
		QuestsByZoneScrapper QS = new QuestsByZoneScrapper();
		QS.getAllZones();
		QS.getAllQuestsInZone();

	}

}
