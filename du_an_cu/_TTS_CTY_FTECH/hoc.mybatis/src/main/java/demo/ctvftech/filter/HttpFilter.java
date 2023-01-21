package demo.ctvftech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import demo.ctvftech.attributes.RequestATT;
import demo.ctvftech.connector.MybatisConnector;

@Component
@WebFilter(filterName ="httpFilter", urlPatterns= {"/*"})
public class HttpFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.printf("#INFO: %s - %s\n", req.getMethod(), req.getRequestURI());
		
		try {
			
			SqlSession sqlSession = MybatisConnector.getInstance().getSqlSessionFactory().openSession();
			
			RequestATT.storeSqlSession(req, sqlSession);
			System.out.println("?????????????");
			chain.doFilter(request, response);
			
			sqlSession.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
