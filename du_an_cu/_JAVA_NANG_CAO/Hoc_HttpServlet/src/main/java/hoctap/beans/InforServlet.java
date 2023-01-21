package hoctap.beans;

public class InforServlet {

	String servletName;
	String servletClass;
	String servletInfo;
	
	public InforServlet(String servletName, String servletClass, String servletInfo) {
		this.servletName = servletName;
		this.servletClass = servletClass;
		this.servletInfo = servletInfo;
	}

	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public String getServletClass() {
		return servletClass;
	}

	public void setServletClass(String servletClass) {
		this.servletClass = servletClass;
	}

	public String getServletInfo() {
		return servletInfo;
	}

	public void setServletInfo(String servletInfo) {
		this.servletInfo = servletInfo;
	}
	
	
}
