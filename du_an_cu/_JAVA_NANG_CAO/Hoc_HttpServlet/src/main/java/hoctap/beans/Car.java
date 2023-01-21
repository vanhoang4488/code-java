package hoctap.beans;

public class Car {

	private String carID;
	private String carName;
	private double rate;
	private String description;
	private int price;
	private int quantily;
	private String imageUrl;
	
	public Car(String carID, String carName, double rate, String description, int price, int quantily,
			String imageUrl) {
		super();
		this.carID = carID;
		this.carName = carName;
		this.rate = rate;
		this.description = description;
		this.price = price;
		this.quantily = quantily;
		this.imageUrl = imageUrl;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantily() {
		return quantily;
	}

	public void setQuantily(int quantily) {
		this.quantily = quantily;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
