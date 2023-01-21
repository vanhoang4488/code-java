package jdbctutorialjava;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	 
	  public static Connection getMyConnection() throws SQLException,
	          ClassNotFoundException {
	      // Sử dụng Oracle.
	      // Bạn có thể thay thế bởi Database nào đó.
	      return MySQLConnUtils.getMySQLConnection();
	  }
	 
	  //
	  // Test Connection ...
	  //
	  public static void main(String[] args) throws SQLException,
	          ClassNotFoundException {
	 
	      System.out.println("Get connection ... ");
	 
	      //QueryDataExample querydata = new  QueryDataExample();
	      //querydata.layDuLieu();
	      
	      InsertDataExample insertdata = new InsertDataExample();
	      insertdata.insertDL();
	  }
	 
	}
