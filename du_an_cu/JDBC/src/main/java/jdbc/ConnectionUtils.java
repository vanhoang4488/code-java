package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
			
		//Sử dụng MySQL.
		
		return MySQLConnUtils.getMySQLConnection();
		
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
	
		System.out.println("Get connection ...");
		
		//Lấy ra đối tượng Connection kết nối database.
		
		Connection conn = ConnectionUtils.getMyConnection();
		
		System.out.println("Get connection" + conn);
		
		System.out.println("Done");
		
//		System.out.println("In bảng Employee");
//		
//		QueryDataExample.exampleEmp(conn);
		
		System.out.println("In bảng Employee sử dụng TYPE_SCROLL_INSENSITIVE");
		ScrollableResultSetExample.examScorll(conn);
	}
	
}
