package quests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class QuestDAO {

	private Connection conn;

	public QuestDAO() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not find JDBC driver");
		}

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:/Users/212472312/sqlite/db/legion.db");
			Statement createStatement = conn.createStatement();
			// if rewardsGear=1, then quests rewards gear, else only gold/XP
			createStatement.executeUpdate(
					"create table if not exists quest(questId INT, questTitle TEXT, desc TEXT, rewardsGear INT, rewards TEXT, xp100 TEXT, xp110 TEXT, questZone TEXT, primary key(questId));");
			createStatement.executeUpdate(
					"create table if not exists gearRewards(questId INT, gear TEXT, primary key(questId)");
		} catch (SQLException e) {
			System.out.println("Could not crete table");
		}
	}

	public void insertQuest(String questId, String questTitle, String description, int rewardsGear, String rewards,
			String xp100, String xp110, String questZone) {

		try {
			PreparedStatement insertStatement = conn.prepareStatement("insert into quest(?, ?, ?, ?, ?, ?, ?, ?)");
			insertStatement.setString(1, questId);
			insertStatement.setString(2, questTitle);
			insertStatement.setString(3, description);
			insertStatement.setInt(4, rewardsGear);
			insertStatement.setString(5, rewards);
			insertStatement.setString(6, xp100);
			insertStatement.setString(7, xp110);
			insertStatement.setString(8, questZone);

			insertStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("could not execute insert query");
		}
	}

	public void updateQuest() {

	}
}
