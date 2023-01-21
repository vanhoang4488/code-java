package demo.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.beans.UserAccount;
import demo.utils.DBUtilsAccount;
import demo.utils.MyUtils;

@WebFilter(filterName = "loginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {
 
    public LoginFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
       
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        
        UserAccount user = MyUtils.getLoginedUser(session);
        
        String check = MyUtils.getCheckLogin(session);
  
        String sr = req.getServletPath();
        
        Connection conn = MyUtils.getStoredConnection(req);
          
        // chưa đăng nhập và muốn đăng nhập
        if(sr.contains("/login")) {
        	
        	String msnv = MyUtils.getUserNameInCookie(req);

            if( msnv != null) {
            	
            	try {
                   
            		UserAccount acc = DBUtilsAccount.findUser(conn, msnv);
                              		
            		MyUtils.storeLoginedUser(session, acc);
            		    
            	    MyUtils.checkLogin(session, null);
            			
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            	
            }
        	
        	chain.doFilter(request, response);
        	
        	return;
        	
        }
 
       
        //quên mật khẩu 
        if(sr.contains("/forget") ) {
        	
        	chain.doFilter(request, response);
        	
        	return;
        	
        }

        
        
       // với trường hợp chưa đăng nhập.
        if( check == null || user == null) {
        	
        	
        	res.sendRedirect(req.getContextPath() + "/login");
        	
        	return;
        }
        
        chain.doFilter(request, response);
        
    }        
 
}
