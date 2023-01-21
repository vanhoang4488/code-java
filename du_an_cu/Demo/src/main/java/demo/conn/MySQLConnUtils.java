package demo.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException{
		
		String hostname = "localhost";
		String database = "datademo1";
		String userName = "root";
		String password = "";
		
		return getMySQLConnection(hostname, database, userName, password);	
	}
	
	
	private static Connection getMySQLConnection(String hostname, String database, String userName, String password) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dataPath = "jdbc:mysql://" + hostname + ":3306/" + database;
		
		Connection conn = DriverManager.getConnection(dataPath, userName, password);
		
		return conn;
	}
	
}
