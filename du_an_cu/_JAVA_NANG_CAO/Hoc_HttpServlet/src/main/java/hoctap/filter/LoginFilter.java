package hoctap.filter;

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

import hoctap.beans.UserLogin;
import hoctap.utils.ExecuteQuery;
import hoctap.utils.ModuleQuery;

@WebFilter(filterName="loginFilter", urlPatterns= {"/userdetail/*", "/showcar/*"})
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req; 
		
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession userSession = request.getSession();
		
		/*
		 * kiểm tra xem có thông tin đăng nhập của người dùng trong session hay không?
		 * Nếu có đánh dấu và chuyển tiếp.
		 * ---Lý do: phải làm lằng nhằng thế này, mà không xét luôn điển đánh dấu đã CHECKED hay chưa?
		 * Vì: tôi không muốn lằng nhằng trong đoạn ghi nhớ đánh dấu, mỗi khi có cái gì đó xảy ra 
		 * với thông tin đăng nhập của người dùng.
		 */
		ModuleQuery module = ModuleQuery.getInstance();
		
		UserLogin user = module.getUserInSession(userSession);
		
		if(user != null) {
			userSession.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}
	    
		/*
		 * Trường hợp gửi yêu cầu đầu tiên đến Server, và nhận được mà đinh danh để tạo Session.
		 * Ta sẽ kiểm tra thông tin người dùng trong Cookie.
		 * và đánh dấu.
		 */
		String checked = (String) userSession.getAttribute("COOKIE_CHECKED");
		
		Connection conn = module.getConnection(request);
		
		user = module.getUserInCookie(request);
		
		if(checked == null && conn != null && user != null) {
			
			//kiểm tra thông tin có khớp với database trên Server hay không?
			try {
				
				boolean userCheck = ExecuteQuery.getInstance().findUserLogin(conn, user);
				if(userCheck) {
					chain.doFilter(request, response);
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			userSession.setAttribute("COOKIE_CHECKED", "CHECKED");
		}
		
		//các trường hợp còn lại phải quay lại trang đăng nhập.
		response.sendRedirect(request.getContextPath() + "/login");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
}
