package demo.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.beans.Product;
import demo.utils.DBUtils;
import demo.utils.MyUtils;

@WebServlet(urlPatterns= {"/createProduct"})
public class CreateProduct extends HttpServlet{

		private static final long serialVersionUID = 1L;
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			
			String queryString = request.getQueryString();
			
			if(queryString == null || queryString.isEmpty()) {

				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
				dispatcher.forward(request, response);
			}
			else {
			
				Connection conn = MyUtils.getStoreConnection(request);
				
				String code = (String) request.getParameter("code");
				String name = (String) request.getParameter("name");
				String priceStr = (String) request.getParameter("price");
				float price = 0;
				
				String errorString = null;
				
				if( priceStr != null && priceStr.matches("-?\\d+")  ) {
					price = Float.parseFloat(priceStr);
					if(price <= 0) {
						errorString = "price phải lớn hơn không!";
					}
				}else {
					errorString = "price phải là một số, không phải chuỗi và không rỗng!";
				}
				
				try {
					
					if(errorString == null) {
					
						if(code != null && !code.isEmpty()) {
							
							if(name != null && !name.isEmpty()) {
								
								Product product = new Product(code, name, price);
								
								DBUtils.insertProduct(conn, product);
							}else {
								
								errorString = "NAME null hoặc rỗng";
							}
							
						}else {
						
							errorString =  "CODE null hoặc rỗng!!";
						}
					}
					
					
					
				}catch(Exception ex) {
					ex.printStackTrace();
					errorString = ex.getMessage();
				}
					
				// Trong trường hợp suôn sẻ ta sẽ chuyển sang giao diện danh sách sản phẩm.
				if(errorString == null) {
					response.sendRedirect(request.getContextPath() + "/productList");
				}
				//Trường hợp xảy ra lỗi.
				else {
					
					request.setAttribute("errorString", errorString);
					
					RequestDispatcher dispatcher = this.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
					
					dispatcher.forward(request, response);
				}
			}
			
			
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			doGet(request, response);
		}
}
