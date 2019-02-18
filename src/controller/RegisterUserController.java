package controller;

import javax.swing.JOptionPane;

import dao.UserDAO;
import model.User;
import service.RegisterUserService;

public class RegisterUserController {

	public RegisterUserController() {
	}

	public void receiveUser(User user) {
		sendToService(user);
	}

	public static void sendToService(User user) {
		RegisterUserService service = new RegisterUserService();
		User userReceived = service.validateUser(user);
		persist(userReceived);
	}
	
	public static void persist(User user) {
		UserDAO dao = new UserDAO();
		Object obj = user;
		if(dao.register(obj)) {
			JOptionPane.showMessageDialog(null, "Welcome "+user.toString()+", now you can log in to the system!");
		} else {
			JOptionPane.showMessageDialog(null, "There was an error saving to database (RegisterUserController.persist)");
		}
	}
}
