package hoctap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import hoctap.beans.Header;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showHeader")
public class ShowHeader extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		Enumeration<String> headerEnu = request.getHeaderNames();
		List<Header> headers = new ArrayList<>();
		while(headerEnu.hasMoreElements()) {
			String name = headerEnu.nextElement();
			String info = request.getHeader(name);
			headers.add(new Header(name, info));
		}
		//System.out.println(headers.size());
		request.setAttribute("headers", headers);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/showHeader.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request, response);
	}
}
