package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Expense;
import model.User;

public class ExpenseDAO {
	private Connection con = null;

	public ExpenseDAO() {
		con = ConnectionFactory.getConnection();
	}

	public void register(Expense expense, User user) {
		String sql = "insert into expense (user, name, description, value, date) values (?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, user.getId()); // Foreign key
			stmt.setString(2, expense.getName());
			stmt.setString(3, expense.getDescription());
			stmt.setDouble(4, expense.getValue());
			stmt.setString(5, expense.getDate());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error saving to database (ExpenseDAO.register())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
