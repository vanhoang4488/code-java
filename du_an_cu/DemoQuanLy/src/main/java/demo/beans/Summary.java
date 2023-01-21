package demo.beans;

public class Summary {
      
	private int totalex;
	private int totalre;
	private int initbalance;
	private int currbalance;
	
	
	
	public Summary(int totalex, int totalre) {
		super();
		this.totalex = totalex;
		this.totalre = totalre;
	}

	public Summary(int totalex, int totalre, int initbalance) {
		super();
		this.totalex = totalex;
		this.totalre = totalre;
		this.initbalance = initbalance;
		this.currbalance = initbalance + totalre - totalex;
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

	public int getInitbalance() {
		return initbalance;
	}

	public void setInitbalance(int initbalance) {
		this.initbalance = initbalance;
	}

	public int getCurrbalance() {
		return currbalance;
	}

	public void setCurrbalance(int currbalance) {
		this.currbalance = currbalance;
	}
	
	
}
