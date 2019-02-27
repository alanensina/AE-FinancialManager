package repository;

import java.time.LocalDate;
import java.util.List;

import model.Expense;
import model.User;

public interface ExpenseRepository {
	
	public boolean register(Expense expense, User user);

	public boolean deleteByID(int id);
	
	public List<Expense> list(Object obj, LocalDate begin, LocalDate end);

}
