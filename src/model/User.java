package model;

public class User extends People{
	private String login;
	private String password;
	private String profession;
	private boolean active;
	private boolean admin;
	
	private User() {}

	public User(String name, String surname, String phone, String email, String birthday, String login, String password, String profession, boolean active, boolean admin) {
		super(name, surname, phone, email, birthday);
		this.login = login;
		this.password = password;
		this.profession = profession;
		this.active = active;
		this.admin = admin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getSurname();
	}	
}