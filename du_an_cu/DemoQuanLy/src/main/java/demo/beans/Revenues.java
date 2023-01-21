package demo.beans;

import java.util.Date;

public class Revenues {
      
	private Date date;
	private String revenues;
	private String category;
	private String purpose;
	private int price;
	
	
	
	public Revenues(Date date, String revenues, String category, String purpose, int price) {
		super();
		this.date = date;
		this.revenues = revenues;
		this.category = category;
		this.purpose = purpose;
		this.price = price;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getRevenues() {
		return revenues;
	}



	public void setRevenues(String revenues) {
		this.revenues = revenues;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getPurpose() {
		return purpose;
	}



	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
