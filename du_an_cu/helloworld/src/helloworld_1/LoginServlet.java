package helloworld_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
      public static final long serialVersionUID = 1L;
      
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	   ServletOutputStream out = response.getOutputStream();
    	   
    	   HttpSession session = request.getSession();
    	   
    	   UserInfo logininfo = new UserInfo("123", "login1", 1);
    	   session.setAttribute(Constants.SESSION_USER_KEY, logininfo);
    	   
    	   out.println("<html>");
    	   out.println("<head><title> Example Session </title></head>");
    	   out.println("<body>");
    	   out.println("<h2>Welcome Session</h2>");
    	   out.println("<a href='userInfo'> login in here </a>");
    	   out.println("</body>");
    	   out.println("</html>");
      }
}
