package demo.beans;

public class UserAccount {
     
	private String msnv;
	private String pass;
	private String userName;
	private String office;
	private String email;
	private int salary;
	private String imageData;
	
	public UserAccount() {
		super();
		this.msnv = "";
		this.pass = "";
		this.office = "";
		this.userName = "";
	}

	
	public UserAccount(String msnv, String pass, String userName, String office, String email, int salary,
			String imageData) {
		super();
		this.msnv = msnv;
		this.pass = pass;
		this.userName = userName;
		this.office = office;
		this.email = email;
		this.salary = salary;
		this.imageData = imageData;
	}


	public UserAccount(String msnv, String pass, String userName, String office, String email, int salary) {
		super();
		this.msnv = msnv;
		this.pass = pass;
		this.userName = userName;
		this.office = office;
		this.email = email;
		this.salary = salary;
	}

	public UserAccount(String msnv, String userName, String office, String email, int salary) {
		super();
		this.msnv = msnv;
		this.userName = userName;
		this.office = office;
		this.email = email;
		this.salary = salary;
	}	

	
	
	public UserAccount(String msnv, String userName, String office, String email, int salary, String imageData) {
		super();
		this.msnv = msnv;
		this.userName = userName;
		this.office = office;
		this.email = email;
		this.salary = salary;
		this.imageData = imageData;
	}


	public UserAccount(String msnv, String pass, String office, String userName) {
		super();
		this.msnv = msnv;
		this.pass = pass;
		this.office = office;
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getImageData() {
		return imageData;
	}


	public void setImageData(String imageData) {
		this.imageData = imageData;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getMsnv() {
		return msnv;
	}


	public void setMsnv(String msnv) {
		this.msnv = msnv;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getOffice() {
		return office;
	}


	public void setOffice(String office) {
		this.office = office;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
