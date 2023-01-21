package hoctap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		
		HttpSession userSession = request.getSession();
		
		//In các thông tin về Session.
		Date dateCreated = new Date(userSession.getCreationTime());
		Date dateAccessed = new Date(userSession.getLastAccessedTime());
		out.println("ID: " + userSession.getId());
		out.println("CreatedTime: " + dateCreated);
		out.println("LastAccessedTime: " + dateAccessed);
		
		//Đặt lại các thông tin cần thiết.
		String dataName = request.getParameter("dateName");
		if(dataName != null && !dataName.isEmpty()) {
			String dataValue = request.getParameter("dataValue");
			userSession.setAttribute(dataName, dataValue);
		}
		
		//In nội dung nhận được từ Session.
		Enumeration<String> e = userSession.getAttributeNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String value = userSession.getAttribute(name).toString();
			out.println(name + " = " + value);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
	}
}
