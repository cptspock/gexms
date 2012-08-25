package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SpellDAO {
	Connection conn;
	Statement stat;

	public SpellDAO() throws ClassNotFoundException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:wowmist.db");
			stat = conn.createStatement();
			//stat.executeUpdate("drop table if exists spell;");
			stat.executeUpdate("create table if not exists spell(spellId TEXT, spellName TEXT, desc TEXT, imageName TEXT, cost TEXT, cooldown TEXT, range TEXT, time TEXT, class TEXT, spec TEXT, build TEXT, version TEXT, primary key(spellId));");
		}
		catch (SQLException sqle){
			System.out.println("Could not create table");
		}
		
	}

	public void DBInsert(String spellId, String spellName, String desc,
			String imageName, String cost, String cooldown, String range,
			String time, String className, String spec, String build,
			String version) {

		try{
			PreparedStatement prep = conn
					.prepareStatement("insert into spell values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

			prep.setString(1, spellId);
			prep.setString(2, spellName);
			prep.setString(3, desc);
			prep.setString(4, imageName);
			prep.setString(5, cost);
			prep.setString(6, cooldown);
			prep.setString(7, range);
			prep.setString(8, time);
			prep.setString(9, className);
			prep.setString(10, spec);
			prep.setString(11, build);
			prep.setString(12, version);

			prep.addBatch();

			conn.setAutoCommit(false);
			prep.executeBatch();
			conn.setAutoCommit(true);


		}
		catch (SQLException sqle){
			System.out.println("Spell could not be entered");
		}
				/*
		 * ResultSet rs = stat.executeQuery("select * from spell;"); while
		 * (rs.next()) { System.out.println("name = " +
		 * rs.getString("spellId")); System.out.println("job = " +
		 * rs.getString("spellName")); } rs.close(); conn.close();
		 */
	}

	public static void main(String[] args) throws Exception {

	}
}
