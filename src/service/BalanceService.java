package service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ExpenseDAO;
import dao.IncomeDAO;
import model.Expense;
import model.Income;
import model.User;

public class BalanceService {

	public BalanceService() {
	}

	public boolean validateDate(LocalDate begin, LocalDate end) {
		if (begin.isBefore(end) || begin.isEqual(end)) {
			return true;
		}
		JOptionPane.showMessageDialog(null,
				"The period that you have selected is invalid. The start date is after the end date.");
		return false;
	}

	public List<Expense> getExpenses(User user, LocalDate begin, LocalDate end) {
		if (validateDate(begin, end)) {
			List<Expense> list = new LinkedList<Expense>();
			ExpenseDAO dao = new ExpenseDAO();
			list = dao.list(user, begin, end);

			return list;
		}
			return null; 
	}
	
	public List<Income> getIncomes(User user, LocalDate begin, LocalDate end) {
		if (validateDate(begin, end)) {
			List<Income> list = new LinkedList<Income>();
			IncomeDAO dao = new IncomeDAO();
			list = dao.list(user, begin, end);

			return list;
		}
			return null;
	}

}
