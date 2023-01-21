package javaBean;

public class HelloBean {
    private String name;
    private String ello;
    
    public void setEllo(String hello) {
		this.ello = hello;
	}

	public String getEllo() {
		return ello;
	}

	public HelloBean() {}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	public String getHello() {
		if(name == null)
			return "hello every body";
		else
			return "hello" + name;
	}
}
