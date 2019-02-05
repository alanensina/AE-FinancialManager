package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Income;
import model.User;

public class IncomeDAO {
	private Connection con = null;

	public IncomeDAO() {
		con = ConnectionFactory.getConnection();
	}

	public void register(Income income, User user) {
		String sql = "insert into income (user, name, description, value, date) values (?, ?, ?, ?, ?)";
		UserDAO dao = new UserDAO();
		user.setId(dao.findID(user.getUsername()));		

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, user.getId()); // Foreign key
			stmt.setString(2, income.getName());
			stmt.setString(3, income.getDescription());
			stmt.setDouble(4, income.getValue());
			stmt.setString(5, income.getDate());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error saving to database (IncomeDAO.register())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void deleteByID(int id) {
		String sql = "delete from income where id = ?";
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error deleting from the database (IncomeDAO.deleteByID())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}		
	}
	
}
