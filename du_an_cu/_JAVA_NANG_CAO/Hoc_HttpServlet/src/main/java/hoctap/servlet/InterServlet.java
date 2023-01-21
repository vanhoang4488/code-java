/*
 * Kiểm tra sự trao đổi thông tin giữa các Servlet.
 */

package hoctap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hoctap.beans.InforServlet;

@WebServlet("/interServlet")
public class InterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		ServletContext servletContext = this.getServletContext();
		
		Enumeration<String> servlets = servletContext.getServletNames();
		
		List<InforServlet> inforServlets = new ArrayList<>();
		while(servlets.hasMoreElements()) {
			
			String servletName = servlets.nextElement();
			
			Servlet servlet = servletContext.getServlet(servletName);
			
			String servletInfo = servlet.getServletInfo();
			
			String servletClass = servlet.getClass().getName();
			
			inforServlets.add(new InforServlet(servletName, servletClass, servletInfo));
		}
		
		request.setAttribute("inforServlets", inforServlets);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/inforServlets.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request, response);
	}
}
