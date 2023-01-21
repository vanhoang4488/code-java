package demo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import demo.beans.UserAccount;

public class DBUtilsAccount {

  public static void insertEmployee(Connection conn, UserAccount acc) throws SQLException {
		
		String sql = "insert into demo.usersaccount(msnv, password, userName, office, email, salary, image) value (?,?,?,?,?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, acc.getMsnv());
		pstm.setString(2, acc.getPass());
		pstm.setString(3, acc.getUserName());
		pstm.setString(4, acc.getOffice());
		pstm.setString(5, acc.getEmail());
		pstm.setInt(6, acc.getSalary());
		pstm.setString(7, acc.getImageData());
		
		
		pstm.executeUpdate();
		
	}
	
	public static void deleteEmployee(Connection conn, String result) throws SQLException {
		
		String sql = "delete from demo.usersaccount where " + result;

		Statement state = conn.createStatement();
		
		state.executeUpdate(sql);
		
	}
		 
	public static void updateEmployee(Connection conn, UserAccount acc, String oldmsnv) throws SQLException {
		 
		String sql = "update demo.usersaccount " 
				   + "set msnv = \'"
				   + acc.getMsnv()
				   + "\',  userName = \'"
				   + acc.getUserName()
				   + "\' , office = \'"
				   + acc.getOffice() 
				   +"\', email= \'"
				   + acc.getEmail()
				   + "\', salary = "
				   + acc.getSalary()
				   + "  where msnv = \'"
				   + oldmsnv
				   + "\'";
		
		Statement state = conn.createStatement();
		
		state.executeUpdate(sql);
		
	}
	
   public static boolean checkInfo(Connection conn, String msnv) throws SQLException {
		
		String sql = "select msnv from demo.usersaccount where msnv = \'" + msnv + "\' ";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		String ms = null;
		
		while(rs.next())
			ms = rs.getString(1);
		
		if(ms == null) return true;
		
		return false;
	}
   
   
   public static UserAccount checkInfo(Connection conn, String ms, String pass) throws SQLException {
		
		String sql = "select password, office, userName from demo.usersaccount where msnv = \'"
				   + ms
				   + "\' and password = \'"
				   + pass
				   + "\'";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		UserAccount acc = new UserAccount();
		
	    while(rs.next()) {

	    	String password = rs.getString(1);
	    	String office = rs.getString(2);
	    	String userName = rs.getString(3);
	    	
	    	acc.setMsnv(ms);;
	    	acc.setPass(password);
	    	acc.setOffice(office);
	        acc.setUserName(userName);  

	    }
	    
		return acc;
	}
   
   public static String checkEmail(Connection conn, String msnv) throws SQLException {
		
		String sql = "select email from demo.usersaccount where msnv = \'" + msnv + "\'";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		String email = "";
		
		while(rs.next()) {
			email = rs.getString(1);
		}
		
		return email;
	}
	
   
   public static void newPassword(Connection conn, String msnv, String pass) throws SQLException {
		
		String sql = "update demo.usersaccount"
				   + " set password = \'"
				   + pass
				   + "\'"
				   + " where msnv = \'"
				   + msnv
				   + "\'";
		
		Statement state = conn.createStatement();
		
		state.executeUpdate(sql);
	}
   
   public static UserAccount findUser(Connection conn, String msnv) throws SQLException {
		
		String sql = " select password, office from demo.usersaccount where msnv = \'" + msnv + "\'";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		UserAccount acc = new UserAccount();
		
		while(rs.next()) {
			String pass = rs.getString(1);
			String office = rs.getString(2);
			
			acc.setMsnv(msnv);
			acc.setPass(pass);
			acc.setOffice(office);
		}
		
		return acc;
	}
   
   public static ArrayList<UserAccount> getListAccount(Connection conn) throws SQLException{
		
		String sql = "select msnv, userName, office, email, salary, image from demo.usersaccount" ;
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		 
		ArrayList<UserAccount> list = new ArrayList<UserAccount>();     
		
       while(rs.next()) {
	    	
	    	String msnv = rs.getString(1);
	    	String name = rs.getString(2);
	    	String office = rs.getString(3);
	    	String email = rs.getString(4);
  	
	    	int salary = rs.getInt(5);
	    	String imageData = rs.getString(6);

	    	
	    	UserAccount acc = new  UserAccount(msnv, name, office, email, salary, imageData);
	    	
	    	list.add(acc);
	    	
	    }
	    
	    return list;
		
	}
   
   public static UserAccount getAccount(Connection conn, String ms) throws SQLException{
		
		String sql = "select msnv, userName, office, email, salary, image from demo.usersaccount where msnv = \'" + ms + "\'";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		 
		UserAccount acc = new UserAccount();
		
        while(rs.next()) {
	    	
	    	String msnv = rs.getString(1);
	    	String name = rs.getString(2);
	    	String office = rs.getString(3);
	    	String email = rs.getString(4);
	    	int salary = rs.getInt(5);
	    	
	    	String imageData = rs.getString(6);
	    	
	       acc = new  UserAccount(msnv, name, office, email, salary, imageData);
	    	
	    	
	    }
	    
	    return acc;
		
	}
   
}
