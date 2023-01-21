package hoctap.beans;

public class Parameter {
	
	private String name;
	private String[] values;
	
	public Parameter(String name, String[] values) {
		this.name = name;
		this.values = values;
	}

	public int getValuesLength() {
		return values.length;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}
}
