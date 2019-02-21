package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.User;

public class MainScreen {
	private User user; // Check here

	private JFrame frmAeFinancialManager;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmAeFinancialManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen() {
		initialize();
	}
	
	// Check here
	public MainScreen(User user) {
		this.user = user;
		initialize();
	}

	private void initialize() {
		frmAeFinancialManager = new JFrame();
		frmAeFinancialManager.getContentPane().setBackground(Color.DARK_GRAY);
		frmAeFinancialManager.setTitle("AE Financial Manager");
		frmAeFinancialManager.setResizable(false);
		frmAeFinancialManager.setBounds(100, 100, 1280, 720);
		frmAeFinancialManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAeFinancialManager.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(131, 57, 1, 1);
		frmAeFinancialManager.getContentPane().add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 128, 21);
		frmAeFinancialManager.getContentPane().add(menuBar);
		
		JMenu mnItem = new JMenu("Register");
		menuBar.add(mnItem);
		
		JMenuItem menuRegisterExpense = new JMenuItem("Expense");
		mnItem.add(menuRegisterExpense);
		
		JMenuItem menuRegisterIncome = new JMenuItem("Income");
		mnItem.add(menuRegisterIncome);
		
		JMenu mnList = new JMenu("View");
		menuBar.add(mnList);
		
		JMenuItem menuBalance = new JMenuItem("Balance");
		mnList.add(menuBalance);
	}
}
