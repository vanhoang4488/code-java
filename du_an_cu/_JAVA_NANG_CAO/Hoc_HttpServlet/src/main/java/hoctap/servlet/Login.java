package hoctap.servlet;

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

import hoctap.beans.UserLogin;
import hoctap.utils.ExecuteQuery;
import hoctap.utils.ModuleQuery;

@WebServlet("/login")
public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		UserLogin user = new UserLogin(username, password);
		
		Connection conn = null;
		
		try {
			
			ModuleQuery module = ModuleQuery.getInstance();
			
			conn = module.getConnection(request);
			
			ExecuteQuery execute= ExecuteQuery.getInstance();
			
			//Kiểm tra thông tin đăng nhập.
			boolean check = execute.findUserLogin(conn, user);
			
			if(check) {
				
				String remeberLogin = request.getParameter("rememberLogin");
				
				//nhớ mật khẩu.
				if(remeberLogin.equals("1")) 
					module.storeUserInCookie(response, user);
				else module.removeUserInCookie(response);
				
				//lưu vào session thông tin đã đăng nhập để bộ lọc loginFilter bỏ qua.
				HttpSession session = request.getSession();
				module.storeUserInSession(session, user);		
				
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp");
				
				dispatcher.forward(request, response);
			}else {
				
				request.setAttribute("user", user);
				
				request.setAttribute("notice", "Thông tin tài khoản mật khẩu không chính xác");
				
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
				
				dispatcher.forward(request, response);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
