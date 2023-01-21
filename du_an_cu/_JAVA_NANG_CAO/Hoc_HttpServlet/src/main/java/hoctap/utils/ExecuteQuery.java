package hoctap.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hoctap.beans.Car;
import hoctap.beans.User;
import hoctap.beans.UserLogin;

public class ExecuteQuery {

	private volatile static ExecuteQuery instance;

	private ExecuteQuery() {
	}

	public static ExecuteQuery getInstance() {
		if (instance == null) {
			synchronized (ExecuteQuery.class) {
				if (instance == null)
					instance = new ExecuteQuery();
			}
		}

		return instance;
	}

	// tìm kiếm Username đã tồn tại hay chưa?
	public boolean findUsername(Connection conn, String username) throws SQLException {

		String sql = "SELECT LogName FROM login WHERE LogName = ?";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setString(1, username);

		ResultSet rs = state.executeQuery();

		if (rs.next())
			return false;

		return true;
	}

	// tìm kiếm thông tin đăng nhập user.
	public boolean findUserLogin(Connection conn, UserLogin user) throws SQLException {

		String sql = "SELECT LogName, Password FROM login WHERE LogName = ?";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setString(1, user.getUsername());

		ResultSet rs = state.executeQuery();

		if (rs.next()) {

			String username = rs.getString(1);

			String password = rs.getString(2);

			if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
				return true;
		}

		return false;
	}

	// Xem chi tiết thông tin user.
	public User getUserDetail(Connection conn, String logName) throws SQLException, ParseException {

		String query = "Select * from members " + "where MemberID = (select MemberID from login where LogName = ?)";

		PreparedStatement state = conn.prepareStatement(query);

		state.setString(1, logName);

		ResultSet rs = state.executeQuery();

		if (rs.next()) {
			String memberID = rs.getString(2);
			String firstName = rs.getString(3);
			String lastName = rs.getString(4);
			int age = rs.getInt(5);
			String gender = rs.getString(6);
			String address = rs.getString(7);
			String city = rs.getString(8);
			int pin = rs.getInt(9);
			String email = rs.getString(10);
			int phone = rs.getInt(11);
			long salary = rs.getLong(12);

			String dateStr = rs.getString(13);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(dateStr);

			return new User(memberID, firstName, lastName, age, gender, address, city, pin, email, phone, salary, date);
		}

		return null;
	}

	// Chèn thêm thông tin đăng nhập người dùng.
	public void insertLogin(Connection conn, String username, String password) throws SQLException {

		String sql = "INSERT INTO login (LogName, Password, MemberID) "
				+ "SELECT ?, ?, CONCAT(\"CMI\", COUNT(MemberID)+1) " + "FROM  login";

		PreparedStatement state = conn.prepareStatement(sql);

		state.setString(1, username);
		state.setString(2, password);

		state.executeUpdate();
	}

	// chèn thêm thông tin người dùng.
	public void inserMember(Connection conn, String firstName, String lastName, int age, String gender, String city,
			String address, int pin, String email, int phone, long salary, String logName) throws SQLException {
		String sql = "INSERT INTO members (MemberID, FirstName, LastName, Age, Gender, Address, City, Pin, Email, Phone, Salary)\n"
				+ "SELECT " + "MemberID, " + "?,?,?,?,?,?,?,?,?,? " + "FROM login" + "WHERE LogName=?";

		PreparedStatement state = conn.prepareStatement(sql);

		/*
		 * Thông tin MemberID sẽ được xử lý dưới database theo Trigger.
		 */

		state.setString(1, firstName);
		state.setString(2, lastName);
		state.setInt(3, age);
		state.setString(4, gender);
		state.setString(5, address);
		state.setString(6, city);
		state.setInt(7, pin);
		state.setString(8, email);
		state.setInt(9, phone);
		state.setLong(10, salary);
		state.setString(11, logName);

		state.executeUpdate();
	}
	
	//lấy danh sách xe hơi để hiển thị.
	public List<Car> getCarsList(Connection conn) throws SQLException{
		
		String sql = "SELECT CarID, CarName, Rate, Description, Price, Quantily, ImageUrl FROM cars";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		if(!rs.next()) return null;
		
		List<Car> carsList = new ArrayList<>();
		
		do {
			
			String carID = rs.getString(1);
			String carName = rs.getString(2);
			double rate = rs.getDouble(3);
			String description = rs.getString(4);
			int price = rs.getInt(5);
			int quantily = rs.getInt(6);
			String imageUrl = rs.getString(7);
			
			Car car = new Car(carID, carName, rate, description, price, quantily, imageUrl);
			
			carsList.add(car);
		}while(rs.next());
		
		return carsList;
	}
	
	//Hiển thị thông tin chi tiết về 1 chiêc ô tô.
	public Car getCarDetail(Connection conn, String carID) throws SQLException{
		
		String sql = "SELECT CarName, Rate, Description, Price, Quantily, ImageUrl FROM cars WHERE CarID = \"" + carID +"\"";
		
		Statement state = conn.createStatement();
		
		ResultSet rs = state.executeQuery(sql);
		
		if(rs.next()) return new Car(carID, rs.getString(1), rs.getInt(2), rs.getString(3),
				rs.getInt(4), rs.getInt(5), rs.getString(6));
		
		return null;
	}
	
	//thay đổi hình ảnh minh họa ô tô
	public void setImageUrl(Connection conn, String imageUrl, String carID) throws SQLException {
		
		String sql = "UPDATE cars SET ImageUrl = ? WHERE CarID = ?";
		
		PreparedStatement state = conn.prepareStatement(sql);
		
		state.setString(1, imageUrl);
		state.setString(2, carID);
		
		state.executeUpdate();
	}
	
}
