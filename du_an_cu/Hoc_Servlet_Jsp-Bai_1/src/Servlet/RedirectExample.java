package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/redirect", "/redirectExample"})
public class RedirectExample extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		String redirect = req.getParameter("redirect");
		if("true".equals(redirect)) {
			
			System.out.println("Redirect to showMeServlet");
			
			String contextPath = req.getContextPath();
			
			res.sendRedirect(contextPath + "/showMe");
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException{
		this.doGet(req, res);
	}
}
