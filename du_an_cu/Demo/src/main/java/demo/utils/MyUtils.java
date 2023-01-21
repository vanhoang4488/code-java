package demo.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.beans.UserAccount;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION = "ATT_NAME_CONNECTION";
	public static final String ATT_NAME_USER_NAME = "ATT_NAME_USER_NAME";
	
	//lưu trữ Connection vào thuộc tính của request;
	//thông tin lưu trữ chỉ tồn tại trong thời gian request
	//cho tới khi dữ liệu được trả về trình duyệt người dùng.
	public static void storeConnection(ServletRequest req, Connection conn) {
		req.setAttribute(ATT_NAME_CONNECTION, conn);
	}
	
	//Lấy đối tượng Connection đã được lưu trong request.
	public static Connection getStoreConnection(ServletRequest req) {
		Connection conn = (Connection) req.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}
	
	//lưu trữ thông tin người dùng đã login vào Session.
	public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
		session.setAttribute(ATT_NAME_USER_NAME, loginedUser);
	}
	
	//lấy thông tin người dùng lưu trữ trong Session.
	public static UserAccount getLoginedUser(HttpSession session) {
		UserAccount loginedUser = (UserAccount) session.getAttribute(ATT_NAME_USER_NAME);
		return loginedUser;
	}
	
	//lưu trữ thông tin người dùng vào Cookie.
	public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
		
		System.out.println("Store user cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());
		cookieUserName.setMaxAge(24*60*60);
		response.addCookie(cookieUserName);
		
	}
	
	
	public static String getUserNameInCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if( ATT_NAME_USER_NAME.equals(cookie.getName()) ) return cookie.getValue();
			}
		}
		
		return null;
	}
	
	//Xóa cookie của người dùng.
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}
}
