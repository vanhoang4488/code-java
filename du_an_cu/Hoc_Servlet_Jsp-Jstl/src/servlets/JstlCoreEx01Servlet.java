package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Dept;
import utils.DBUtils;

@WebServlet(urlPatterns = {"/coreExample1", "/example1"})
public class JstlCoreEx01Servlet extends HttpServlet{
	private static final long serialVersionUID = 1;
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		List<Dept> list = DBUtils.queryDepartments();
		req.setAttribute("department", list);
		
		RequestDispatcher dispatcher =req.getServletContext().
											getRequestDispatcher("/WEB-INF/jstl_core_example01.jsp");
		dispatcher.forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
