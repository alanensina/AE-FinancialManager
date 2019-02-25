package service;

import static service.SyntaxService.validadeValue;
import static service.SyntaxService.validateSimpleText;

import dao.ExpenseDAO;
import model.Expense;
import model.User;

public class RegisterExpenseService {
	ExpenseDAO dao = new ExpenseDAO();
	User user = new User();

	public RegisterExpenseService(User user) {
		this.user = user;
	}

	public RegisterExpenseService() {
	}

	public boolean getExpenseFromController(Expense expense, User user) {
		return validateData(expense, user);
	}

	public boolean validateData(Expense expense, User user) {
		if (validateSimpleText(expense.getName()) && validadeValue(String.valueOf(expense.getValue()))
				&& expense.getDescription().length() <= 255) {
			dao.register(expense, user);
			return true;
		}
		return false;
	}

}
