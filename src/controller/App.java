package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.UserDAO;
import model.User;

public class App {

	public static void main(String[] args) {

		// LoginScreen.main(args);

//		 Testing the database's connection
//		 ConnectionFactory con = new ConnectionFactory();
//		 Connection test = con.getConnection();
//		 con.closeConnection(test);
		
		UserDAO dao = new UserDAO();
		
		try {
		User user = dao.findUserByID(1);
		System.out.println(user);
		
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "There was an error list all data from database (UserDAO)" + ex);
		}
	}

}