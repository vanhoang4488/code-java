package helloworld_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showMe")
public class ShowMe extends HttpServlet{
     private static final long serialVersionUID = 1L;
     
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	 String value = (String) request.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);
    	 ServletOutputStream out = response.getOutputStream();
    	 out.println("<h1>Text of ShowMeDemo</h1>");
    	 out.println(value);
     }
}
