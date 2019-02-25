package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Expense implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private User user;
	private String name;
	private String description;
	private double value;
	private LocalDate date;
	
	public Expense() {}

	public Expense(String name, String description, double value, LocalDate date) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.date = date;
	}
	
	public Expense(int id, User user, String name, String description, double value, LocalDate date) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.description = description;
		this.value = value;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return this.name;
	}
}