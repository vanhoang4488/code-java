package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1;
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		ServletOutputStream out = res.getOutputStream();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = \"utf-8\" >");
		out.println("<title> Bai 1 </title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h3> Hello World </h3>");
		out.println("this is my first Servlet");
		out.println("</body>");
		
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
