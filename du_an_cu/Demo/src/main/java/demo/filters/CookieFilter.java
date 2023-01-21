package demo.filters;

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
import demo.utils.DBUtils;
import demo.utils.MyUtils;

@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String servletPath = req.getServletPath();
		
		//Nếu người vào login thì thôi.
		if(servletPath.equals("/login")) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = req.getSession();
		
		UserAccount userInSession = MyUtils.getLoginedUser(session);
		
		// Vừa dùng chức năng login xong.
		if(userInSession != null) {
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}
		
		//Connection đã được tạo trọng JDBCFilter.
		Connection conn = MyUtils.getStoreConnection(request);
		
		//Cờ (flag) để kiểm tra Cookie.
		String checked = (String) session.getAttribute("COOKIE_CHECKED");
		
		// 2 trường hợp có thể xảy ra:
		// 1. Có thông tin đăng nhập trong cookie.
		// 2. Chưa có thông tin đăng nhập trong cookie.
		if(checked == null && conn != null) {
			String userName = MyUtils.getUserNameInCookie(req);
			
			// TH1: người dùng chưa đăng nhập vào Website lần nào 
			// hoặc đã đăng nhập nhưng dùng chức năng không nhớ mật khẩu.
			// Và hiện tại người dùng đăng nhập vào Website mà chưa login.
			if(userName == null || userName.isEmpty()) {
				
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			//Th2: Khi người dùng chưa đăng nhập hiện tại nhưng đã đăng nhập trước đó.
			//thông tin đăng nhập được lưu trong cookie.
			else {
			
				try {
					UserAccount user = DBUtils.findUser(conn, userName);
					MyUtils.storeLoginedUser(session, user);
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
				
				//Đánh dấu đã kiểm tra Cookie.
				session.setAttribute("COOKIE_CHECKED", "CHECKED");
				chain.doFilter(request, response);
			}
			
		}
								
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
}
