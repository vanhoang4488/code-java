package demo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.utils.DBUtils;
import demo.utils.MyUtils;

@WebServlet(urlPatterns= {"/deleteProduct"})
public class DeleteProductServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoreConnection(request);
		
		String code = (String) request.getParameter("code");
		String errorString = null;
		
		try {
			DBUtils.deleteProduct(conn, code);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		//nếu mọi thứ tốt đẹp.
		//chuyển hướng sang trang danh sách sản phẩm.
		if(code != null && !code.isEmpty() && errorString == null) {
			response.sendRedirect(request.getContextPath() + "/productList");
		}
		// Nếu có lỗi, chuyển tiếp sang trang thông báo lỗi.
		else {
			//Lưu thông tin vào thông tin request trước khi chuyển tiếp sang views.
			request.setAttribute("errorString", errorString);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
			
			dispatcher.forward(request, response);
		}
				
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
