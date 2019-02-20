package service;

import javax.swing.JOptionPane;

public class SyntaxService {
	
	public SyntaxService() {}	
	
	/*
	 * A-Z a-z First letter must be uppercase Max: 12 characters
	 */
	public static boolean validateFirstName(String firstName) {
		if (firstName.length() <= 12) {
			return firstName.matches("[A-Z][a-z]{1,}");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid name length, maximum 12 characters");
			return false;
		}
	}

	/*
	 * A-Z a-z 0-9 Spaces Max: 40 characters
	 */
	public static boolean validateLastName(String lastName) {
		if (lastName.length() <= 40) {
			return lastName.matches("[a-zA-Z\\s]+");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid last name length, maximum 40 characters");
			return false;
		}
	}

	/*
	 * a-z 0-9
	 * 
	 * @ and - allowed Max: 40 characters
	 */
	public static boolean validateEmail(String email) {
		if (email.length() <= 40) {
			return email.matches("^[a-z0-9+_.-]+@(.+)$");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid email length, maximum 40 characters");
			return false;
		}
	}

	/*
	 * 0-9 Example: mm/dd/yyyy Max: 10 characters
	 */
	public static boolean validateData(String data) {
		if (data.length() <= 10) {
			return data.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid data length, maximum 10 characters");
			return false;
		}
	}

	/*
	 * A-Z a-z 0-9 Spaces Max: 80 characters
	 */
	public static boolean validateProfession(String profession) {
		if (profession.length() <= 80) {
			return profession.matches("[a-zA-Z0-9\\s]+");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid profession length, maximum 20 characters");
			return false;
		}
	}

	/*
	 * A-Z a-z 0-9 Max: 12 characters
	 */
	public static boolean validateUsername(String username) {
		if (username.length() <= 12) {
			return username.matches("[a-z0-9\\\\s]+");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid username length, maximum 12 characters");
			return false;
		}
	}

	/*
	 * A-Z a-z 0-9 Max: 12 characters
	 */
	public static boolean validatePassword(String password) {
		if (password.length() <= 12) {
			return password.matches("[a-zA-Z0-9\\\\s]+");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid password length, maximum 12 characters");
			return false;
		}
	}

	/*
	 * Ex: (xx) xxxxx-xxxx Max: 15 characters
	 */
	public static boolean validatePhone(String phone) {
		if (phone.length() <= 15) {
			return phone.matches("^\\([1-9]{2}\\) [2-9][0-9]{3,4}\\-[0-9]{4}$");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid phone length, maximum 12 characters");
			return false;
		}
	}

}
