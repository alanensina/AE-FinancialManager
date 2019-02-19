package controller;

import javax.swing.JOptionPane;

import model.User;
import service.LoginService;

public class LoginController {

	public LoginController() {}

	public void receiveUser(User user) {
		sendToService(user);
	}
	
	public static User sendToService(User user) {
		User userReturned = new User();
		LoginService service = new LoginService();
		userReturned = service.checkLogin(user);
		return userReturned;
	}
	
}
