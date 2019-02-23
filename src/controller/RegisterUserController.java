package controller;

import model.User;
import service.RegisterUserService;

public class RegisterUserController {
	private static RegisterUserService service = new RegisterUserService();

	public RegisterUserController() {
	}

	public void receiveUser(User user) {
		sendToService(user);
	}

	public static void sendToService(User user) {
		service.validateUser(user);
	}
}
