package controller;

import model.Expense;
import model.User;
import service.RegisterExpenseService;

public class RegisterExpenseController {
	RegisterExpenseService service = new RegisterExpenseService();
	private User user;
	
	public RegisterExpenseController(){}
	
	public RegisterExpenseController(User user){
		this.user = user;
	}
	
	public boolean sendToService(Expense expense, User user) {
		return service.getExpenseFromController(expense, user);
	}

}
