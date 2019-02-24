package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Expense;
import model.User;
import repository.ExpenseRepository;

public class ExpenseDAO implements ExpenseRepository {
	private Connection con = null;

	public ExpenseDAO() {}

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
			stmt.setString(5, expense.getDate());
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
}
