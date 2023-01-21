package demo.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.utils.MyUtils;


@WebServlet(urlPatterns = {"/logout"})
public class Logout extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
    	   	
    	HttpSession session = request.getSession();
    	
    	MyUtils.checkLogin(session, null);
    	
    	/*
    	 * 
    	 * bởi vì  chuyển hướng sang /login nên sẽ sử dựng được bộ lọc cookieFilter vì vậy có thể xóa luôn sesion ở cookieFilter
    	 */
    	
    	response.sendRedirect(request.getContextPath() + "/login");
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		
		doGet(request, response);
	}
		
}	 
