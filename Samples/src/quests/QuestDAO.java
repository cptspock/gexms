package quests;

public class QuestDAO {

	public void insertQuest() {
		executeUpdate("create table if not exists quest(questId INT, questTitle TEXT, desc TEXT, rewardsGear INT, rewards TEXT, xp100 TEXT, xp110 TEXT, questZone TEXT, primary key(questId));"); // if rewardsGear = 1, then quests rewards gear, else only gold/XP
		executeUpdate("create table if not exists gearRewards(questId INT, gear TEXT, primary key(questId)"); 

	}
	
	public void updateQuest() {
		
	}
}
