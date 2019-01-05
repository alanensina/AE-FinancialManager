package model;

import java.util.List;

public class User extends People{
	private String username;
	private String password;
	private String profession;
	private boolean active;
	private List<Income> incomes;
	private List<Expense> expenses;	
	
	public User() {}

	public User(String name, String surname, String phone, String email, String birthday, String username, String password, String profession, boolean active, boolean admin, List<Income> incomes, List<Expense> expenses) {
		super(name, surname, phone, email, birthday);
		this.username = username;
		this.password = password;
		this.profession = profession;
		this.active = active;
		this.incomes = incomes;
		this.expenses = expenses;		
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}	
	
	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getSurname();
	}	
}