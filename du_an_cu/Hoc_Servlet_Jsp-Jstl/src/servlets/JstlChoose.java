package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/example2", "/c_chooseExample"}, initParams= {
	@WebInitParam(name="color", value="red")	
})
public class JstlChoose extends HttpServlet{
	private static final long serialVersionUID = 1;
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException{
		String color = this.getServletConfig().getInitParameter("color");
		
		req.setAttribute("color", color);
		
		RequestDispatcher dispatcher = req.getServletContext()
				.getRequestDispatcher("/WEB-INF/c_choose.jsp");
		dispatcher.forward(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
