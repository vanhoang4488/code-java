package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDataExample {

	public static void exampleEmp(Connection conn) throws SQLException, ClassNotFoundException{
		
		//Tạo đối tượng Statement.
		Statement state = conn.createStatement();
		
		String sql = "Select Emp_Id, Emp_No, Emp_Name from Employee";
		
		//Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		ResultSet rs = state.executeQuery(sql);
		
		//Duyệt trên kết quả trả về.
		while(rs.next()) {//di chuyển con trỏ chuột xuống bản ghi kế tiếp.
			
			int empId = rs.getInt(1);
			String empNo = rs.getString(2);
			String empName = rs.getString("Emp_Name");
			
			System.out.println("----------------");
			System.out.printf("Emp_Id: %d\n", empId);
			System.out.printf("Emp_No: %s\n", empNo);
			System.out.printf("Emp_Name: %s\n", empName);
		}
		
		conn.close();
	}
}
