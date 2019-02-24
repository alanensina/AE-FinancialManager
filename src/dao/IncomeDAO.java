package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Income;
import model.User;
import repository.IncomeRepository;

public class IncomeDAO implements IncomeRepository {
	private Connection con = null;

	public IncomeDAO() {}

	@Override
	public boolean register(Income income, User user) {
		con = ConnectionFactory.getConnection();
		String sql = "insert into income (user, name, description, value, date) values (?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, user.getId()); // Foreign key
			stmt.setString(2, income.getName());
			stmt.setString(3, income.getDescription());
			stmt.setDouble(4, income.getValue());
			stmt.setString(5, income.getDate());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Income registered successfully!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error saving to database (IncomeDAO.register())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return true;
	}

	@Override
	public boolean deleteByID(int id) {
		con = ConnectionFactory.getConnection();
		String sql = "delete from income where id = ?";
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"There was an error deleting from the database (IncomeDAO.deleteByID())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return true;
	}
}
