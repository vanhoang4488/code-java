package utils;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class CookieUtils {
	
	public static void demoUserCookie(HttpServletRequest request, HttpServletResponse response, JspWriter out) throws IOException {
		
		boolean found = false;
		
		//Danh sách các cookies được website này lưu vào máy tính người dùng.
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			
			String userName = null;
			String lastLoginDatetime = null;
			out.println("<h3>Cookies: </h3>");
			
			for(int i = 0; i < cookies.length; i++) {
				
				out.println(cookies[i].getName() + " : " + cookies[i].getValue() + "</br>");
				
				if(cookies[i].getName().equals("userName")) {
					userName = cookies[i].getValue();
				}else if(cookies[i].getName().equals("lastLoginDatetime")) {
					lastLoginDatetime = cookies[i].getValue();
				}
				
			}
			
			if(userName != null && lastLoginDatetime != null) {
				found = true;
				out.println("<h4> Last login info: </h4> "
						+ "User Name: " + userName + "<br>"
						+ "Last Login Datetime: " + lastLoginDatetime + "<br>");
				response.addCookie(new Cookie("userName", null));
				response.addCookie(new Cookie("lastLoginDatetime", null));
			}
			
		}
		
		if(!found) {
			
			out.println("<h3> NO cookies found! write some cookies into client computer </h3>");
			//Ghi một vài thông tin Cookie vào máy tính người dùng.
			//Chẳng hạn như userName họ từng login.
			//Đây là cách nhớ user đã login.
			//Mô phỏng ghi Cookie vào máy tính người dùng sau khi họ vừa login.
			
			String userName = "someUserName";
			
			Cookie cookieUserName = new Cookie("userName", userName);
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date now = new Date();
			
			String lastLoginDatetime = df.format(now);
			System.out.println(lastLoginDatetime);
			Cookie cookieLoginDatetime = new Cookie("lastLoginDatetime", URLEncoder.encode(lastLoginDatetime, "UTF-8") );
			
			//Sét đặt thời gian sống của Cookie là 24h (Đã đổi ra giây).
			cookieUserName.setMaxAge(24*60*60);
			//Sét đặt thời gian sống của Cookie là 24h (Đã đổi ra giây).
			cookieLoginDatetime.setMaxAge(24*60*60);
			
			//Ghi vào máy tính người dùng.
			response.addCookie(cookieUserName);
			response.addCookie(cookieLoginDatetime);
			
		}
		
	}
	
}
