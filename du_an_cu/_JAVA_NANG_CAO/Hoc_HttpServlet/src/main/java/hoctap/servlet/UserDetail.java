package hoctap.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hoctap.beans.User;
import hoctap.beans.UserLogin;
import hoctap.utils.ExecuteQuery;
import hoctap.utils.ModuleQuery;

@WebServlet("/userdetail")
public class UserDetail extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		ModuleQuery module = ModuleQuery.getInstance();
		
		Connection conn = module.getConnection(request);
		
		ExecuteQuery execute = ExecuteQuery.getInstance();
		
		try {
			
			HttpSession session = request.getSession();
			
			UserLogin userLogin = module.getUserInSession(session);
			
			User user = execute.getUserDetail(conn, userLogin.getUsername());
		
			/*
			 * Dẫu biết rằng, logic mà nói khi muốn xem thông tin chi tiết về User
			 * thì người dùng phải đăng nhập rồi, nhưng tôi vẫn muốn xét đến trường hợp 
			 * User == null để đề phòng.
			 */
		    if(user == null) {
		    	
		    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		    	
		    	dispatcher.forward(request, response);
		    }
		    else {
		    	
		    	request.setAttribute("user", user);
		    	
		    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/userdetail.jsp");
				
				dispatcher.forward(request, response);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doGet(request, response);
	}
}
