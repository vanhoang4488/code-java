package Servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.Constants;

@WebServlet(urlPatterns = {"/forward", "/forwardDemo"})
public class FowardDemoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		String forward = req.getParameter("forward");
		
		if("true".equals(forward)) {
			System.out.println("Forward to ShowMeServlet");
			
			//Sét dữ liệu vào thuộc tính (attribute) của request.
			req.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, "Hi, I'am Tom come from Walt Disney");
			
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/anno");
			
			dispatcher.forward(req, res);
		}
		
		ServletOutputStream out = res.getOutputStream();
		out.println("<h3>Text of ForwardDemoServlet</h3>");
		out.println("-servletPath = " + req.getServletPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException{
		this.doGet(req, res);
	}
}
