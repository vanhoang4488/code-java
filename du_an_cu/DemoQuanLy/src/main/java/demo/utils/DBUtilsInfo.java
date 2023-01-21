package demo.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import demo.beans.UserFamily;
import demo.beans.UserInfo;

public class DBUtilsInfo {
     
	
	public static UserInfo getInfo(Connection conn, String ms) throws SQLException{
		
		String sql = "select * from demo.usersinfo where msnv = \'" + ms +"\'";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		UserInfo info = null;
		
		while(rs.next()) {
			String msnv = rs.getString(1);
			Date birthday = rs.getDate(2);
			String gender = rs.getString(3);
			String numberPhone = rs.getString(4);
			String nationality = rs.getString(5);
			String nation = rs.getString(6);
			String religion = rs.getString(7);
			String cmnd = rs.getString(8);
			Date range = rs.getDate(9);
			String issued = rs.getString(10);
			
			String address1 = rs.getString(11);			
			String[] info1 = address1.split("-");
		    String oldcountry = info1[3];
		    String oldcity = info1[2];
		    String oldjet  = info1[1];
		    String oldward = info1[0];
			
			String address2 = rs.getString(12);
			String[] info2 = address2.split("-");
		    String newcountry = info2[3];
		    String newcity = info2[2];
		    String newjet  = info2[1];
		    String newward = info2[0];
			
		info = new UserInfo(msnv, birthday, gender, numberPhone, 
					                           nationality, nation, religion, cmnd,
					                           range, issued, oldcountry, oldcity, 
					                           oldjet, oldward, newcountry, newcity, newjet, newward);
			
			
		}
		
		
		return info;
	}
	
	
	public static UserFamily getFamily(Connection conn, String ms) throws SQLException{
		
       String sql = "select * from demo.usersfamily where msnv = \'" + ms +"\'";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		UserFamily family = null;
		
		
		while(rs.next()) {
					
			
			String msnv = rs.getString(1);
			String userFamily = rs.getString(2);
			String birthdayFamily = rs.getString(3);
			String jobFamily = rs.getString(4);
			String phoneFamily = rs.getString(5);
			String child = rs.getString(6);
			
			family = new UserFamily(msnv, userFamily, birthdayFamily, jobFamily, phoneFamily, child);
		
		}
		
       return family;
	}
}
