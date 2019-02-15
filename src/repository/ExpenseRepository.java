package repository;

import model.Expense;
import model.User;

public interface ExpenseRepository {
	
	public boolean register(Expense expense, User user);

	public boolean deleteByID(int id);

}
