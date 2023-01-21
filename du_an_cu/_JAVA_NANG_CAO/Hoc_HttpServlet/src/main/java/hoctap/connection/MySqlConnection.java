package hoctap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public Connection getMySQLConnection() throws SQLException, ClassNotFoundException {
		
		String hostname = "localhost";
		String dataname = "carsaomai";
		String username = "root";
		String password = "";
		
		return getMySQLConnection(hostname, dataname, username, password);
	}
	
	public Connection getMySQLConnection(String hostname, String dataname, String username, String password) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://" + hostname + ":3306/" + dataname;
		
	    Connection connection = DriverManager.getConnection(url, username, password);
	    
	    return connection;
	}
}
