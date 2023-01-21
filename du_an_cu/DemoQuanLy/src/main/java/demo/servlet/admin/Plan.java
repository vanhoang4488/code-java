package demo.servlet.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.beans.Pair;
import demo.beans.ThongTin;
import demo.utils.DBUtils;
import demo.utils.DBUtilsSpend;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = {"/ad/plan"})
public class Plan extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
    	try {
    		
    	  Connection conn = MyUtils.getStoredConnection(request);
    	    	  
    	  LocalDate date1 = LocalDate.now().plusDays(1);
    	  
    	  LocalDate date2 = date1.plusMonths(1);
    	  
    	  String date1Str = date1.format(DateTimeFormatter.ISO_LOCAL_DATE);
    	  
    	  String date2Str = date2.format(DateTimeFormatter.ISO_LOCAL_DATE);
    	  
    	  System.out.println(date1Str + " " + date2Str);
    	  
          ArrayList<ThongTin> list = DBUtilsSpend.querySpending(conn, date1Str, date2Str, "");
    	 
    	  request.setAttribute("departments", list); 
    	  
          ArrayList<Pair> list2 = DBUtils.veBD(conn, date1Str, date2Str);
          
    	  request.setAttribute("Pair", list2); 

	      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/plan.jsp");
	        
	      dispatcher.forward(request, response);
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    	}catch(ClassNotFoundException ex) {
    		ex.printStackTrace();
    	}
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	 
}

