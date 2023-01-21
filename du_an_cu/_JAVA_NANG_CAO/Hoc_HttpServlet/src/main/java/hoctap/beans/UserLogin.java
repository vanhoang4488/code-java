package hoctap.beans;

public class UserLogin {

	private String username;
	private String password;
	private String memberID;
	
	public UserLogin() {}

	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UserLogin(String username, String password, String memberID) {
		super();
		this.username = username;
		this.password = password;
		this.memberID = memberID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	
}
