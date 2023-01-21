package hoctap.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
	
	//quản lý kết nối với loại database nào.
	public static Connection getConnection(String databaseType) throws SQLException, ClassNotFoundException{
		
		if(databaseType.equals("mysql"))  return new MySqlConnection().getMySQLConnection();
		
		return null;
	}
	
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
