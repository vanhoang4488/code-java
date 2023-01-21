package content;

public class UserInfo {
	public String userName;
	public int post;
	public String country;
	
	public UserInfo(String userName, String country, int post) {
		this.userName = userName;
		this.country = country;
		this.post = post;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
