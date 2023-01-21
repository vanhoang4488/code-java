package demo.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import demo.beans.Revenues;

public class DBUtilsCollection {
      
	private DBUtilsCollection() {}
	
	public static boolean checkInsert(Connection conn, Date date, String revenues) throws SQLException {
		
		Date d = new java.sql.Date(date.getTime());
		
		String sql = "select revenues from demo.tblthu where date = \'"
				   + d
				   + "\' and revenues = \'"
				   + revenues
				   + "\'" ;
		
	    Statement pstm = conn.createStatement();
		
       
        ResultSet rs = pstm.executeQuery(sql);
        
        String check = "";
		
        while(rs.next()) {
        	
        	check = rs.getString(1);
        }
        
        if(check.isEmpty()) return true;
        
        return false;
	}
	
	public static void insertTblThu(Connection conn, Revenues tt) throws SQLException {
        String sql = "Insert into demo.tblthu(date, revenues, category, purpose, price) values (?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        Date date = new java.sql.Date(tt.getDate().getTime());
        
        pstm.setDate(1, date);
        
        pstm.setString(2, tt.getRevenues());
        
        pstm.setString(3, tt.getCategory());
        
        pstm.setString(4, tt.getPurpose());
        
        pstm.setInt(5, tt.getPrice());
 
        pstm.executeUpdate();
        
        DBUtils.updateRESummary(conn);
    }
	
	public static void deleteTblThu(Connection conn, String word) throws SQLException {

		String sql = "delete from demo.tblthu where " + word;

		Statement state = conn.createStatement();
		
		state.executeUpdate(sql);
		
		DBUtils.updateRESummary(conn);
	}
	
	public static ArrayList<Revenues> queryCollection(Connection conn, String chooseday1, String chooseday2, String word) 
			throws SQLException, ClassNotFoundException{
        ArrayList<Revenues> list = new ArrayList<Revenues>();
        
		String sc = "";
		
		if(!word.isEmpty()) {
			try {
				int so = Integer.parseInt(word);
				
				sc = "and ( Year(date) like \'%"
				            + so 
				            + "%\' or Month(date) like \'%"
				            + so
				            + "%\' or Day(date) like \'%"
				            + so
				            + "%\' or revenues like \'%"
				            + word
				            + "%\' or category like \'%"
				            + word 
				            + "%\' or purpose like \'%"
				            + word
				            + "%\' or price like \'%"
				            + so
				            + "%\') ";
			}catch(NumberFormatException ex) {
				
				sc = "and ( revenues like \'%"
						+ word
			            + "%\' or category like \'%"
			            + word 
			            + "%\' or purpose like \'%"
			            + word
			            + "%\' )";
			}
		}
		
		String sql ="select * from demo.tblthu where date between \'"
				   + chooseday1
				   +"\' and \'"
				   + chooseday2
				   + "\' "
				   + sc;
		
        Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);   
		
		while(rs.next()) {
   	    	
			Date date = rs.getDate(1);
   	    	
   	        String revenues = rs.getString(2);
   	    	
   	        String catogory = rs.getString(3);
   	    	
   	        String purpose = rs.getString(4);
   	        
   	        int price = rs.getInt(5);
   	    	
   	        Revenues tt = new Revenues(date, revenues, catogory, purpose, price);
   	    	
   	        list.add(tt);
   	    }
   	    
   	    return list;
		
	}
}
