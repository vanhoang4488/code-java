package demo.beans;

public class Income {
        
	private String month;
	private int totalex;
	private int totalre;
    private int netincome;
    
    
	public Income(String month, int totalex, int totalre, int netincome) {
		super();
		this.month = month;
		this.totalex = totalex;
		this.totalre = totalre;
		this.netincome = netincome;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public int getTotalex() {
		return totalex;
	}


	public void setTotalex(int totalex) {
		this.totalex = totalex;
	}


	public int getTotalre() {
		return totalre;
	}


	public void setTotalre(int totalre) {
		this.totalre = totalre;
	}


	public int getNetincome() {
		return netincome;
	}


	public void setNetincome(int netincome) {
		this.netincome = netincome;
	}
    
    
}
