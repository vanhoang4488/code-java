package demo.utils;

import java.sql.Connection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.beans.UserAccount;

public class MyUtils {
	
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	 
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
    
    private MyUtils() {}
    
    public static void storeConnection(HttpServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }
 
    public static Connection getStoredConnection(HttpServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }
    
    public static void checkLogin(HttpSession session, String check) {
    	
    	session.setAttribute("CHECK_LOGIN", check);
    }
    
    public static String getCheckLogin(HttpSession session) {
    	
    	String check = (String) session.getAttribute("CHECK_LOGIN");
       
    	return check;
    	
    }
    
    public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {

        session.setAttribute("user", loginedUser);
    }
 
    
    public static UserAccount getLoginedUser(HttpSession session) {
        UserAccount loginedUser = (UserAccount) session.getAttribute("user");
        return loginedUser;
    }
 
    
    public static void storeCookie(HttpServletResponse response, UserAccount user) {
    	System.out.println("Store user cookie: " + user.getMsnv());
    	
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getMsnv());
        
        cookieUserName.setMaxAge(24 * 60 * 60);
        
        response.addCookie(cookieUserName);
    }
 
    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
 
    public static void deleteUserCookie(HttpServletResponse response) {
        
    	Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        
    	cookieUserName.setMaxAge(0);
        
    	response.addCookie(cookieUserName);
    }
    
    
}
