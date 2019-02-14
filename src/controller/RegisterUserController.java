package controller;

import javax.swing.JOptionPane;

public class RegisterUserController {

	public RegisterUserController() {
	}

	public void register() {

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
