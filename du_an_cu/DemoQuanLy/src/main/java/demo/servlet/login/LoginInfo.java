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
import javax.servlet.http.HttpSession;

import demo.beans.UserAccount;
import demo.utils.DBUtilsAccount;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = {"/login"})
public class LoginInfo extends HttpServlet{
	
	/* 
	 * Đăng nhập ở đây ta không kiểm tra xem người sử dụng  đã đăng nhập hay chưa?
	 * Vì: hiện tại các trang website hiển thị thông tin khác cũng làm như vậy và website cũng không hoạt động trên thời gian thực
	 * ví dụ: Website môn học của trường cùng một tài khoản trên hai thiết bị được.
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login/loginInfo.jsp");
    	dispatcher.forward(request, response);
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		try {
	    	  Connection conn = MyUtils.getStoredConnection(request);
	    	  
              String ms = request.getParameter("userName");
              
              String pass = request.getParameter("pass");
              
              String choose = request.getParameter("choose");
              
              UserAccount acc = DBUtilsAccount.checkInfo(conn, ms, pass);
	    	  
              if(acc.getMsnv().isEmpty()) {
                  
            	  request.setAttribute("note", "Thông tin tài khoản mật khẩu không chính xác");   
            	  
            	  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login/loginInfo.jsp");
              	  
            	  dispatcher.forward(request, response);
              }else if(acc.getOffice().equals("admin")){
            	  
            	  HttpSession session = request.getSession();
                  
            	  session.invalidate();
            	  
            	  
            	  HttpSession session2 = request.getSession();
            	  
            	  MyUtils.checkLogin(session2, "login");
            	  
            	  MyUtils.storeLoginedUser(session2, acc);
                  
            	  /*
                   * 
                   * Lí do phần này không phải kiểm tra xem cookie đã tồn tại hay chưa?
                   * Vì: cookie được lưu dưới dạng [key, value] giống như Hashtable trong java vậy => cookie có cùng mã key sẽ tự
                   * cài đè lên nhau.
                   */
            	  if(choose == null) {
            		 
            		  MyUtils.deleteUserCookie(response);  
            	  }else {
            		  
            		  MyUtils.storeCookie(response, acc);
            		  
            	  }
            	  
            	  response.sendRedirect(request.getContextPath() + "/ad/bent");
              }else if(acc.getOffice().equals("employee")){
            	  
            	  HttpSession session = request.getSession();
                  
            	  session.invalidate();
            	  
            	  
            	  HttpSession session2 = request.getSession();
            	  
            	  MyUtils.checkLogin(session2, "login");
            	  
            	  MyUtils.storeLoginedUser(session2, acc);
                  
            	  /*
                   * 
                   * Lí do phần này không phải kiểm tra xem cookie đã tồn tại hay chưa?
                   * Vì: cookie được lưu dưới dạng [key, value] giống như Hashtable trong java vậy => cookie có cùng mã key sẽ tự
                   * cài đè lên nhau.
                   */
            	  if(choose == null) {
            		 
            		  MyUtils.deleteUserCookie(response);  
            	  }else {
            		  
            		  MyUtils.storeCookie(response, acc);
            		  
            	  }
            	  
            	  response.sendRedirect(request.getContextPath() + "/bent");
              }    
              
              
	    	}catch(SQLException ex) {
	    		ex.printStackTrace();
	    	}
	}
		
}	 
