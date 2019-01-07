package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

public class MainScreen {

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
		
		JMenuItem menuListExpenses = new JMenuItem("Expenses");
		mnList.add(menuListExpenses);
		
		JMenuItem menuListIncomes = new JMenuItem("Incomes");
		mnList.add(menuListIncomes);
	}
}
