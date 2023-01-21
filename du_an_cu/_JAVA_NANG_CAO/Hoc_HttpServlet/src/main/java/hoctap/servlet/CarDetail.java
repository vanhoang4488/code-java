package hoctap.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hoctap.beans.Car;
import hoctap.utils.ExecuteQuery;
import hoctap.utils.ModuleQuery;

@WebServlet("/carDetail")
public class CarDetail extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String carID = request.getParameter("carID");
		
		Connection conn = ModuleQuery.getInstance().getConnection(request);
		
		Car car = null;
		
		try {
			car = ExecuteQuery.getInstance().getCarDetail(conn, carID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(car == null) {
			response.sendRedirect(request.getContextPath() + "/carsList");
			return;
		}
		
		request.setAttribute("car", car);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/cardetail.jsp");
		
		dispatcher.forward(request, response);
	}
	
	//xử lý thay đổi hình ảnh minh họa của ô tô.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String carID = request.getParameter("carID");

		Connection conn = ModuleQuery.getInstance().getConnection(request);
		
		String imageUrl = request.getParameter("imageUrl");
		
		if(imageUrl != null && !imageUrl.matches(".*\\.png|.*\\.jpg|.*\\.jpeg")) {
			
			request.setAttribute("notice", "File hình ảnh không hợp lệ, file phải có đuôi là .png|.jpg|.jpeg");
		}else {
			
			//tách chuỗi vỡi ký tự phân tách là: \
			String[] arr = imageUrl.split("\\\\");
			
			imageUrl = ".." + request.getContextPath() + "/image/" + arr[arr.length-1];
			
			try {
				ExecuteQuery.getInstance().setImageUrl(conn, imageUrl, carID);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		Car car = null;
		try {
			car = ExecuteQuery.getInstance().getCarDetail(conn, carID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("car", car);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/cardetail.jsp");
		dispatcher.forward(request, response);
	}
}
