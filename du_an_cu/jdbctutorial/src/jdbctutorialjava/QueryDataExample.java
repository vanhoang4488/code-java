package jdbctutorialjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryDataExample {
	
	public void layDuLieu() {
		try {
			Connection connection = ConnectionUtils.getMyConnection();
			
			System.out.println("Get connection " + connection);
			 
		      System.out.println("Done!");
			// Tạo đối tượng Statement.
		      Statement statement = connection.createStatement();
		 
		      String sql = "Select EmployeeNumber, firstName, lastName from Employees";
		 
		      // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		      ResultSet rs = statement.executeQuery(sql);
		 
		      // Duyệt trên kết quả trả về.
		      while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
		          int empId = rs.getInt(1);
		          String empNo = rs.getString(2);
		          String empName = rs.getString(3);
		          System.out.println("--------------------");
		          System.out.println("EmpId:" + empId);
		          System.out.println("EmpNo:" + empNo);
		          System.out.println("EmpName:" + empName);
		      }
		      // Đóng kết nối
		      connection.close();
		}catch(Exception ex) {
			
		}
	}

}
