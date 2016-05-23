package pt2016.project2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Singleton pattern!!	
	
	// static reference to itself
	private static ConnectionFactory instance = new ConnectionFactory();

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	
	/** The url to database. */
	public static final String DBURL = "jdbc:mysql://localhost:3306/project2_2";

	/** The username for database-operations. */
	public static final String USER = "root";

	/** The password for database-operations. */
	public static final String PASS = "root";

	// private constructor
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
