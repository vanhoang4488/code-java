package shopgiay.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopgiay.beans.Item;
import shopgiay.database.DBConnect;

public class CheckUtils {
     
	
	public static Item checkProduct(String id, int size, int amount) {
		Item item = null;
		
		Connection cons = DBConnect.getConnection();
        String sql = "SELECT p.productName, (p.price - p.price*p.sale/100) as price2  \r\n" + 
        		"from product p\r\n" + 
        		"join product_size o on o.productID = p.productID\r\n" + 
        		"where p.productID = '" + id + "' and o.size = " + size + " and o.amount >= " + amount ;
       
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String name = rs.getString("productName");
            int price = rs.getInt("price2");
            if(name != null && name != "" && price != 0) {
            	item = new Item(id, name, price, size, amount);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return item;
        }
        return item;
	}
	
	public static boolean checkQuantity(String id, int size, int quantity) {
		boolean check = false;
		
		Connection cons = DBConnect.getConnection();
        String sql = "SELECT if(p.amount >= " + quantity + ",1,0) as audit  \r\n" + 
        		"FROM `product_size` p\r\n" + 
        		"where p.productID = '" + id + "' and p.size = " + size;
       
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if(rs.getInt("audit") == 1) {
            	check = true;
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return check;
	}
}
