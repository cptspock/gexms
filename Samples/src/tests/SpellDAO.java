package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpellDAO {
	Connection conn;

	public SpellDAO() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:wowmist.db");
	}

	public void DBInsert(String spellId, String spellName, String imageName,
			String cost, String range, String time, String className, String spec, String build, String version) throws SQLException
    {
		Statement stat = conn.createStatement();
		// stat.executeUpdate("drop table if exists people;");
		stat.executeUpdate("create table if not exists spell(spellId, spellName, imageName, cost, range, time, class, spec, build, version);");
		PreparedStatement prep = conn
				.prepareStatement("insert into spell values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

		prep.setString(1, spellId);
		prep.setString(2, spellName);
		prep.setString(3, imageName);
		prep.setString(4, cost);
		prep.setString(5, range);
		prep.setString(6, time);		
		prep.setString(7, className);
		prep.setString(8, spec);
		prep.setString(9, build);
		prep.setString(10, version);

		/*prep.addBatch();

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);*/

		ResultSet rs = stat.executeQuery("select * from spell;");
		while (rs.next()) {
			System.out.println("name = " + rs.getString("spellId"));
			System.out.println("job = " + rs.getString("spellName"));
		}
		rs.close();
		conn.close();
	}

	public static void main(String[] args) throws Exception {

	}
}
