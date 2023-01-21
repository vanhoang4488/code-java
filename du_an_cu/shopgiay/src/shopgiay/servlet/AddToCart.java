package shopgiay.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopgiay.beans.Cart;
import shopgiay.beans.Item;
import shopgiay.utils.CheckUtils;
import shopgiay.utils.MyUtils;
import shopgiay.utils.ResultsUtils;

@WebServlet(urlPatterns = { "/addToCart"})
public class AddToCart extends HttpServlet {
     
	private static final long serialVersionUID = 1L;
	 
	   public AddToCart() {
	       super();
	   }
	 
	   @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       
		   HttpSession session = request.getSession();
	       String productID = request.getParameter("productID");
	       String productName = request.getParameter("productName");
	       String image = request.getParameter("image_product");
		   int size = Integer.parseInt(request.getParameter("size"));
		   int price = Integer.parseInt(request.getParameter("price"));
		   boolean flag = request.getParameter("quantity").matches("\\d");
		   if(flag) {
			   int new_quantity = Integer.parseInt(request.getParameter("quantity"));
			   if(new_quantity >= 1) {
				    
				    int amount = ResultsUtils.getQuantity(productID, size);
					Cart cart = MyUtils.getCartSession(session);
					Item item = new Item();
		    		item.setProductID(productID);
		    		item.setProductName(productName);
		    		item.setPrice(price);
		    		item.setImage(image);
		    		item.setSize(size);
		    		
				    if(cart == null) {
				    	cart = new Cart();
				    	item.setQuantity(new_quantity);
				    }else {
				       
				    	String key = productID + "-" + size;
				    	//Kiểm tra sản phẩm đã có trong giỏ hàng hay chưa
				    	boolean  check = cart.getCartItems().containsKey(key);
				    	//Nếu sản phẩm có trong giỏ hàng rồi thì kiểm tra tổng số lượng cũ và mới có hợp lệ hay k?
				    	if(check) {
				    		int old_quantity = cart.getCartItems().get(key).getQuantity();
				    		int quantity = new_quantity + old_quantity;
				    		
				    		if(quantity <= amount ) {
				    			item.setQuantity(new_quantity);
				    		}else if(quantity > amount) {
				    			item.setQuantity(0);
				    			request.setAttribute("notice", "Sản phẩm " + productName + "-size:" + size + "chỉ còn lại " + amount + "sản phẩm");
				    		}
				    	}
				    }
				   
				    cart.insertToCart(item);
				    MyUtils.setCartSession(session, cart);
			   }
		   }
		   response.sendRedirect(request.getContextPath() + "/product?productID=" + productID);
	       
	        
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       doGet(request, response);
	   }
}
