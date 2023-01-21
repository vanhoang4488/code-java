package shopgiay.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopgiay.beans.Cart;
import shopgiay.utils.CheckUtils;
import shopgiay.utils.MyUtils;

@WebServlet(urlPatterns = { "/cart"})
public class ServletCart extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
	   public ServletCart() {
	       super();
	   }
	 
	   @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
		   String check = request.getParameter("cart_action");
		   
		   if(check != null) {
			   String action = check.split("-")[0];
			   String productID = check.split("-")[1];
			   int size = Integer.parseInt( check.split("-")[2] );
			   int new_quantity = Integer.parseInt( request.getParameter(productID) );
		       
		       HttpSession session = request.getSession();   
		       Cart cart = MyUtils.getCartSession(session);
		       String key = productID + "-" + size;
		       
		       int old_quantity = cart.getCartItems().get(key).getQuantity();
		       
		       if(new_quantity >= 1 ) {
		    	   if(new_quantity != old_quantity) {
			    	   if( CheckUtils.checkQuantity(productID, size, new_quantity) ) {
				    		  cart.getCartItems().get(key).setQuantity(new_quantity);
				    	   
				       }
			       
			       }else if( action.equals("decrease") ) {
			    	   if(new_quantity >= 2) {
			    	         cart.getCartItems().get(key).setQuantity(old_quantity - 1);
			    	   }
			       }else if( action.equals("increase") ){	    	   
			    	   
			    	   if( CheckUtils.checkQuantity(productID, size, old_quantity + 1) ) {
			    		  cart.getCartItems().get(key).setQuantity(old_quantity + 1);
			    	   
			    	   }
			       
			        }
			       
			       
            	           MyUtils.setCartSession(session, cart);
			      }
		     }
	  
	            
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/fontEnd/cart.jsp");
	        
	       dispatcher.forward(request, response);
	        
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       doGet(request, response);
	   }
}
