package hoc.enums;

public enum Rating {
	_1_SAO("G"), _2_SAO("PG"), _3_SAO("PG-13"), _4_SAO("R"), _5_SAO("NC-17");
	
	private String value;
	private Rating(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
