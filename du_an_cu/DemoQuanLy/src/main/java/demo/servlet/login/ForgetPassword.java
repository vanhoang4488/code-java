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

import demo.database.ConnectionUtils;
import demo.utils.DBUtilsAccount;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = {"/forget"})
public class ForgetPassword extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
    	  
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login/forget_password.jsp");
    	dispatcher.forward(request, response);
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoredConnection(request);		
		
		try {
	    	  
	    	  conn.setAutoCommit(false);
	    	  
              String msnv = request.getParameter("userName");
              
              String email = DBUtilsAccount.checkEmail(conn, msnv);
              
              if(!email.isEmpty()) {
        	      int ipass = (int) (Math.random() * 10000001);        	      
        	      
        	      String pass = String.valueOf(ipass);
        	      
        	      if(ipass < 10001) {
        	    	  
        	    	  pass += "mail";
        	      }
        	      
        	      DBUtilsAccount.newPassword(conn, msnv, pass);

        	      request.setAttribute("msnv", msnv);
            	  request.setAttribute("email", email);
            	  request.setAttribute("password", pass);
            	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login/formspree.jsp");
              	  dispatcher.forward(request, response);
              	  
              }else {
            	  
            	  request.setAttribute("note2", "lưu ý: MSNV không tồn tại");
            	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login/forget_password.jsp");
              	  dispatcher.forward(request, response);
              }
              
          	  conn.commit();
	    	}catch(SQLException ex) {
	    		ex.printStackTrace();
	    		ConnectionUtils.rollbackQuietly(conn);
	    	}
	}
		
}	 
