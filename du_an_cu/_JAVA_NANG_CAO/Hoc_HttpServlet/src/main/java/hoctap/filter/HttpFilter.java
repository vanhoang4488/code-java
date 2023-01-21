package hoctap.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
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

import hoctap.connection.ConnectionManager;
import hoctap.utils.ModuleQuery;

@WebFilter(filterName="httpFilter", urlPatterns={"/*"})
public class HttpFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) req;
		
		System.out.printf("#INFO: %tc: %s - %s: %s\n", new Date(), request.getServletPath(), request.getMethod(), request.getRequestURL());
		
		boolean check = needJDBC(request);
		
		if(check) {
			
			Connection conn = null;
			
			try {
			
				conn = ConnectionManager.getConnection("mysql");
				
				conn.setAutoCommit(false);
				
				ModuleQuery module = ModuleQuery.getInstance();
				
				module.setConnection(request, conn);
				
				chain.doFilter(request, resp);
				
				conn.commit();			
			}
			catch(SQLException ex) {
				System.out.println("----------------------");
				ex.printStackTrace();
				ConnectionManager.rollback(conn);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				ConnectionManager.rollback(conn);
			}
			finally {
				ConnectionManager.close(conn);
			}
		}else {
			chain.doFilter(req, resp);
		}
	}

	//kiểm tra xem request đến một servlet hay chỉ đơn thuần là mấy loại dữ liệu như: image, css, js, html.
	private boolean needJDBC(HttpServletRequest request) {
		
		String servletPath = request.getServletPath();
		
		String pathInfo = request.getPathInfo();
		
		String urlPattern = servletPath;
		
		if(pathInfo != null)
			urlPattern = servletPath + "/*";
		
		//key: String
		//value: ServletRegistration.
		Map<String, ? extends ServletRegistration> map = request.getServletContext().getServletRegistrations();
		
		//Collection<? extends ServletRegistration>
		Collection<? extends ServletRegistration> values = map.values();
		
		for(ServletRegistration sr : values) {
			
			Collection<String> servletPaths = sr.getMappings();
			
			if(servletPaths.contains(urlPattern)) return true;
		}
		
		return false;
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		
	}

}
