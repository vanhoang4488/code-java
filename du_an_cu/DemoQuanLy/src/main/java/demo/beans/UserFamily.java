package demo.beans;

public class UserFamily {

	
	private String msnv;
	private String userFamily;
	private String birthdayFamily;
	private String jobFamily;
	private String phoneFamily;
	private String child;
	
	
	public UserFamily(String msnv, String userFamily, String birthdayFamily, String jobFamily, String phoneFamily,
			String child) {
		super();
		this.msnv = msnv;
		this.userFamily = userFamily;
		this.birthdayFamily = birthdayFamily;
		this.jobFamily = jobFamily;
		this.phoneFamily = phoneFamily;
		this.child = child;
	}


	public String getMsnv() {
		return msnv;
	}


	public void setMsnv(String msnv) {
		this.msnv = msnv;
	}


	public String getUserFamily() {
		return userFamily;
	}


	public void setUserFamily(String userFamily) {
		this.userFamily = userFamily;
	}


	public String getBirthdayFamily() {
		return birthdayFamily;
	}


	public void setBirthdayFamily(String birthdayFamily) {
		this.birthdayFamily = birthdayFamily;
	}


	public String getJobFamily() {
		return jobFamily;
	}


	public void setJobFamily(String jobFamily) {
		this.jobFamily = jobFamily;
	}


	public String getPhoneFamily() {
		return phoneFamily;
	}


	public void setPhoneFamily(String phoneFamily) {
		this.phoneFamily = phoneFamily;
	}


	public String getChild() {
		return child;
	}


	public void setChild(String child) {
		this.child = child;
	}
	
	
	
	
}
