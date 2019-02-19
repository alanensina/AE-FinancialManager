package model;

import dao.UserDAO;

public class UserTest {

	public static void main(String[] args) {
	UserDAO dao = new UserDAO();
	User user = new User();
	user.setUsername("eaeae");
	User user2 = new User();
	
	user2 = dao.findUser(user);
	
	System.out.println(user2 + " " + user2.getPassword());
	
	
	
	}
}
