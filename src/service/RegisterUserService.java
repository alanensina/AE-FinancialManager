package service;

import javax.swing.JOptionPane;

import static service.SyntaxService.*;
import dao.UserDAO;
import model.User;

public class RegisterUserService {
	private static UserDAO dao = new UserDAO();

	public RegisterUserService() {
	}

	public boolean validateUser(User user) {
		if (validateFirstName(user.getName()) && validateLastName(user.getSurname()) && validateEmail(user.getEmail())
				&&  validateProfession(user.getProfession())
				&& validateUsername(user.getUsername()) && validatePassword(user.getPassword())
				&& validatePhone(user.getPhone())) {
			dao.register(user);
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"There was an error saving to database (RegisterUserService.validateUser)");
			throw new RuntimeException();
		}
	}

}