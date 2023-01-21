package shopgiay.beans;

import java.util.HashMap;
import java.util.Map.Entry;

public class Cart {

   private HashMap<String, Item> cartItems;
   private int count = 0;

   public Cart() {
       cartItems = new HashMap<>();
       count = 0;
   }

   public Cart(HashMap<String, Item> cartItems) {
       this.cartItems = cartItems;
   }
   
   public HashMap<String, Item> getCartItems() {
       return cartItems;
   }

   public int getCount() {
	  return count;
   }

   public void setCount(int count) {
	  this.count = count;
   }

   public void setCartItems(HashMap<String, Item> cartItems) {
       this.cartItems = cartItems;
   }
   
   
   public void insertToCart(Item item) {
	   String key = item.getProductID() + "-" + item.getSize();
       boolean bln = cartItems.containsKey(key);
       if (bln) {
            int quantity_old = cartItems.get(key).getQuantity();
            item.setQuantity(quantity_old + item.getQuantity());
            cartItems.put(key, item);
       } else {
            cartItems.put(key, item);
            count++;
       }
   }
   
   public void removeToCart(String product) {
       boolean bln = cartItems.containsKey(product);
       if (bln) {
           cartItems.remove(product);
           count--;
       }
   }
   
   
   public int countItem() {
       count = cartItems.size();
       return count;
   }  
   
   public double total() {
       int total = 0;
       for (Entry<String, Item> list : cartItems.entrySet()) {
           total += list.getValue().getPrice() * list.getValue().getQuantity();
       }
       return total;
   }
   
   
   public String toString() {
	   String str = null;
	  for(Item item : cartItems.values()) {
		  str += item.toString() + ",";
	  }
	  str = str.substring(0, str.length() - 2);
	  return str;
   }
}
