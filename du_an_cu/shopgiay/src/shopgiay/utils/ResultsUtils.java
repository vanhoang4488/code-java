package shopgiay.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import shopgiay.beans.Category;
import shopgiay.beans.Product;
import shopgiay.database.DBConnect;

public class ResultsUtils {
    
	public static ArrayList<Category> getListCategory() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM category";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
                list.add(category);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	
	public static ArrayList<Product> getProduct(){
		Connection cons = DBConnect.getConnection();
		String sql = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			sql = "select p.productID, productName, price, sale, (select GROUP_CONCAT(o.image) from product_image o where o.productID = p.productID) as image\r\n" + 
					"from product p";
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pr = new Product();
				pr.setProductID(rs.getString("productID"));
				pr.setProductName(rs.getString("productName"));
				pr.setPrice(rs.getInt("price"));
				pr.setSale(rs.getInt("sale"));
				String[] image = rs.getString("image").split(",");
				pr.setImage(image);
				list.add(pr);
			}
		cons.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;	
	}
	
	
	//phương thức lọc các sản phẩm
	public static ArrayList<Product> getProductCategory(){
		Connection cons = DBConnect.getConnection();
		String sql = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			sql = "select p.productID, productName, price, sale, (select GROUP_CONCAT(o.image) from product_image o where o.productID = p.productID) as image\r\n" + 
					"from product p";
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pr = new Product();
				pr.setProductID(rs.getString("productID"));
				pr.setProductName(rs.getString("productName"));
				pr.setPrice(rs.getInt("price"));
				pr.setSale(rs.getInt("sale"));
				String[] image = rs.getString("image").split(",");
				pr.setImage(image);
				list.add(pr);
			}
		cons.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;	
	}
	
	
	//top sản phẩm mới nhất
	public static ArrayList<Product> getNewProduct(){
		Connection cons = DBConnect.getConnection();
		String sql = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			sql = "select p.productID, productName, price, sale, (select GROUP_CONCAT(o.image) from product_image o where o.productID = p.productID) as image\r\n" + 
					"from product p\r\n"
					+ "Order by lastUpdate DESC\r\n"
					+ "limit 8";
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pr = new Product();
				pr.setProductID(rs.getString("productID"));
				pr.setProductName(rs.getString("productName"));
				pr.setPrice(rs.getInt("price"));
				pr.setSale(rs.getInt("sale"));
				String[] image = rs.getString("image").split(",");
				pr.setImage(image);
				list.add(pr);
			}
		cons.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;	
	}
	
	//top sản phẩm bán chạy nhất
	public static ArrayList<Product> getProducts(){
		Connection cons = DBConnect.getConnection();
		String sql = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			sql = "SELECT p.productID, productName, price, sale,\r\n" + 
					"(select GROUP_CONCAT(o.image) from product_image o where o.productID = p.productID) as image\r\n" + 
					"from product p \r\n" + 
					"join (\r\n" + 
					"SELECT productID from orderdetails \r\n" + 
					"group by productID\r\n" + 
					"order by SUM(quantityOrdered) DESC \r\n" + 
					"limit 8\r\n" + 
					") r on p.productID = r.productID";
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product pr = new Product();
				pr.setProductID(rs.getString("productID"));
				pr.setProductName(rs.getString("productName"));
				pr.setPrice(rs.getInt("price"));
				pr.setSale(rs.getInt("sale"));
				String[] image = rs.getString("image").split(",");
				pr.setImage(image);
				list.add(pr);
			}
			cons.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	
	//thông tin chi tiết sản phẩm
	public static Product getProductDetails(String id){
		Connection cons = null;
	    Product pr = new Product();
	    try {
	    	cons = DBConnect.getConnection();
	    	Statement stmt = cons.createStatement();
	    	String sql1= "select productID, productName, description, price, sale from product where productID = '" + id +"'";
	    	ResultSet rs = stmt.executeQuery(sql1);
	    	rs.next();
	    	pr.setProductID(rs.getString("productID"));
	    	pr.setProductName(rs.getString("productName"));
	    	pr.setDescription(rs.getString("description"));
	    	pr.setPrice(rs.getInt("price"));
	    	pr.setSale(rs.getInt("sale"));
	    	
	    	String sql2 = "select group_concat(image) as image from product_image where productID = '" + id + "'";
	    	rs = stmt.executeQuery(sql2);
	    	rs.next();
	    	String[] image = rs.getString("image").split(",");
	    	pr.setImage(image);
	    	
	    	
	    	String sql3 = "select group_concat(size) as size from product_size where productID = '" + id +"'";
	        rs = stmt.executeQuery(sql3);
	        rs.next();
	        String[] size = rs.getString("size").split(",");
	        pr.setSize(size);
	        
	        cons.close();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return pr;
	}
	
	
	//sản phẩm cùng loại và sản phẩm - 150000 < giá cả < sản phẩm + 100000 
	public static ArrayList<Product> getProductRelated(String id, int gia){
		Connection cons = DBConnect.getConnection();
		ArrayList<Product> list = new ArrayList<Product>();
		int giaduoi = gia - 150000;
		int giatren = gia + 100000;
		try {
			String sql = "SELECT p.productID, p.productName, p.price, p.sale, \r\n" + 
					"(SELECT GROUP_CONCAT(image) from product_image where productID = p.productID) as image\r\n" + 
					"from product p\r\n" + 
					"where productID IN\r\n" + 
					"(select productID\r\n" + 
					"from product_category r\r\n" + 
					"where category_id in(SELECT category_id from product_category where productID = \"" + id+ "\")\r\n" + 
					") and price >=" + giaduoi + " and price <=" + giatren + "\r\n" + 
					"limit 5";
			PreparedStatement ps = cons.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product pr = new Product();
				pr.setProductID(rs.getString("productID"));
				pr.setProductName(rs.getString("productName"));
				pr.setPrice(rs.getInt("price"));
				pr.setSale(rs.getInt("sale"));
				String[] image = rs.getString("image").split(",");
				pr.setImage(image);
				list.add(pr);
			}
			cons.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int getQuantity(String id, int size) {
		Connection cons = DBConnect.getConnection();
		String sql = "Select amount from product_size where productID = '" + id + "' and size = " + size;
		try {
			Statement stmt = cons.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
		    int amount = rs.getInt("amount");
		    rs.close();
		    return amount;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
