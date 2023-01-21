package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private String emailSupport1;
	
	public InitParamServlet() {}
	
	// phương thức này luông luôn được gọi một lân
	// ngay sau khi đối tượng Servlet được tạo ra.
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		//Lấy ra giá trị tham số khởi tạo (initalization parameter) của Servlet.
		// theo cấu hình của Servlet này trong web.xml
		
		this.emailSupport1 = config.getInitParameter("emailSupport1");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// lấy ra giá trị của tham số khởi tạo (initzation parameter) theo một cách khác.
		
		String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");
		ServletOutputStream out = response.getOutputStream();
		
		out.println("<html>");
		out.println("<head><title>Init Param</title></head>");
		out.println("<body>");
		out.println("<h3> Init Param </h3>");
		out.println("<p> emailSupport1 = " + this.emailSupport1 + "</p>");
		out.println("<p> emailSupport2 = " + emailSupport2 + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
