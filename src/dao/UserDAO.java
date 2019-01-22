package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.User;

public class UserDAO {
	private Connection con = null;

	public UserDAO() {
		con = ConnectionFactory.getConnection();
	}

	public void create(User user) {
		String sql = "insert into user (first_name, last_name, phone, email, birthday, username, user_password, profession) values (?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getPhone());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getBirthday());
			stmt.setString(6, user.getUsername());
			stmt.setString(7, user.getPassword());
			stmt.setString(8, user.getProfession());
			stmt.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error saving to database (UserDAO)" + ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<User> read() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from user;";

		List<User> users = new LinkedList<>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				User user = new User();
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getString("birthday"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setProfession(rs.getString("profession"));

				users.add(user);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error list all data from database (UserDAO)" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return users;
	}
	
	public int findByID(User user) throws SQLException {
		int id = 0;
		String sql = "select id from user where username = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		
		/*
		 	PreparedStatement stat;
            String SQLFind = "SELECT * FROM CLIENTE WHERE ID = ?";
            stat = conn.prepareStatement(SQLFind);
            stat.setInt(1, ID);
            ResultSet rs = stat.executeQuery();
            Cliente cliente = new Cliente();
            cliente.setID(rs.getInt("ID")); 
            stat.clos
		 */

		
		
		
		
		return id;
		
	}
}