package service;

import static service.DaoService.sucess;
import static service.DaoService.wrongLogin;

import java.util.LinkedList;
import java.util.List;

import dao.UserDAO;
import model.User;

public class LoginService {
	UserDAO dao = new UserDAO();

	public LoginService() {
	}

	public void checkLogin(User user) {
		List<User> list = new LinkedList<>();
		list = dao.list();

		for (User user2 : list) {
			if (user2.getUsername().equals(user.getUsername()) && user2.getPassword().equals(user.getPassword())) {
				sucess();
				// Instanciar a tela principal da aplicação com o usuário retornado como token
			}
		}
		wrongLogin();
	}

	public static boolean checkPassword(User userLogin, User userDB) {
		return userLogin.getPassword().equals(userDB.getPassword());
	}

}
