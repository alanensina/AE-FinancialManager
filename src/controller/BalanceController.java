package controller;

import java.time.LocalDate;
import java.util.List;

import model.Expense;
import model.Income;
import model.User;
import service.BalanceService;

public class BalanceController {
	BalanceService service = new BalanceService();
	
	public BalanceController() {}
	
	public List<Expense> getExpensesFromService(User user, LocalDate begin, LocalDate end){
		return service.getExpenses(user, begin, end);
	}
	
	public List<Income> getIncomeFromService(User user, LocalDate begin, LocalDate end){
		return service.getIncomes(user, begin, end);
	}
}
