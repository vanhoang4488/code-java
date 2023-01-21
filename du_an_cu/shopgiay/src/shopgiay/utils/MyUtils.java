package shopgiay.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopgiay.beans.Cart;

public class MyUtils {
    
	public static Cart cookieCart = new Cart();
	
	//đưa cookie vào session để tiện dùng về sau;
	public static void setCartSession(HttpSession ses, Cart cart) {
		ses.setAttribute("CookieCart", cart);
	}
	
	//lấy giá trị Cart trong session
	public static Cart getCartSession(HttpSession ses) {
		Cart cart = (Cart) ses.getAttribute("CookieCart");
		return cart;
	}
	
	
	//lưu giữ Cart vào cookie
	public static void setCookieCart(HttpServletResponse response, Cart cart) {
		Cookie cookie = new Cookie("SHOPGIAY_CART", cart.toString());
		cookie.setMaxAge(12*60*60);
		response.addCookie(cookie);
	}
	
	//lấy giá trị Cart từ cookie
	public static String getCookieCart(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("SHOPGIAY_CART".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "";
	}
	
	// Xóa Cookie của người dùng
    public static void deleteUserCookie(HttpServletResponse response, String str) {
        Cookie cookie = new Cookie(str, null);
        // 0 giây. (Cookie này sẽ hết hiệu lực ngay lập tức)
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
