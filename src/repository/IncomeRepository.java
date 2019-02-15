package repository;

import model.Income;
import model.User;

public interface IncomeRepository {

	public boolean register(Income income, User user);

	public boolean deleteByID(int id);

}
