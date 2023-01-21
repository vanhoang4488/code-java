package demo.filter;

import java.io.IOException;
import java.sql.Connection;
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

import demo.beans.Summary;
import demo.database.ConnectionUtils;
import demo.utils.DBUtils;
import demo.utils.MyUtils;

@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {
 
    public JDBCFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    private boolean needJDBC(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        
        String pathInfo = request.getPathInfo();
 
        String urlPattern = servletPath;
 
        if (pathInfo != null) {
        	
            urlPattern = servletPath + "/*";
        }
 
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();

        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
    	request.setCharacterEncoding("utf-8");
  	    
    	response.setCharacterEncoding("utf-8");
        
    	HttpServletRequest req = (HttpServletRequest) request;
        
    	String sr = req.getServletPath();
        
        if (this.needJDBC(req) ) {

            System.out.println("#INFO " + new Date() + " - ServletPath :" + sr
                    + ", URL =" + req.getRequestURL());
   
            
            Connection conn = null;
            
            Summary sum = null;
            
            try {
               
                conn = ConnectionUtils.getConnection();
            
                conn.setAutoCommit(false);
                
                MyUtils.storeConnection(req, conn);
                
                sum = DBUtils.getSummary(conn);
                
                req.setAttribute("Sum", sum);
                
                chain.doFilter(request, response);
 
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ConnectionUtils.rollbackQuietly(conn);
 
            } finally {
                ConnectionUtils.closeQuietly(conn);
            }
         }else {
        	
        	 chain.doFilter(request, response);
        }
 
    }
 
}
