package service;

import static service.DaoService.*;

import java.util.LinkedList;
import java.util.List;

import dao.UserDAO;
import model.User;

public class LoginService {
	UserDAO dao = new UserDAO();
	User userLogged = new User();

	public LoginService() {
	}

	public boolean checkLogin(User user) {
		List<User> list = new LinkedList<>();
		list = dao.list();
		
		if(emptyFieldsOnLoginScreen(user)) {
			emptyLogin();
			return false;
		}

		for (User user2 : list) {
			if (checkLoginAndPassword(user, user2)) {
				return true;
			}
		}
		wrongLogin();
		return false;
	}
	
	public boolean checkLoginAndPassword(User user, User user2) {
		return user2.getUsername().equals(user.getUsername()) && user2.getPassword().equals(user.getPassword());
	}
	
	public boolean emptyFieldsOnLoginScreen(User user) {
		return user.getUsername().equals("") || user.getPassword().equals("");
	}
	
	public User getUser(User user) {
		List<User> list = new LinkedList<>();
		
		list = dao.list();
		User userLogged = new User();
		
		for (User user2 : list) {
			if (checkLoginAndPassword(user, user2)) {
				userLogged = user2;
			}
		}
		
		return userLogged;
	}

}
