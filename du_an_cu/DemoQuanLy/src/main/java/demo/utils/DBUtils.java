package demo.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import demo.beans.Income;
import demo.beans.Pair;
import demo.beans.Summary;

public class DBUtils {
	
	private DBUtils() {
		
	}
	
	public static String localDate() {
        int intmonth = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) +1;
		
	    int intyear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
			
	    String month = String.valueOf(intyear) + "-0" + String.valueOf(intmonth);
	    
	    return month;
	}
	
	//vẽ biểu đồ chi
	public static ArrayList<Pair> veBD(Connection conn, String date1, String date2) 
			throws SQLException, ClassNotFoundException{
	     
	   ArrayList<Pair> list = new ArrayList<Pair>();
	   
	   String sql = "select category, sum(price) "
	   		        + "from demo.tblchi "
	   		        + "where date between \'"
	   		        + date1
	   		        +"\' and \'"
	   		        + date2
			        + "\' group by category";
	   Statement state = conn.createStatement();
	   
	   ResultSet rs = state.executeQuery(sql);
	   
	   while(rs.next()) {
  	    	String key = rs.getString(1);
  	        int value = rs.getInt(2);
  	    	Pair tt = new Pair(key, value);
  	    	list.add(tt);
  	    }
	   
  	   
	   return list;
	}
	
	//vẽ biểu đồ thu
	public static ArrayList<Pair> veBD2(Connection conn, String date1, String date2) 
			throws SQLException, ClassNotFoundException{
	     
	   ArrayList<Pair> list = new ArrayList<Pair>();
	   
	   String sql = "select category, sum(price) "
	   		        + "from demo.tblthu "
	   		        + "where date between \'"
	   		        + date1
	   		        +"\' and \'"
	   		        + date2
			        + "\' group by category";
	   Statement state = conn.createStatement();
	   
	   ResultSet rs = state.executeQuery(sql);
	   
	   while(rs.next()) {
  	    	String key = rs.getString(1);
  	        int value = rs.getInt(2);
  	    	Pair tt = new Pair(key, value);
  	    	list.add(tt);
  	    }
	   
  	   
	   return list;
	}
	
	// vẽ biểu đồ xu hướng
	public static ArrayList<Income> veBD3(Connection conn, String date1, String date2) 
			throws SQLException, ClassNotFoundException{
	     
		   ArrayList<Income> list = new ArrayList<Income>();
		   
		   String sql = "select substring(p.date, 1 , 7) , sum(p.price), sum(o.price) " 
		   		       + "from demo.tblchi p " 
		   		       + "inner join demo.tblthu o on substring(p.date, 1 , 7) = substring(o.date, 1 , 7)" 
		   		       + "where p.date between \'"
		   		       + date1
		   		       + "\' and \'"
		   		       + date2
		   		       + "\' "  
		   		       + "group by substring(p.date, 1 , 7)";
		   
		   
		   Statement state = conn.createStatement();
		   
		   ResultSet rs = state.executeQuery(sql);
		   
		   
		   while(rs.next()) {
	  	    	String month = rs.getString(1);
	  	        int totalex = rs.getInt(2);
	  	        int totalre = rs.getInt(3);
	  	        int netincome = totalre - totalex;
	  	    	Income tt = new Income(month, totalex, totalre, netincome);
	  	    	
	  	    	list.add(tt);
		   }
		   
		   return list;
	}
	
	public static Summary getSummary(Connection conn) throws SQLException{
		
		int intmonth = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) +1;
		
		int intyear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		
		String month =  String.valueOf(intmonth);
		
		if(intmonth < 10) month = "0" + month;
		
        month = String.valueOf(intyear) + "-" + month;
        
		String lastmonth = "";
		
		if(intmonth == 1) {
			
		   lastmonth = String.valueOf(intyear - 1) +"-12" ;	
		}else {
		   
			if(intmonth  > 10)			
		        lastmonth = String.valueOf(intyear) + "-" + String.valueOf(intmonth - 1);
			else
				lastmonth = String.valueOf(intyear) + "-0" + String.valueOf(intmonth - 1);
		
		}	
	
		Statement state = conn.createStatement();
		
		//tránh trường hợp lastmonth không tồn tại trong database, ta sẽ thêm vào database ngay từ đầu một dòng
		
		String sql1 = "Insert into demo.summary "
				      + "value(\'"
				      + month
				      + "\', 0, 0, (select (p.totalRe - p.totalEx + p.initBalance) from demo.summary p where p.Month = \'"
				      + lastmonth
				      + "\')) "
				      + "ON DUPLICATE KEY UPDATE Month = "
				      + "\'"
				      + month
				      + "\'";
			
		String sql2 = "Select totalEX, totalRe, initbalance from demo.summary where Month = \'" + month +"\'";
		
		state.executeUpdate(sql1);
		
		ResultSet rs = state.executeQuery(sql2);
		
		rs.next();
	    int totalEx = rs.getInt(1);
	    int totalRe = rs.getInt(2);
	    int initbalance = rs.getInt(3);
		Summary sum = new Summary(totalEx, totalRe, initbalance);
		
		return sum;
	}
	
	
	public static void updateEXSummary(Connection conn) throws SQLException { 
       
		String month = localDate();
        
        String sql = "update demo.summary " 
        		      + "set totalEx = (select if(sum(price) is null, 0, sum(price)) from demo.tblchi where date >= \'"
        		      + month
        		      + "-01\') " 
        		      + "where Month = \'"
        		      + month
        		      + "\'";
        Statement state = conn.createStatement();
        state.executeUpdate(sql);
	}
	
	public static void updateRESummary(Connection conn) throws SQLException { 
	       
		String month = localDate();
        
        String sql = "update demo.summary " 
        		      + "set totalRe = (select if(sum(price) is null, 0, sum(price)) from demo.tblthu where date >= \'"
        		      + month
        		      + "-01\') " 
        		      + "where Month = \'"
        		      + month
        		      + "\'";
        Statement state = conn.createStatement();
        
        state.executeUpdate(sql);
	}
	
	
	public static File getFolderUpload() {
	    File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
	    if (!folderUpload.exists()) {
	      folderUpload.mkdirs();
	    }
	    return folderUpload;
	}
	
} 
