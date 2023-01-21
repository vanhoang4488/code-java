package shopgiay.beans;

public class Product {
      
	private String productID;
	private String productName;
	private int[] categoryID;
	private String[] category;
	private int buyPrice;
	private int price;
	private int sale;
	private String description;
	private String[] size;
	private String[] image;
	
	public Product() {}

	public Product( String productName, int price, int sale, String[] image) {
		super();
		this.productName = productName;
		this.price = price;
		this.sale = sale;
		this.image = image;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productId) {
		this.productID = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getSize() {
		return size;
	}

	public void setSize(String[] size) {
		this.size = size;
	}

	public String[] getImage() {
		return image;
	}

	public void setImage(String[] image) {
		this.image = image;
	}

	public int[] getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int[] categoryID) {
		this.categoryID = categoryID;
	}
	
	
}
