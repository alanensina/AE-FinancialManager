package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setResizable(false);
		setTitle("AE Financial Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Username");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(12, 159, 81, 15);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(12, 186, 81, 15);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(100, 157, 120, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 184, 120, 19);
		contentPane.add(passwordField);
		
		JButton btnSingIn = new JButton("Sing in");
		btnSingIn.setBounds(22, 221, 93, 25);
		contentPane.add(btnSingIn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(127, 221, 93, 25);
		contentPane.add(btnCancel);
		
		JButton btnNewUser = new JButton("New user?");
		btnNewUser.setBounds(62, 258, 117, 25);
		contentPane.add(btnNewUser);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LoginScreen.class.getResource("/icons/money-bag (1).png")));
		lblLogo.setBounds(22, 12, 198, 135);
		contentPane.add(lblLogo);
	}
}
