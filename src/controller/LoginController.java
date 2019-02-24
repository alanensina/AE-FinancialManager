package controller;

import model.User;
import service.LoginService;

public class LoginController {
	LoginService service = new LoginService();

	public LoginController() {
	}

	public boolean sendToService(User user) {
		return service.checkLogin(user);
	}
	
	public User getUserLogged(User user) {
		return service.getUser(user);
	}
	
}
