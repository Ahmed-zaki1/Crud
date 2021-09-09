package util;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class ConnectionUtils {
	static Logger log = Logger.getLogger(ConnectionUtils.class.getName());
	static String DRIVER = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/mdbtesteight";
	static String USERNAME = "root";
	static String PASSWORD = "root";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {

			log.error(e);
		}
		return connection;

	}
}
