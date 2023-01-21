package hoctap.beans;

public class Header {

	private String headerName;
	private String headerInfo;
	public Header(String headerName, String headerInfo) {
		super();
		this.headerName = headerName;
		this.headerInfo = headerInfo;
	}
	public String getHeaderName() {
		return headerName;
	}
	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}
	public String getHeaderInfo() {
		return headerInfo;
	}
	public void setHeaderInfo(String headerInfo) {
		this.headerInfo = headerInfo;
	}
}
