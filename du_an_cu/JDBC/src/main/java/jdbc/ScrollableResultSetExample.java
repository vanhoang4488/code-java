package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetExample {

	public static void examScorll(Connection conn) throws SQLException, ClassNotFoundException {
		
		Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		String sql = "SELECT Emp_Id, Emp_No, Emp_Name FROM Employee";
		
		ResultSet rs = statement.executeQuery(sql);
		
		//Nhảy con trỏ tới cuối.
		boolean last = rs.last();
		
		System.out.println("last: " + last);
		
		if(last) {
			//ghi ra thông tin bản ghi cuối.
			System.out.printf("Emp_Id: %d\n", rs.getInt(1));
			System.out.printf("Emp_No: %s\n", rs.getString(2));
			System.out.printf("Emp_Name: %s\n", rs.getString(3));
		}
		
		System.out.println("----------------");
		
		//Nhảy con trỏ lùi lại một lần.
		boolean previous = rs.previous();
		System.out.println("Previous: " + previous);
		
		//Nhảy con trỏ lùi lại 2 lần.
		previous = rs.previous();
		System.out.println("Previous 2: " + previous);
		
		while(rs.next()) {
			//lấy dữ liệu cột 2.
			String empNo = rs.getString(2);
			//Rồi mới lấy dữ liệu cột 1.
			int empId = rs.getInt(1);
			
			String empName = rs.getString("Emp_Name");
			
			System.out.println("---------------");
			System.out.printf("Emp_Id: %d\n", empId);
			System.out.printf("Emp_No: %s\n", empNo);
			System.out.printf("Emp_Name: %s\n", empName);
			
		}
		
		//Đóng kết nối.
		conn.close();
		
	}
	
}
