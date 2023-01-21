package helloworld_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet{
    
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
    	UserInfo value = (UserInfo)session.getAttribute(Constants.SESSION_USER_KEY);
    	try {
           ServletOutputStream out = response.getOutputStream();
           out.println("<p>userName: " + value.getUserName() + "</p>");
           out.println("<p>userPost: " + value.getPost() + "</p>");
           out.println("<p>userCountry: " + value.getCountry() + "</p>");
    	}catch(NullPointerException e) {
      		response.sendRedirect(this.getServletContext().getContextPath() + "/login");
    	}
    }
}
