package repository;

import java.time.LocalDate;
import java.util.List;

import model.Income;
import model.User;

public interface IncomeRepository {

	public boolean register(Income income, User user);

	public boolean deleteByID(int id);
	
	public List<Income> list(Object obj, LocalDate begin, LocalDate end);

}
