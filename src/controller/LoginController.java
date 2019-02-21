package controller;

import model.User;
import service.LoginService;

public class LoginController {
	LoginService service = new LoginService();

	public LoginController() {
	}

	public void receiveUser(User user) {
		sendToService(user);
	}

	public void sendToService(User user) {
		service.checkLogin(user);
	}

}
