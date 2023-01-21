package demo.ctvftech.attributes;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

public class RequestATT {

	private static final String SQL_SESSION_ATT = "SQL_SESSION_ATT";
	
	public static void storeSqlSession(HttpServletRequest request, SqlSession sqlSession) {
		
		request.setAttribute(SQL_SESSION_ATT, sqlSession);
	}
	
	public static SqlSession getSqlSession(HttpServletRequest request) {
		
		return (SqlSession) request.getAttribute(SQL_SESSION_ATT);
	}
}
