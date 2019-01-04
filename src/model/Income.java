package model;

public class Income {
	private String name;
	private String description;
	private double value;
	private String date;
	
	public Income() {}

	public Income(String name, String description, double value, String date) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return this.name;
	}	
}