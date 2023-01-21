package demo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.beans.Product;
import demo.beans.UserAccount;

public class DBUtils {
	
	public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException{
		String sql = "SELECT Gender FROM User_Account "
				+ "WHERE User_Name = ? and Password = ?;";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		
	    ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setGender(gender);
			user.setPassword(password);
			return user;
		}
		
		return null;
	}
	
	public static UserAccount findUser(Connection conn, String userName) throws SQLException{
		String sql = "SELECT Password, Gender FROM User_Account"
				+ "WHERE User_Name = ? ";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		
	    ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String gender = rs.getString("Gender");
			String password = rs.getString("password");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setGender(gender);
			user.setPassword(password);
			return user;
		}
		
		return null;
	}
	
	
	public static List<Product> queryProduct(Connection conn) throws SQLException{
		String sql = "SELECT Code, Name, Price FROM Product";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		
		List<Product> list = new ArrayList<Product>();
		
		while(rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			list.add(product);
		}
		
		return list;
	}
	
	public static Product findProduct(Connection conn, String code) throws SQLException{
		String sql = "SELECT Code, Name, Price FROM Product"
				+ "WHERE Code = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			return product;
		}
		
		return null;
	}
	
	public static void updateProduct(Connection conn, Product product) throws SQLException{
		
		String sql = "UPDATE Product"
				+ "SET Name = ?, Price = ?"
				+ "WHERE Code = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		
		pstm.executeUpdate();
		
	}
	
	public static void insertProduct(Connection conn, Product product) throws SQLException {
		
		String sql = "INSERT INTO product(Code, Name, Price) VALUES (?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());
		
		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}
	
}