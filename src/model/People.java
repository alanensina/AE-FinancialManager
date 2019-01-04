package model;

public abstract class People {
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String birthday;
	
	public People() {}

	public People(String name, String surname, String phone, String email, String birthday) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
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
}