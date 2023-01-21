package hoc.enums;

public enum Features {

	S1("Trailer"), S2("Commentaries"), S3("Deleted Scenes"), S4("Behind the Scenes");
	
	private String value;
	private Features(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
