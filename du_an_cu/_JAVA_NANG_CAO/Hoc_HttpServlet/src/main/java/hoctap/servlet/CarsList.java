package hoctap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hoctap.beans.Car;
import hoctap.utils.ExecuteQuery;
import hoctap.utils.ModuleQuery;

@WebServlet("/carsList")
public class CarsList extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		Connection conn = ModuleQuery.getInstance().getConnection(request);
		
		List<Car> carsList = null;
		
		try {
			carsList = ExecuteQuery.getInstance().getCarsList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(carsList != null) request.setAttribute("carsList", carsList);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/carsList.jsp");
		
		dispatcher.forward(request, response);
	}
	
	//xử lý thay đổi hình ảnh minh họa của ô tô.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		doGet(request, response);
	}
}
