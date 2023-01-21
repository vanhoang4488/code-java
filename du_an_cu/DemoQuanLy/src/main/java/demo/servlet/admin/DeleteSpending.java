package demo.servlet.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.utils.DBUtilsSpend;
import demo.utils.MyUtils;

@WebServlet(urlPatterns = {"/ad/deleteSpending"})
public class DeleteSpending extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
    	  
    	response.sendRedirect(request.getContextPath() + "/ad/quanlychi");
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		try {
	    	  Connection conn = MyUtils.getStoredConnection(request);
	    	  
              String result = request.getParameter("inter");
              
	    	  DBUtilsSpend.deleteTblChi(conn, result);
	    	   	  
		      response.sendRedirect(request.getContextPath() + "/ad/quanlychi");
	    	}catch(SQLException ex) {
	    		ex.printStackTrace();
	    	}
	}
	
	
	 
}
