package hoctap.servlet;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class Header extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private Vector<String> st = new Vector<>();
	private Random rd = new Random();
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		st.addElement("http://www.yahoo.com");
		st.addElement("http://www.hotmail.com");
		st.addElement("http://www.zednet.com");
		st.addElement("http://www.java.sun.com");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		response.setContentType("text/html");
		int siteIndex = Math.abs(rd.nextInt()) % st.size();
		String str = st.elementAt(siteIndex);
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", str);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request, response);
	}
}
