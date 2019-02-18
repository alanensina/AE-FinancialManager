package model;

import javax.swing.JOptionPane;

import service.RegisterUserService;

public class UserTest {

	public static void main(String[] args) {
		String phone = "(xx) xxxxx-xxxx";
		System.out.println(phone.length());
		boolean result = RegisterUserService.validatePhone("(48) 99172-9538");
		System.out.println(result);

	}

	
	
	
}
