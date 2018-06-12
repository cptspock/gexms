package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class TestSQLite {
	/**
	 * Connect to a sample database
	 */
	public static void connect() {
		Connection conn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:/Users/212472312/sqlite/db/test.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

			String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n" + "	id integer PRIMARY KEY,\n"
					+ "	name text NOT NULL,\n" + "	capacity real\n" + ");";

			Statement stmt = conn.createStatement();
			// create a new table
			stmt.execute(sql);
			System.out.println("Table created.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		connect();
	}
}
