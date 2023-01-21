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

import demo.beans.Revenues;
import demo.utils.DBUtilsCollection;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = { "/ad/insertCollection" })
public class InsertCollection extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	response.sendRedirect(request.getContextPath() + "/ad/quanlythu");
    }
 
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
       try {   
    	   Connection conn = MyUtils.getStoredConnection(request);
        
           String dateStr = request.getParameter("date");
        
           Date date = Date.valueOf(dateStr);
           String revenues = request.getParameter("revenues");
           String category =  request.getParameter("category");
           String purpose =  request.getParameter("purpose");
           String priceStr =  request.getParameter("price");
           int price = Integer.parseInt(priceStr); 
        
           Revenues tt = new Revenues(date, revenues, category, purpose, price);
            
           boolean check = DBUtilsCollection.checkInsert(conn, date, revenues);
           
           if(check) {
           
                DBUtilsCollection.insertTblThu(conn, tt);
                
                response.sendRedirect(request.getContextPath() + "/ad/quanlythu");
           }else {

        	   request.setAttribute("swear", "lưu ý: Giao dịch đã tồn tại");
        	  
        	   RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ad/quanlythu");
   	        
     	       dispatcher.forward(request, response); 	   
           }
           
           
        }catch(Exception e) {
            
        	e.printStackTrace();
        }
    }
 
}
