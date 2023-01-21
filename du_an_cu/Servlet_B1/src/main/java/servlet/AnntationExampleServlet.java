package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/annotationExample", "/annExample"}, initParams = {
		@WebInitParam(name = "emailSupport1", value = "hoangie2l62@gmail.com"),
		@WebInitParam(name = "emailSupport2", value = "17020769@vnu.edu.vn")
})
public class AnntationExampleServlet extends HttpServlet{
	
	public static final long serialVersionUID = 1L;
	
	private String emailSupport1;
	 
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		this.emailSupport1 = this.getInitParameter("emailSupport1");
	}
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<html>"
				+ "<head>"
				+ "<title> Annotation Example </title>"
				+ "</head>"
				+ "<body>"
				+ "<h1> Init Parameter = Annotaion </h1>"
				+ "<p> emailSupport1 = " + this.emailSupport1 + "</p>"
				+ "<p> emailSupport1 = " + emailSupport2 + "</p>"
				+ "</body>"
				+ "</html>");
	
	}
	
	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
