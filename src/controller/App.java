package controller;

import java.sql.Connection;

import connection.ConnectionFactory;

public class App {

	public static void main(String[] args) {
		
		// LoginScreen.main(args);
		
		// Testing the database's connection
		ConnectionFactory con = new ConnectionFactory();
		Connection test = con.getConnection();
		con.closeConnection(test);
	}

}