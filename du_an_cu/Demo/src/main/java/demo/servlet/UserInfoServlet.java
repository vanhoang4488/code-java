package demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.beans.UserAccount;
import demo.utils.MyUtils;

@WebServlet(urlPatterns= {"/userInfo"})
public class UserInfoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		//Kiểm tra người dùng đã đã login chưa.
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		
		//Nếu chưa đăng nhập 
		if(loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			
		}
		else {
		
			//lưu thông tin vào thuộc tính request trước khi chuyển tiếp.
			request.setAttribute("user", loginedUser);
			
			//Nếu người dùng đã login thì chuyển tiếp.
			// /WEB-INF/views/userInfoViews.jsp
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
			
			dispatcher.forward(request, response);
		}
				
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
