package hoctap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hoctap.utils.ExecuteQuery;
import hoctap.utils.ModuleQuery;

@WebServlet("/registration")
public class Registration extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		//Kiểm tra các thông tin nhập vào có chính xác không.
		boolean check = true;
		
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String birthdayStr = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phoneStr = request.getParameter("phone");
		long salary = Long.parseLong( request.getParameter("salary") );
		
		
		//Kiểm tra thông tin username, ít nhất 8, tối đa 50 ký tự và không chứa ký tự đặc biệt và dấu cách.
		String usernamePattern = "\\w{8,50}";
		check = username.matches(usernamePattern);
		if(!check) {
			request.setAttribute("notice", "Tên đăng nhập phải chứa ít nhất 10 ký tự, "
					+ "tối đa 50 ký tự và không có ký tự đặc biệt và dấu cách.");
			this.getAgainArrtibute(request, username, firstName, lastName, birthdayStr, gender, city, address, email, phoneStr, salary);
			forward(request, response);
			return;
		}
		
		Connection conn = ModuleQuery.getInstance().getConnection(request);
		ExecuteQuery execute = ExecuteQuery.getInstance();
		
		try {
			
			//tài khoản đã tồn tại
			if( !execute.findUsername(conn, username) ) {
				request.setAttribute("notice", "Tên tài khoản người dùng đã tồn tại.");
				this.getAgainArrtibute(request, username, firstName, lastName, birthdayStr, gender, city, address, email, phoneStr, salary);
				forward(request, response);
				return;
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		//Kiểm tra thông tin mật khẩu, ít nhất 8, tối đa 16 ký tự và không chứa ký tự đặc biệt.
		String password = request.getParameter("password");
		String passwordPattern = "\\w{8,16}";
		check = password.matches(passwordPattern);
		if(!check) {
			request.setAttribute("notice", "Mật khẩu phải chứa ít nhất 8 ký tự, "
					+ "tối đa 16 ký tự và không có ký tự đặc biệt và dấu cách.");
			this.getAgainArrtibute(request, username, firstName, lastName, birthdayStr, gender, city, address, email, phoneStr, salary);
			forward(request, response);
			return;
		}
		else {
			String rePassword = request.getParameter("rePassword");
			
			if(!password.equals(rePassword)) {
				request.setAttribute("notice", "Mật khẩu không khớp với nhau!");
				this.getAgainArrtibute(request, username, firstName, lastName, birthdayStr, gender, city, address, email, phoneStr, salary);
				forward(request, response);
				return;
			}
		}
		
		//Xử lý thông tin ngày sinh
		int age = 0;
		try {
			Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(birthday);
			
			//ngày hiện tại.
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(new Date());
			
			//tính tuổi theo âm lịch nhé, nghĩa là tròn 1 năm đến ngày sinh mới tính là thêm 1 tuổi.
			age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
			
			if( (cal2.get(Calendar.MONTH) < cal1.get(Calendar.MONTH)) ||
				( (cal2.get(Calendar.MONTH) == cal1.get(Calendar.MONTH) && cal2.get(Calendar.DATE) < cal1.get(Calendar.DATE) ) )	) {
				
				age--;
			}
			
			if(age < 0) {
				
				request.setAttribute("notice", "Ngày tháng không hợp lệ");
				this.getAgainArrtibute(request, username, firstName, lastName, birthdayStr, gender, city, address, email, phoneStr, salary);
				forward(request, response);
				return;
			}
 		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Xử lý thông tin giới tính.
		if(gender.equals("nam")) gender = "Nam";
		else if(gender.equals("nu")) gender = "Nữ";
		else gender = "Không xác định";
		
		/*
		 * Xử lý đồng thời thông tin địa chỉ và tên thành phố, tên thành phố phải trùng với tên thành phố trong address.
		 */
		String addressPattern = "(\\p{L}+\\s*)+-(\\s*\\p{L}+\\s*)+";
		check = address.matches(addressPattern);
		if(!check) {
			request.setAttribute("notice", "Hãy điền thông tin địa chỉ đúng theo mẫu sau: "
					+ "Xã/Phường - Quận/Huyện");
			this.getAgainArrtibute(request, username, firstName, lastName, birthdayStr, gender, city, address, email, phoneStr, salary);
			forward(request, response);
			return;
		}
		
		
		/*
		 * Xử lý thông tin mã pin của người dùng.
		 */
		int pin = Integer.parseInt( request.getParameter("pin") );
		      
		/*
		 * Xử lý thông tin email.
		 */
		
		
		/*
		 * Xử lý thông tin số điện thoại.
		 */
		String phonePattern = "[0]?[1-9]\\d{8}";
		check = phoneStr.matches(phonePattern);
		if(!check) {
			request.setAttribute("notice", "Số điện thoại không hợp lệ!");
			this.getAgainArrtibute(request, username, firstName, lastName, birthdayStr, gender, city, address, email, phoneStr, salary);
			forward(request, response);
			return;
		}
		int phone = Integer.parseInt(phoneStr);
		/*
		 * Xử lý thông tin salary.
		 */

		try {
			execute.insertLogin(conn, username, password);
			execute.inserMember(conn, firstName, lastName, age, gender, city, address, pin, email, phone, salary, username);
		} catch (SQLException e) {
			
			response.sendRedirect(request.getContextPath() + "/notiError");
			
			throw new ServletException();
		}
		
		response.sendRedirect(request.getContextPath() + "/login");
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
		
		dispatcher.forward(request, response);
	}
	
	//Gửi lại thông tin lên request.
	private void getAgainArrtibute(HttpServletRequest request, String username, String firstName, String lastName, String birthday, String gender, 
			String city, String address, String email, String phone, long salary) {
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("username", username);
		request.setAttribute("birthday", birthday);
		request.setAttribute("gender", gender);
		request.setAttribute("city", city);
		request.setAttribute("address", address);
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		request.setAttribute("salary", salary);
	}
}
