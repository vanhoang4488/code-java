package demo.servlet.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.beans.ThongTin;
import demo.utils.DBUtilsSpend;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = { "/ad/insertPlan" })
public class InsertPlan extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	response.sendRedirect(request.getContextPath() + "/ad/plan");
    }
 
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
       try {   
    	   Connection conn = MyUtils.getStoredConnection(request);
        
           String dateStr = request.getParameter("date");
        
           Date date = Date.valueOf(dateStr);
           String msnv = request.getParameter("msnv");
           String employees =  request.getParameter("employees");
           String category =  request.getParameter("category");
           String purpose =  request.getParameter("purpose");
           String priceStr =  request.getParameter("price");
           int price = Integer.parseInt(priceStr); 
        
           ThongTin tt = new ThongTin(date, msnv, employees, category, purpose, price);
            
           boolean check = DBUtilsSpend.checkInsert(conn, date, msnv, category, purpose);
           
           if(check) {
           
                DBUtilsSpend.insertTblChi(conn, tt);
                
                response.sendRedirect(request.getContextPath() + "/ad/plan");
           }else {

        	   request.setAttribute("swear", "lưu ý: Giao dịch đã tồn tại");
        	  
        	   RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ad/plan");
   	        
     	       dispatcher.forward(request, response); 	   
           }
           
           
        }catch(Exception e) {
            
        	e.printStackTrace();
        }
    }
 
}
