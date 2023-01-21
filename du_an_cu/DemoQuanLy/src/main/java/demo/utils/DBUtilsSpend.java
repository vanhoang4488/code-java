package demo.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import demo.beans.ThongTin;

public class DBUtilsSpend {
      
	private DBUtilsSpend() {}
	
	public static boolean checkInsert(Connection conn, Date date, String msnv, String category, String purpose) throws SQLException {
		
		Date d = new java.sql.Date(date.getTime());
		
		String sql = "select MSNV from demo.tblchi where date = \'"
				   + d
				   + "\' and MSNV = \'"
				   + msnv
				   + "\'  and category = \'"
				   + category
				   + "\' and purpose = \'"
				   + purpose
				   + "\'";
		
	    Statement pstm = conn.createStatement();
		
        
        ResultSet rs = pstm.executeQuery(sql);
        
        String check = "";
		
        while(rs.next()) {
        	
        	check = rs.getString(1);
        }
        
        if(check.isEmpty()) return true;
        
        return false;
	}
	
	public static void insertTblChi(Connection conn, ThongTin tt) throws SQLException {
        String sql = "Insert into demo.tblchi(date, MSNV, empolyees, category, purpose, price) values (?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        Date date = new java.sql.Date(tt.getDate().getTime());
        pstm.setDate(1, date);
        pstm.setString(2, tt.getMsnv());
        pstm.setString(3, tt.getEmpolyees());
        pstm.setString(4, tt.getCategory());
        pstm.setString(5, tt.getPurpose());
        pstm.setInt(6, tt.getPrice());
 
        pstm.executeUpdate();
        
        DBUtils.updateEXSummary(conn);
    }
	
	public static void deleteTblChi(Connection conn, String word) throws SQLException {

		String sql = "delete from demo.tblchi where " + word;

		Statement state = conn.createStatement();
		
		state.executeUpdate(sql);
		
		DBUtils.updateEXSummary(conn);
	}
	
	public static ArrayList<ThongTin> querySpending(Connection conn, String chooseday1, String chooseday2, String word) 
			throws SQLException, ClassNotFoundException{
        ArrayList<ThongTin> list = new ArrayList<ThongTin>();
        
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
				            + "%\' or MSNV like \'%"
				            + word
				            + "%\' or empolyees like \'%"
				            + word
				            + "%\' or category like \'%"
				            + word 
				            + "%\' or purpose like \'%"
				            + word
				            + "%\' or price like \'%"
				            + so
				            + "%\') ";
			}catch(NumberFormatException ex) {
				
				sc = "and ( MSNV like \'%"
						+ word
						+ "%\' or empolyees like \'%"
			            + word
			            + "%\' or category like \'%"
			            + word 
			            + "%\' or purpose like \'%"
			            + word
			            + "%\' )";
			}
		}
		
		String sql ="select * from demo.tblchi where date between \'"
				   + chooseday1
				   +"\' and \'"
				   + chooseday2
				   + "\' "
				   + sc;
	  
        Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);   
		
		while(rs.next()) {
   	    	Date date = rs.getDate(1);
   	        String msnv = rs.getString(2);
   	    	String employees = rs.getString(3);
   	    	String catogory = rs.getString(4);
   	    	String purpose = rs.getString(5);
   	        int price = rs.getInt(6);
   	    	ThongTin tt = new ThongTin(date, msnv, employees, catogory, purpose, price);
   	    	list.add(tt);
   	    }
   	    
   	    return list;
		
	}
}
