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
import java.awt.Font;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private final JLabel lblCopyrightAlan = new JLabel("Alan Ensina @ 2019");

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
		setBounds(100, 100, 365, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Username");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(54, 165, 81, 15);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(54, 192, 81, 15);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(142, 163, 173, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(142, 190, 173, 19);
		contentPane.add(txtPassword);
		
		JButton btSingIn = new JButton("Sing in");
		btSingIn.setBounds(12, 221, 108, 25);
		contentPane.add(btSingIn);
		
		JButton btCancel = new JButton("Cancel");
		btCancel.setBounds(237, 221, 108, 25);
		contentPane.add(btCancel);
		
		JButton btNewUser = new JButton("New user?");
		btNewUser.setBounds(125, 221, 108, 25);
		contentPane.add(btNewUser);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(LoginScreen.class.getResource("/icons/money-bag (1).png")));
		lblLogo.setBounds(22, 12, 323, 135);
		contentPane.add(lblLogo);
		lblCopyrightAlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyrightAlan.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblCopyrightAlan.setBounds(12, 248, 333, 33);
		contentPane.add(lblCopyrightAlan);
	}
}
