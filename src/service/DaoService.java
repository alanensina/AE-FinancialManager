package service;

import javax.swing.JOptionPane;

import model.User;

public class DaoService {

	public DaoService() {
		
	}
	
	public void emptyFields(User user) {
		if (user.getName() == null) {
			JOptionPane.showMessageDialog(null, "Name is empty");
		}
		if (user.getSurname() == null) {
			JOptionPane.showMessageDialog(null, "Surname is empty");
		}
		if (user.getPhone() == null) {
			JOptionPane.showMessageDialog(null, "Phone is empty");
		}
		if (user.getEmail() == null) {
			JOptionPane.showMessageDialog(null, "Email is empty");
		}
		if (user.getBirthday() == null) {
			JOptionPane.showMessageDialog(null, "Birthday is empty");
		}
		if (user.getUsername() == null) {
			JOptionPane.showMessageDialog(null, "Username is empty");
		}
		if (user.getPassword() == null) {
			JOptionPane.showMessageDialog(null, "Password is empty");
		}
		if (user.getProfession() == null) {
			JOptionPane.showMessageDialog(null, "Profession is empty");
		}
	}
	
	public static void wrongLogin() {
		JOptionPane.showMessageDialog(null, "Username or password doesn't match.");
	}
	
	public static void userNotFound() {
		JOptionPane.showMessageDialog(null, "User not found!");
	}
	
	public static void emptyLogin() {
		JOptionPane.showMessageDialog(null, "One or more fields are empty.");
	}
}
