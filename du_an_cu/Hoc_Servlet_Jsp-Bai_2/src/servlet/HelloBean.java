package servlet;

public class HelloBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getHello() {
		if(name == null) return "Hello every body";
		else return "Hello" + name;
	}
}
