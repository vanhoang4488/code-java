package demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.beans.UserAccount;
import demo.utils.DBUtils;
import demo.utils.MyUtils;

@WebServlet(urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean  remember = "Y".equals(rememberMeStr);
		
		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;
		
		if(userName == null || password == null || userName.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Vui lòng điền thông tin tài khoản hoặc mật khẩu";
		}else {
			Connection conn = MyUtils.getStoreConnection(request);
			try {
				
				user = DBUtils.findUser(conn, userName, password);
				
				if(user == null) {
					hasError = true;
					errorString = "Thông tin tài khoản mật khẩu không chính xác";
				}
				
				
			}catch(SQLException ex) {
				ex.printStackTrace();
				hasError = true;
				errorString = ex.getMessage();
			}
		}
		
		//Trong trường hợp có lỗi.
		//Chuyển hướng tới WEB-INF/views/login.jsp.
		if(hasError) {
			user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			
			//lưu các thông tin vào thuộc tính request trước khi chuyển tiếp.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			//Chuyển tiếp tới trang /WEB-INF/views/login.jsp.
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(request, response);
		}
		//Trong trường hợp không có lỗi.
		//lưu thông tin người dùng vào Session.
		//Và chuyển hướng sang trang userInfo.
		else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, user);
			
			//Nếu người dùng chọn tính năng "Remember me".
			if(remember) {
				MyUtils.storeUserCookie(response, user);
			}
			//Ngược lại xóa Cookie.
			else {
				MyUtils.deleteUserCookie(response);
			}
			
			response.sendRedirect(request.getContextPath() + "/userInfo");
			
		}
		
	}
}
