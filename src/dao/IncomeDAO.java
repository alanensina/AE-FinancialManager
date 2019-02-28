package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Expense;
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
			stmt.setInt(1, user.getId()); 
			stmt.setString(2, income.getName());
			stmt.setString(3, income.getDescription());
			stmt.setDouble(4, income.getValue());
			stmt.setDate(5, Date.valueOf(income.getDate()));
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
	
	@Override
	public List<Income> list(Object obj, LocalDate begin, LocalDate end) {
		User user = new User();
		con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = "select * from income where user = ? and date between ? and ?";
		ResultSet rs = null;
		List<Income> list = new LinkedList<>();

		if (obj instanceof User) {
			user = (User) obj;
		} else {
			JOptionPane.showMessageDialog(null, "Object is not an instance of User. Method: IncomeDAO.list()");
		}

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			stmt.setDate(2, Date.valueOf(begin));
			stmt.setDate(3, Date.valueOf(end));
			rs = stmt.executeQuery();
		
			while (rs.next()) {

				Income inc = new Income();
				inc.setUser(user);
				inc.setName(rs.getString("name"));
				inc.setValue(rs.getDouble("value"));
				inc.setDescription(rs.getString("description"));
				inc.setDate(rs.getDate("date").toLocalDate()); 

				list.add(inc);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error list all data from database (IncomeDAO)" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return list;
	}
	
}
