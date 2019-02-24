package controller;

import model.Income;
import model.User;
import service.RegisterIncomeService;

public class RegisterIncomeController {
	RegisterIncomeService service = new RegisterIncomeService();
	private User user;
	
	public RegisterIncomeController(){}
	
	public RegisterIncomeController(User user){
		this.user = user;
	}
	
	public boolean sendToService(Income income, User user) {
		return service.getIncomeFromController(income, user);
	}
}
