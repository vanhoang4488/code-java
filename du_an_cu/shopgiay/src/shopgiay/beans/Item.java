package shopgiay.beans;

public class Item {
     
	 private String productID;
	 private String productName;
	 private String image;
	 private int price;
	 private int size;
	 private int quantity;
	
	public Item() {}

	
	
	
	public Item(String productID, String productName, int price, int size, int quantity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
	}




	public Item(String productID, String productName, String image, int price, int size) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.size = size;
	}

	public Item(String productID, String productName, String image, int price, int size, int quantity) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.image = image;
		this.price = price;
		this.size = size;
		this.quantity = quantity;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
