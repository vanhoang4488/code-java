package hoctap.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hoctap.beans.UserLogin;

public class ModuleQuery {

	private volatile static ModuleQuery instance;
	
	//lưu thông tin liên quan đến Connection
	private static final String USER_DATA_CONNECTION = "USER_DATA_CONNECTION";
	
	//lưu thông tin dăng nhập của User trong COOKIE.
	private static final String ATT_NAME_USER_COOKIE = "ATT_NAME_USER_COOKIE";
	private static final String ATT_PASS_USER_COOKIE = "ATT_PASS_USER_COOKIE";
	
	private ModuleQuery() {}
	
	public static ModuleQuery getInstance() {
		
		if(instance == null) {
			synchronized (ModuleQuery.class) {
				if(instance == null)
					instance = new ModuleQuery();
			}
		}
		
		return instance;
	}
	
	public void setConnection(ServletRequest req, Connection conn) {
		req.setAttribute(USER_DATA_CONNECTION, conn);
	}
	
	public Connection getConnection(ServletRequest req) {
		
		Connection conn = (Connection) req.getAttribute(USER_DATA_CONNECTION);
		
		return conn;
	}
	
	public void storeUserInSession(HttpSession session, UserLogin user) {
		
		session.setAttribute("userLogin", user);
	}
	
	public UserLogin getUserInSession(HttpSession session) {
		
		UserLogin user = (UserLogin) session.getAttribute("userLogin");
		
		return user;
	}
	
	public void storeUserInCookie(HttpServletResponse response, UserLogin user) {
		
		System.out.printf("Store user in Cookie: %s\n", user.getUsername());
		
		Cookie nameCookie = new Cookie(ATT_NAME_USER_COOKIE, user.getUsername());
		nameCookie.setMaxAge(24*60*60);
		response.addCookie(nameCookie);
		
		Cookie passCookie = new Cookie(ATT_PASS_USER_COOKIE, user.getPassword());
		passCookie.setMaxAge(24*60*60);
		response.addCookie(passCookie);
	}
	
	public UserLogin getUserInCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length > 0) {
			
			String username = null;
			String password = null;
			
			for(Cookie cookie : cookies) {
			
				if(ATT_NAME_USER_COOKIE.equals(cookie.getName()))
					username = cookie.getValue();
				else if(ATT_PASS_USER_COOKIE.equals(cookie.getName()))
					password = cookie.getValue();
			}
			
			if(username != null && password != null) return new UserLogin(username, password);
		
		}
		
		return null;
	}
	
	public void removeUserInCookie(HttpServletResponse response) {
		
		Cookie nameCookie = new Cookie(ATT_NAME_USER_COOKIE, null);
		nameCookie.setMaxAge(0);
		response.addCookie(nameCookie);
		
		Cookie passCookie = new Cookie(ATT_PASS_USER_COOKIE, null);
		passCookie.setMaxAge(0);
		response.addCookie(passCookie);
	}
}
