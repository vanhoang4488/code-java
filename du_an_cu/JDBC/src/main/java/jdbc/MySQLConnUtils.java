package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

	// Kết nối vào MySQL
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		
		String hostName = "localhost";
		
		String dbName = "simplehr";
		String userName = "root";
		String password = "";
		
		return getMySQLConnection(hostName, dbName, userName, password);
		
	}
	
	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException{
		
		//Cấu trúc URL Connection dành cho Oracle.
		//Ví dụ: jdbc:mysql:localhost: 3306/simlehr.
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
	
		return conn;
	}
	
}
