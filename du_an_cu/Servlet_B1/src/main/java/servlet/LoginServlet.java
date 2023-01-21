package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Constants;
import beans.UserInfo;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ServletOutputStream out = response.getOutputStream();
		
		//lấy ra đối tượng HttpSession
		HttpSession session = request.getSession();
		//Giả sử người dùng login thành công và có thông tin như sau.
		UserInfo loginUserInfo = new UserInfo("Hoang", 22, "Viet Nam");
		//lưu trữ thông tin người dùng
		session.setAttribute(Constants.SESSION_USER_KEY, loginUserInfo);
		
		out.println("<html>"
				+ "<head>"
				+ "<title> Session </title>"
				+ "</head>"
				+ "<body>"
				+ "<h1> Session </h1>"
				+ "<a href='userInfo'>View UserInfo</a>"
				+ "</body>"
				+ "</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doGet(request, response);
	}
}
