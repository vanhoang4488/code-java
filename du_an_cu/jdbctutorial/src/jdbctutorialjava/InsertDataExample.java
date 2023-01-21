package jdbctutorialjava;

import java.sql.Connection;
import java.sql.Statement;

public class InsertDataExample {
      public void insertDL() {
    	  try {
    		// Lấy ra kết nối tới cơ sở dữ liệu.
    	      Connection connection = ConnectionUtils.getMyConnection();
    	 
    	      Statement statement = connection.createStatement();
    	 
    	      String sql = "Insert into payments(customerNumber, checkNumber, paymentDate, amount) "
    	              + " values (101, 'HA071099', '2019-04-24', 345.55) ";
    	 
    	      // Thực thi câu lệnh.
    	      // executeUpdate(String) sử dụng cho các loại lệnh Insert,Update,Delete.
    	      int rowCount = statement.executeUpdate(sql);
    	 
    	      // In ra số dòng được trèn vào bởi câu lệnh trên.
    	      System.out.println("Row Count affected = " + rowCount);
    	  }catch(Exception ex) {
    		  ex.printStackTrace();
    	  }
      }
}
