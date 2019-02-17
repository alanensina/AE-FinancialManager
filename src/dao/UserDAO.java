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
import repository.UserRepository;

@SuppressWarnings("rawtypes")
public class UserDAO implements UserRepository {

	private Connection con = null;

	public UserDAO() {
		con = ConnectionFactory.getConnection();
	}

	@Override
	public boolean register(Object obj) {
		String sql = "insert into user (first_name, last_name, phone, email, birthday, username, user_password, profession) values (?,?,?,?,?,?,?,?)";
		User user = new User();

		if (obj instanceof User) {
			user = (User) obj;
		} else {
			JOptionPane.showMessageDialog(null, "Object is not an instance of User. Method: UserDAO.register()");
			return false;
		}

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
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return true;
	}

	@Override
	public boolean delete(Object obj) {
		/*
		 * Lembrete: Ao deletar o usuário, deve-se deletar seus registros na tabela
		 * Income e Expense
		 */

		return false;
	}

	
	// Falta testar esse método
	@Override
	public boolean update(Object obj) {
		String sql = "update user set first_name = ?," + " last_name = ?, phone = ?, email = ?, "
				+ "birthday = ?, username = ?, user_password = ?, " + "profession = ?, active = ? where id = ?";
		User user = new User();

		if (obj instanceof User) {
			user = (User) obj;
		} else {
			JOptionPane.showMessageDialog(null, "Object is not an instance of User. Method: UserDAO.update()");
			return false;
		}

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getPhone());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getBirthday());
			stmt.setString(6, user.getUsername());
			stmt.setString(7, user.getPassword());
			stmt.setString(8, user.getProfession());
			stmt.setBoolean(9, user.isActive());
			stmt.setInt(10, user.getId());
			stmt.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error updating to database (UserDAO.update())" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return true;
	}

	@Override
	public List<User> list() {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from user";

		List<User> users = new LinkedList<>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {

				User user = new User();
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getString("birthday"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("user_password"));
				user.setProfession(rs.getString("profession"));

				users.add(user);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error list all data from database (UserDAO)" + ex);
			throw new RuntimeException(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return users;
	}

	@Override
	public boolean updateStatus(Object obj, boolean active) {
		String sql = "update user set active = ? where id = ?";
		PreparedStatement stmt = null;
		User user = new User();

		if (obj instanceof User) {
			user = (User) obj;
		} else {
			JOptionPane.showMessageDialog(null, "Object is not an instance of User. Method: UserDAO.updateStatus()");
			return false;
		}

		try {
			stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, active);
			stmt.setInt(2, user.getId());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"There was an error to update the status of this user in the database (UserDAO.updateStatus())"
							+ ex);
			throw new RuntimeException(ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return true;
	}

	@Override
	public int findID(Object obj) {
		User user = new User();
		String sql = "select * from user where username = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		if (obj instanceof User) {
			user = (User) obj;
		} else {
			JOptionPane.showMessageDialog(null, "Object is not an instance of User. Method: UserDAO.findID()");
		}

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			rs = stmt.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getString("birthday"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("user_password"));
				user.setProfession(rs.getString("profession"));

				int active = Integer.parseInt(rs.getString("active"));

				if (active == 1) {
					user.setActive(true);
				} else {
					user.setActive(false);
				}
			}
			return user.getId();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"There was an error to find the ID in the database (UserDAO.findID())" + ex);
			throw new RuntimeException(ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}

	@Override
	public User findUserByID(int id) {
		User user = new User();
		String sql = "select * from user where id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				user.setId(id);
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getString("birthday"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("user_password"));
				user.setProfession(rs.getString("profession"));

				int active = Integer.parseInt(rs.getString("active"));

				if (active == 1) {
					user.setActive(true);
				} else {
					user.setActive(false);
				}
			}
			return user;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"There was an error to find this user in the database (UserDAO.findUserByID())" + ex);
			throw new RuntimeException(ex);

		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
	}
}