package controller;

import javax.swing.JOptionPane;

public class RegisterUserController {

	public RegisterUserController() {
	}

	public void register() {
		// receber a view com os dados
		// validar os dados
		// persistir os dados no banco
	}

	public boolean validateName(String name) {
		if (name.length() < 12) {
			return name.matches("[A-Z][a-z]{1,}");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid name length, maximum 12 character");
			return false;
		}
	}
}
