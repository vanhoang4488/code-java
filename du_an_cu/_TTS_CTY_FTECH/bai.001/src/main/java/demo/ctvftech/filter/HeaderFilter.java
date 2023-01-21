package demo.ctvftech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@WebFilter(filterName = "headerFilter", urlPatterns = {"/*"})
public class HeaderFilter implements Filter {

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		System.out.printf("#INFO: %s: %s \n", req.getMethod(), req.getRequestURI());
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		resp.setContentType("application/json");
			
		chain.doFilter(request, response);
	}

}
