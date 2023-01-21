package helloworld_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirictDemo")
public class RedirictDemo extends HttpServlet{
     private static final long serialVersionUID = 1L;
     
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	 String redirict = request.getParameter("redirict");
    	 if("true".equals(redirict)) {
    		 String contextPath = request.getContextPath();
    		 response.sendRedirect(contextPath + "/showMe");
    	 }
    	 ServletOutputStream out = response.getOutputStream();
    	 out.println("<h1>Text of RedirictDemo</h1>");
    	 out.println("-servlet=" + request.getServletPath());
     }
}
