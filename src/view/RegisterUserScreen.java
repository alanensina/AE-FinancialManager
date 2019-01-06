package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class RegisterUserScreen extends JInternalFrame {
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField textField;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtProfession;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUserScreen frame = new RegisterUserScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RegisterUserScreen() {
		setTitle("Register User");
		setResizable(true);
		setBounds(100, 100, 400, 500);
		getContentPane().setLayout(null);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(42, 163, 70, 15);
		getContentPane().add(lbName);
		
		JLabel lbSurname = new JLabel("Surname");
		lbSurname.setBounds(42, 190, 70, 15);
		getContentPane().add(lbSurname);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setBounds(42, 217, 70, 15);
		getContentPane().add(lbPhone);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setBounds(42, 244, 70, 15);
		getContentPane().add(lbEmail);
		
		JLabel lbBirthday = new JLabel("Birthday");
		lbBirthday.setBounds(42, 275, 70, 15);
		getContentPane().add(lbBirthday);
		
		txtName = new JTextField();
		txtName.setBounds(130, 161, 213, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(130, 188, 213, 19);
		getContentPane().add(txtSurname);
		txtSurname.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(130, 215, 213, 19);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(130, 242, 213, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(130, 273, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewUser = new JLabel("New user");
		lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUser.setBounds(12, 137, 366, 25);
		getContentPane().add(lblNewUser);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(42, 304, 80, 15);
		getContentPane().add(lbUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(42, 331, 70, 15);
		getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(130, 302, 114, 19);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(130, 329, 114, 19);
		getContentPane().add(txtPassword);
		
		JLabel lbProfession = new JLabel("Profession");
		lbProfession.setBounds(42, 358, 80, 15);
		getContentPane().add(lbProfession);
		
		txtProfession = new JTextField();
		txtProfession.setBounds(130, 356, 114, 19);
		getContentPane().add(txtProfession);
		txtProfession.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(226, 398, 130, 25);
		getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(44, 398, 130, 25);
		getContentPane().add(btnCancel);
		
		JLabel lbIcon = new JLabel("");
		lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbIcon.setIcon(new ImageIcon("/home/alan/eclipse-workspace/AEFM/AE-FinancialManager/resources/icons/businessman.png"));
		lbIcon.setBounds(12, 12, 366, 128);
		getContentPane().add(lbIcon);

	}
}