package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.Constants;

@WebServlet(urlPatterns = {"/showme"})
public class ShowMe extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		String value = (String) req.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);
		ServletOutputStream out = res.getOutputStream();
		
		out.println("<h1>Show me Servlet</h1>");
		out.println(value);
	}
}
