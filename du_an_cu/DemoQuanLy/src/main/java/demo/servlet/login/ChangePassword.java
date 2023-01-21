package demo.servlet.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.beans.UserAccount;
import demo.utils.DBUtilsAccount;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = {"/changePassword"})
public class ChangePassword extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
 
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login/change_password.jsp");
    	dispatcher.forward(request, response);
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		try {
	    	  Connection conn = MyUtils.getStoredConnection(request);
	    	  
              String msnv = request.getParameter("msnv");
              
              String oldpass = request.getParameter("oldpass");
              
              String  newpass = request.getParameter("newpass1");
              
              UserAccount acc = DBUtilsAccount.checkInfo(conn, msnv, oldpass);
	    	  
              if(acc.getMsnv().isEmpty()) {
                  
            	  request.setAttribute("note", "Thông tin tài khoản mật khẩu không chính xác");   
            	  
            	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login/loginInfo.jsp");
              	  
            	  dispatcher.forward(request, response);
              }else {
            	  
            	  DBUtilsAccount.newPassword(conn, msnv, newpass);
            	  		          
            	  response.sendRedirect(request.getContextPath() + "/ad/quanlychi");
              }  
	    	}catch(SQLException ex) {
	    		ex.printStackTrace();
	    	}
	}
		
}	 
