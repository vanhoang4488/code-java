package demo.servlet.admin;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.beans.UserAccount;
import demo.utils.DBUtilsAccount;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = { "/ad/insertEmployee" })
public class InsertEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	response.sendRedirect(request.getContextPath() + "/ad/manager");
    }
 
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
       try {   
    	   Connection conn = MyUtils.getStoredConnection(request);
        
           String msnv = request.getParameter("msnv");
           
           boolean check = DBUtilsAccount.checkInfo(conn, msnv);
           
           
           if(check) {
           
        	   String password = request.getParameter("password");
        	   
               String employees =  request.getParameter("employees");
               
               String office =  request.getParameter("office");
               
               String email =  request.getParameter("email");
               
               String salaryStr =  request.getParameter("salary");
               
               int salary = Integer.parseInt(salaryStr);
               
               String imageData = "\\Demo\\image\\" + msnv + ".png";
            
               UserAccount acc = new UserAccount(msnv, password, employees, office, email, salary, imageData);
        	   
               DBUtilsAccount.insertEmployee(conn, acc);
                
               response.sendRedirect(request.getContextPath() + "/ad/manager");
           }else {

        	   request.setAttribute("swear", "lưu ý: Tài khoản đã tồn tại");
        	  
        	   RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ad/manager");
   	        
     	       dispatcher.forward(request, response); 	   
           }
           
           
        }catch(Exception e) {
            
        	e.printStackTrace();
        }
    }
 
}
