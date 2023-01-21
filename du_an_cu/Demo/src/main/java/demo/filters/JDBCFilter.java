package demo.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import demo.conn.ConnectionUtils;
import demo.utils.MyUtils;

@WebFilter(filterName="jdbcFilter", urlPatterns = {"/*"})
public class JDBCFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		//chỉ mở connection (kết nối) đối với các request có đường dẫn đặc biệt.
		//chẳng hạn đường dẫn tới các Servlet, jsp,..
		//Tránh tình trạng mở Connection với các yêu cầu thông thường.
		//chẳng hạn imagesm, css, javascript,...
		
		if(this.needJDBC(req)) {
			System.out.println("Open Connection for: " + req.getServletPath());
			Connection conn = null;
			
			try {
				//tạo ra đối tượng kết nối database .
				conn = ConnectionUtils.getMyConnection();
				System.out.println("Done...");
				
				//Sét tự động commit false để chủ động điều khiển.
				conn.setAutoCommit(false);
				
				//lưu trữ đối tượng Connection vào thuộc tính của request.
				MyUtils.storeConnection(req, conn);
				
				//cho phép request đi tiếp .
				//Đi tới filter tiếp theo hoặc đi tới mục tiêu.
				chain.doFilter(request, response);
				
				//Gọi phương thức commit() để hoàn thành giao dịch với database.
				conn.commit();
			}catch(ClassNotFoundException ex) {
				ex.printStackTrace();
				ConnectionUtils.rollbackQuietly(conn);
			}catch(SQLException ex) {
				ex.printStackTrace();
				ConnectionUtils.rollbackQuietly(conn);
			}
			finally {
				
				ConnectionUtils.closeQuietly(conn);
			}
		}
		
		// Với các request thông thường (images, css, html, ...)
		// Không cần mở connection.
		else {
			//Cho phép request đi tiếp.
			//Đo tới Filter tiếp theo hoặc đi tới mục tiêu.
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private boolean needJDBC(HttpServletRequest request) {
		System.out.println("JDBC Filter");
		
		String servletPath = request.getServletPath();
		
		String pathInfo = request.getPathInfo();
		
		String urlPattern = servletPath;
		
		if(pathInfo != null) {
			urlPattern = servletPath + "/*";
		}
		
		//Key: servletName
		//Value: ServletRegisTration.
		Map<String, ? extends ServletRegistration> servletRegistration = request.getServletContext().getServletRegistrations();
		
		//Tậ hợp tất cả các Servlet trong WebApp của bạn.
		Collection<? extends ServletRegistration> values = servletRegistration.values();
		
		for(ServletRegistration sr : values) {
			Collection<String> mappings = sr.getMappings();
			if(mappings.contains(urlPattern)) {
				return true;
			}
		}
		return false;
	}
	
}
