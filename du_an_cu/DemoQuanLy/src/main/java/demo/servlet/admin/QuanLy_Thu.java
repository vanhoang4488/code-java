package demo.servlet.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.beans.Pair;
import demo.beans.Revenues;
import demo.utils.DBUtils;
import demo.utils.DBUtilsCollection;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = {"/ad/quanlythu"})
public class QuanLy_Thu extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
    	try {
    		
    	  Connection conn = MyUtils.getStoredConnection(request);
    	  
    	  String word = request.getParameter("search_text");
    	  
    	  if(word == null) { word = ""; }
    	  
    	  String date1 = request.getParameter("chooseday1");
    	  
    	  String date2 = request.getParameter("chooseday2");
    	  
    	  if(date1 == null ||date1.isEmpty() || date2 == null || date2.isEmpty()) {
    		  int intmonth = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) +1;
    		
    		  String month = String.valueOf(intmonth);
    		  
    		  if(intmonth < 10) month = "0" + month;
    		  
    	      int intyear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    			
    	      date1 = String.valueOf(intyear) + "-" + month + "-01";
    	        	      
    	      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	      
    	      Date date = new Date();
    			
    	      date2 = formatter.format(date);
    	  }
    	  
    	  request.setAttribute("date1", date1);
    	  
    	  request.setAttribute("date2", date2);
    	  
          ArrayList<Revenues> list = DBUtilsCollection.queryCollection(conn, date1, date2, word);
    	  
    	  request.setAttribute("departments", list); 
    	  
          ArrayList<Pair> list2 = DBUtils.veBD2(conn, date1, date2);
          
    	  request.setAttribute("Pair", list2); 

	      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/quanli_thu.jsp");
	        
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
