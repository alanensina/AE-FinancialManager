package service;

import static service.SyntaxService.validadeValue;
import static service.SyntaxService.validateSimpleText;

import dao.IncomeDAO;
import model.Income;
import model.User;

public class RegisterIncomeService {
	IncomeDAO dao = new IncomeDAO();
	User user = new User();

	public RegisterIncomeService(User user) {
		this.user = user;
	}

	public RegisterIncomeService() {
	}

	public boolean getIncomeFromController(Income income, User user) {
		return validateData(income, user);
	}

	public boolean validateData(Income income, User user) {
		if (validateSimpleText(income.getName()) && validadeValue(String.valueOf(income.getValue()))
				&& SyntaxService.validateData(income.getDate()) && income.getDescription().length() <= 255) {
			dao.register(income, user);
			return true;
		}
		return false;
	}

}
