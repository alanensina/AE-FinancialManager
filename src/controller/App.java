package controller;

import view.LoginScreen;

public class App {

	public static void main(String[] args) {

		 LoginScreen.main(args);
		RegisterUserController cont = new RegisterUserController();
		System.out.println(cont.validateName("Alan"));
	}

}