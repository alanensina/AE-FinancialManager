package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Expense;
import model.User;
import repository.ExpenseRepository;

public class ExpenseDAO implements ExpenseRepository {
	private Connection con = null;

	public ExpenseDAO() {
	}

	@Override
	public boolean register(Expense expense, User user) {
		con = ConnectionFactory.getConnection();
		String sql = "insert into expense (user, name, description, value, date) values (?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, user.getId());
			stmt.setString(2, expense.getName());
			stmt.setString(3, expense.getDescription());
			stmt.setDouble(4, expense.getValue());
			stmt.setDate(5, Date.valueOf(expense.getDate()));
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Expense registered successfully!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error saving to database (ExpenseDAO.register())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return true;
	}

	@Override
	public boolean deleteByID(int id) {
		con = ConnectionFactory.getConnection();
		String sql = "delete from expense where id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"There was an error deleting from the database (ExpenseDAO.deleteByID())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return true;
	}

	@Override
	public List<Expense> list(Object obj, LocalDate begin, LocalDate end) {
		User user = new User();
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = "select * from expense where user = ? and date between ? and ?";
		ResultSet rs = null;
		List<Expense> list = new LinkedList<>();

		if (obj instanceof User) {
			user = (User) obj;
		} else {
			JOptionPane.showMessageDialog(null, "Object is not an instance of User. Method: ExpenseDAO.list()");
		}

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			stmt.setDate(2, Date.valueOf(begin));
			stmt.setDate(3, Date.valueOf(end));
			rs = stmt.executeQuery();
		
			while (rs.next()) {

				Expense exp = new Expense();
				exp.setUser(user);
				exp.setName(rs.getString("name"));
				exp.setDescription(rs.getString("description"));
				exp.setDate(rs.getDate("date").toLocalDate()); 

				list.add(exp);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error list all data from database (ExpenseDAO)" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return list;
	}
}
