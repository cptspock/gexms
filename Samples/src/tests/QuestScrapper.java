package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class QuestScrapper {
	URL stream = null;
	BufferedReader in = null;
	QuestDAO questDAO;

	public void getQuestDetails() throws IOException {
		String questId = null;
		stream = new URL("http://legion.wowhead.com/quest=" + questId);
		in = new BufferedReader(new InputStreamReader(stream.openStream()));

	}

	public static void main(String[] args) {

	}

}
