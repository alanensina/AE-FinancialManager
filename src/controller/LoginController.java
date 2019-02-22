package controller;

import model.User;
import service.LoginService;

public class LoginController {
	LoginService service = new LoginService();

	public LoginController() {
	}

	public boolean receiveUser(User user) {
		return sendToService(user);
	}

	public boolean sendToService(User user) {
		return service.checkLogin(user);
	}

}
