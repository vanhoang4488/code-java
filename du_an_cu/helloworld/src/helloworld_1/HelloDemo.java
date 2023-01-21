package helloworld_1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloDemo extends HttpServlet{
   private static final long serialVersionUID=1;
   private String email;
   
   public HelloDemo() {}
   
   public void init(ServletConfig config) throws ServletException{
	   super.init(config);
	   
	   email= config.getInitParameter("email_1");
   }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	   String email_2= this.getServletConfig().getInitParameter("email_2");
	   
	   ServletOutputStream out= response.getOutputStream();
	   out.println("<html>");
	   out.println("<head>");
	   out.println("<title>helloDemo</title>");
	   out.println("</head>");
	   out.println("<body>");
	   out.println("<p>email" + this.email + "</p>");
	   out.println("<p>email_2" + email_2 + "<p>");
	   out.println("<body>");
	   out.println("<html>");
	   
	   out.close();
   }
}
