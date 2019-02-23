package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.User;

public class MainScreen extends JFrame {
	private User user = new User(); // Check here

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
		System.out.println(user); // Isso ta printando
		initialize();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private void initialize() {
		
		frmAeFinancialManager = new JFrame();
		frmAeFinancialManager.getContentPane().setBackground(Color.DARK_GRAY);
		frmAeFinancialManager.setTitle("AE Financial Manager");
		frmAeFinancialManager.setResizable(false);
		frmAeFinancialManager.setBounds(100, 100, 1280, 720);
		frmAeFinancialManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAeFinancialManager.getContentPane().setLayout(null);

		// Não carrega o background
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/background.png"));
		Image image = icon.getImage();
		JDesktopPane desktopPane = new JDesktopPane(){

			public void paintComponent(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		desktopPane.setBounds(131, 57, 1, 1);
		frmAeFinancialManager.getContentPane().add(desktopPane);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 128, 21);
		frmAeFinancialManager.getContentPane().add(menuBar);

		JMenu mnItem = new JMenu("Register");
		menuBar.add(mnItem);

		JMenuItem menuRegisterExpense = new JMenuItem("Expense");
		menuRegisterExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterExpenseScreen screen = new RegisterExpenseScreen();
				frmAeFinancialManager.getContentPane().add(screen);
				screen.setVisible(true);
			}
		});
		mnItem.add(menuRegisterExpense);

		JMenuItem menuRegisterIncome = new JMenuItem("Income");
		menuRegisterIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterIncomeScreen screen = new RegisterIncomeScreen();
				frmAeFinancialManager.getContentPane().add(screen);
				screen.setVisible(true);
			}
		});
		mnItem.add(menuRegisterIncome);

		JMenu mnList = new JMenu("View");
		menuBar.add(mnList);

		JMenuItem menuBalance = new JMenuItem("Balance");
		menuBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, getUser()); // Isso da null null

				BalanceScreen screen = new BalanceScreen();
				frmAeFinancialManager.getContentPane().add(screen);
				screen.setVisible(true);

			}
		});
		mnList.add(menuBalance);

		frmAeFinancialManager.setVisible(true);
	}
}
