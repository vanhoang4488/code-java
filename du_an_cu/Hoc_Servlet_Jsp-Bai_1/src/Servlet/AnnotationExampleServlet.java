package Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Bạn có thể cấu hình một hoặc nhiều đường dẫn url.
//Để truy cập vào Servlet này.
@WebServlet(urlPatterns = {"/annotationEx", "/anno"}, initParams = {
		@WebInitParam(name = "emailSupport1", value = "hoangie2k62@gmail.com"),
		@WebInitParam(name = "emailSupport2", value = "17020769@vnu.edu.vn")
})
public class AnnotationExampleServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private String emailSupport1;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		
		this.emailSupport1 = config.getInitParameter("emailSupport1");
	}
	
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		
		ServletOutputStream out = res.getOutputStream();
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset = \"utf-8\">\r\n" + 
				"		<title>Bai 1</title>\r\n" + 
				"	</head>\r\n" + 
				"	\r\n" + 
				"	<body>\r\n" + 
				"		<h1>Annotation Example</h1>\r\n" + 
				"		<p>emailSupport1 = " + this.emailSupport1 + "</p>" +
				"		<p>emailSupport2 = " + emailSupport2 + "</p>" +
				"	</body>\r\n" + 
				"</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
