package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examinfo")
public class ExampleInfoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		ServletOutputStream out = res.getOutputStream();
		
		out.println("<style> span {color:blue;} </style>");
		String requestURL = req.getRequestURL().toString();
		out.println("<br /><span>requestURL</span>");
		out.println(requestURL);
		
		String requestURI = req.getRequestURI();
		out.println("<br /><span>requestURI</span>");
		out.println(requestURI);
		
		String contextPath = req.getContextPath();
		out.println("<br /><span>ContextPath: </span>");
		out.println(contextPath);
		
		String servletPath = req.getServletPath();
		out.println("<br /><span>ServletPath: </span>");
		out.println(servletPath);
	    
	}
}
