package service;

import static service.DaoService.sucess;
import static service.DaoService.wrongLogin;

import java.util.LinkedList;
import java.util.List;

import dao.UserDAO;
import model.User;
import view.MainScreen;

public class LoginService {
	UserDAO dao = new UserDAO();

	public LoginService() {
	}

	public boolean checkLogin(User user) {
		List<User> list = new LinkedList<>();
		list = dao.list();
		String[] argumentos = new String[1]; // Gambiarra
		
		for (User user2 : list) {
			if (user2.getUsername().equals(user.getUsername()) && user2.getPassword().equals(user.getPassword())) {
				sucess();
				// Instanciar a tela principal da aplicação com o usuário retornado como token
			new MainScreen(user2).main(argumentos);
			
			return true;
			}
		}
			wrongLogin();
			return false;
	}

}
