package demo.beans;

import java.util.Date;

public class ThongTin {
    private Date date;
    private String msnv;
    private String empolyees;
    private String category;
    private String purpose;
    private int price;
    
	public ThongTin(Date date, String msnv, String empolyees, String category, String purpose, int price) {
		super();
		this.date = date;
		this.msnv = msnv;
		this.empolyees = empolyees;
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

	public String getMsnv() {
		return msnv;
	}

	public void setMsnv(String msnv) {
		this.msnv = msnv;
	}

	public String getEmpolyees() {
		return empolyees;
	}

	public void setEmpolyees(String empolyees) {
		this.empolyees = empolyees;
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
