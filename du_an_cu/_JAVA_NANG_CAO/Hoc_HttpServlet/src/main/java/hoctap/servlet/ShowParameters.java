package hoctap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hoctap.beans.Parameter;

@WebServlet(urlPatterns= {"/Parameters"})
public class ShowParameters extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/input_parameters.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String title = "Hiển thị tất cả các thuộc tính của request";
		request.setAttribute("title", title);
		
		Enumeration<String> paraNames = request.getParameterNames();
		//mảng lưu trữ tất cả tham số Parameter.
		List<Parameter> parameters = new ArrayList<>();
		/*
		 * lý do: phải tạo ra mảng khác lưu trữ tất cả
		 * mà không phải đơn giản là gửi luông Enumeration<String> paraNames sang luôn vì:
		 * paraNames chỉ 1 chuỗi String các tên tham số thôi, nếu chuyển mỗi paraNames sang thì
		 * các giá trị value tương ứng với tứng tham  số không được chuyển sang.
		 */
		while(paraNames.hasMoreElements()) {
			String name = paraNames.nextElement();
			String[] values = request.getParameterValues(name);
			parameters.add(new Parameter(name, values));
		}
		
		request.setAttribute("parameters", parameters);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/show_parameters.jsp");
		dispatcher.forward(request, response);	
	}
	
}
