package helloworld_1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other")
public class ForwardDemo extends HttpServlet{
      private static final long serialVersionUID = 1L;
      
      public ForwardDemo() {}
      
      public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	  String forward = request.getParameter("forward");
    	  if("true".equals(forward)) {
    		  System.out.println("Forward Demo");
    		  
    		   
    		  request.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, "sucessfully");
    		  RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/showMe");
    		  dispatcher.forward(request, response);
    	  }
    	  
    	  ServletOutputStream out = response.getOutputStream();
          out.println("<h1>Text of ForwardDemoServlet</h1>");
          out.println("- servletPath=" + request.getServletPath());
      }
}
