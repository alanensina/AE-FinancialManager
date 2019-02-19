package service;

import javax.swing.JOptionPane;

import dao.UserDAO;
import model.User;

public class LoginService {

	public LoginService() {
	}

	public User checkLogin(User user) {
		
		
		
		
		return null;
	}

	public static boolean checkPassword(User userLogin, User userDB) {
		return userLogin.getPassword().equals(userDB.getPassword());
	}

}
