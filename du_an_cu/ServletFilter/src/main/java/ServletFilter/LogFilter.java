/*
 * LogFilter dưới đây ghi lại thời gian và đường dẫn của yêu cầu gửi tới WebApp.
 */

package ServletFilter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	public LogFilter() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LogFilter init!");
	}

	@Override
	public void destroy() {
		System.out.println("LogFilter destroy!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String servletPath = req.getServletPath();

		System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath //
				+ ", URL =" + req.getRequestURL());

		// Cho phép request được đi tiếp. (Vượt qua Filter này).
		chain.doFilter(request, response);
	}

}