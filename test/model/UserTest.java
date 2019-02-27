package model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import dao.ExpenseDAO;
import dao.UserDAO;

public class UserTest {

	public static void main(String[] args) {
		ExpenseDAO expdao = new ExpenseDAO();
		UserDAO usdao = new UserDAO();
		User user = new User();
		user = usdao.findUserByID(1);
		List<Expense> list = new LinkedList<>();
		LocalDate begin = LocalDate.of(2019,2,1);
		LocalDate end = LocalDate.of(2019,3,30);
				
		list = expdao.list(user, begin, end);
		for (Expense expense : list) {
			System.out.println(expense);
		}
	
	}
}
