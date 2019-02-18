package model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String birthday;
	private String username;
	private String password;
	private String profession;
	private boolean active;
	private List<Income> incomes;
	private List<Expense> expenses;	
	
	public User() {}	

	public User(String name, String surname, String phone, String email, String birthday, String username,
			String password, String profession, boolean active, List<Income> incomes, List<Expense> expenses) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.profession = profession;
		this.active = active;
		this.incomes = incomes;
		this.expenses = expenses;
	}
	
	public User(int id, String name, String surname, String phone, String email, String birthday, String username,
			String password, String profession, boolean active, List<Income> incomes, List<Expense> expenses) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.profession = profession;
		this.active = active;
		this.incomes = incomes;
		this.expenses = expenses;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
		return this.name + " " + this.surname;
	}	
}