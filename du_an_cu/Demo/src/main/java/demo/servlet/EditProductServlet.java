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

import demo.beans.Product;
import demo.utils.DBUtils;
import demo.utils.MyUtils;

@WebServlet(urlPatterns= {"/editProduct"})
public class EditProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	//Hiển thị trang sửa sản phẩm.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoreConnection(request);
		
		String code = (String) request.getParameter("code");
		
		Product product = null;
		
		String errorString = null;
		
		if(code == null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
			
			product = DBUtils.findProduct(conn, code);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			errorString = ex.getMessage();
		}
		
		//Sản phẩm không tồn tại để edit.
		//Redrict sang trang danh sách sản phẩm.
		if(errorString != null && product == null) {
			response.sendRedirect(request.getServletPath() + "/productList.jsp"
					+ "");
			return;
		}
		
		//lưu thông tin vào thuộc tính request trước khi chuyển tiếp sang views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
		
		dispatcher.forward(request, response);
	}

	//Sau khi người dùng sửa đổi thông tin sản phẩm và bấm submit.
	//Phương thức này sẽ được thực thi.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoreConnection(request);
		
		String code = (String) request.getParameter("code");
		String name = (String) request.getParameter("name");
		String priceStr = (String) request.getParameter("price");
		float price = Float.parseFloat(priceStr);
		
		Product product = new Product(code, name, price);
		
		String errorString = null;
		
		try {
			DBUtils.updateProduct(conn, product);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		
		//lưu thông tin vào thuộc tính request trước khi chuyển tiếp sang views
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", product);
		
		//Nếu có lỗi chuyển tiếp sang trang edit.
		if(errorString == null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editProdcutViews.jsp");
			
			dispatcher.forward(request, response);
		}
		//Nếu mọi chuyện suôn sẻ thì chuyển sang trang danh sách sản phẩm.
		else {
			response.sendRedirect(request.getContextPath() + "/productList");
		}
	}
	
}
