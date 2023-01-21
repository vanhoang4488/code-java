package demo.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException{
		
		return MySQLConnUtils.getMySQLConnection();
		
	}
	
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
