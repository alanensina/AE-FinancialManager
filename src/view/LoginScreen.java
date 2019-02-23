package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.User;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private final JLabel lblCopyrightAlan = new JLabel("Created and designed by Alan Ensina @ 2019");

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

	public LoginScreen() {
		setResizable(false);
		setTitle("AE Financial Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 308);

		// Setting the position to open centralized
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screenSize.getWidth() - 363) / 2;
		int y = (int) (screenSize.getHeight() - 308) / 2;
		setLocation(x, y);

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
		btSingIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());

				LoginController controller = new LoginController();
				if (controller.sendToService(user)) {
					dispose();
					//User user2 = controller.getUserLogged(user);
					
				//MainScreen mainScreen = new MainScreen(user2);
				MainScreen mainScreen = new MainScreen();
					
				}
			}
		});
		btSingIn.setBounds(12, 221, 108, 25);
		contentPane.add(btSingIn);

		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btCancel.setBounds(237, 221, 108, 25);
		contentPane.add(btCancel);

		JButton btNewUser = new JButton("New user?");
		// ActionListener of New User's button.
		btNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterUserScreen().setVisible(true);
				dispose();
			}
		});
		btNewUser.setBounds(125, 221, 108, 25);
		contentPane.add(btNewUser);

		lblCopyrightAlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyrightAlan.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblCopyrightAlan.setBounds(22, 258, 333, 33);
		contentPane.add(lblCopyrightAlan);

		JLabel lblA = new JLabel("");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setIcon(new ImageIcon(LoginScreen.class.getResource("/icons/moneyBag.png")));
		lblA.setBounds(12, 12, 333, 147);
		contentPane.add(lblA);

		JLabel lbGithub = new JLabel("github.com/alanensina");
		lbGithub.setHorizontalAlignment(SwingConstants.CENTER);
		lbGithub.setFont(new Font("Dialog", Font.PLAIN, 10));
		lbGithub.setBounds(12, 281, 333, 19);
		contentPane.add(lbGithub);
	}
}