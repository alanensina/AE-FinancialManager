package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.RegisterUserController;
import model.User;

public class RegisterUserScreen extends JFrame {
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtBirthday;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtProfession;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private List<String> screenData;

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
		setBounds(100, 100, 400, 559);
		getContentPane().setLayout(null);
		
		// Setting the position to open centralized
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        int x = (int) (screenSize.getWidth() - 400) / 2;
		        int y = (int) (screenSize.getHeight() - 532) / 2;
		        setLocation(x, y);

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(RegisterUserScreen.class.getResource("/icons/businessman.png")));
		lblLogo.setBounds(12, 12, 366, 128);
		getContentPane().add(lblLogo);

		JPanel panelPersonalDetails = new JPanel();
		panelPersonalDetails.setBorder(
				new TitledBorder(null, "Personal details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPersonalDetails.setBounds(12, 162, 366, 136);
		getContentPane().add(panelPersonalDetails);
		panelPersonalDetails.setLayout(null);

		JLabel lbName = new JLabel("Name");
		lbName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbName.setBounds(12, 26, 70, 15);
		lbName.setHorizontalAlignment(SwingConstants.LEFT);
		panelPersonalDetails.add(lbName);

		txtName = new JTextField();
		txtName.setBounds(92, 24, 262, 19);
		panelPersonalDetails.add(txtName);
		txtName.setColumns(10);

		JLabel lbSurname = new JLabel("Surname");
		lbSurname.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbSurname.setBounds(12, 53, 70, 15);
		panelPersonalDetails.add(lbSurname);

		txtSurname = new JTextField();
		txtSurname.setBounds(92, 51, 262, 19);
		panelPersonalDetails.add(txtSurname);
		txtSurname.setColumns(10);

		JLabel lbBirthday = new JLabel("Birthday");
		lbBirthday.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbBirthday.setBounds(12, 80, 58, 15);
		panelPersonalDetails.add(lbBirthday);

		txtBirthday = new JTextField();
		txtBirthday.setBounds(92, 78, 262, 19);
		panelPersonalDetails.add(txtBirthday);
		txtBirthday.setColumns(10);

		JLabel lbProfession = new JLabel("Profession");
		lbProfession.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbProfession.setBounds(12, 109, 70, 15);
		panelPersonalDetails.add(lbProfession);

		txtProfession = new JTextField();
		txtProfession.setBounds(92, 107, 262, 19);
		panelPersonalDetails.add(txtProfession);
		txtProfession.setColumns(10);

		JPanel panelContacts = new JPanel();
		panelContacts.setBorder(new TitledBorder(null, "Contacts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelContacts.setBounds(12, 310, 366, 80);
		getContentPane().add(panelContacts);
		panelContacts.setLayout(null);

		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbEmail.setBounds(12, 22, 70, 15);
		panelContacts.add(lbEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(92, 20, 262, 19);
		panelContacts.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbPhone.setBounds(12, 49, 55, 15);
		panelContacts.add(lbPhone);

		txtPhone = new JTextField();
		txtPhone.setBounds(92, 47, 262, 19);
		panelContacts.add(txtPhone);
		txtPhone.setColumns(10);

		JPanel panelUsersDetails = new JPanel();
		panelUsersDetails.setBorder(
				new TitledBorder(null, "User's details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelUsersDetails.setBounds(12, 395, 366, 80);
		getContentPane().add(panelUsersDetails);
		panelUsersDetails.setLayout(null);

		JLabel lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbUsername.setBounds(12, 25, 70, 15);
		panelUsersDetails.add(lbUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(90, 23, 262, 19);
		panelUsersDetails.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbPassword.setBounds(12, 52, 70, 15);
		panelUsersDetails.add(lbPassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(90, 50, 262, 19);
		panelUsersDetails.add(txtPassword);
		txtPassword.setColumns(10);

		JButton btRegister = new JButton("Register");
		btRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				user.setName(txtName.getText());
				user.setSurname(txtSurname.getText());
				user.setBirthday(txtBirthday.getText());
				user.setEmail(txtEmail.getText());
				user.setProfession(txtProfession.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				user.setPhone(txtPhone.getText());
				
				RegisterUserController userController = new RegisterUserController();
				userController.receiveUser(user);
				dispose();
				new LoginScreen().setVisible(true);
			}
		});
		btRegister.setBounds(235, 487, 117, 25);
		getContentPane().add(btRegister);

		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginScreen().setVisible(true);
				}
		});
		btCancel.setBounds(34, 487, 117, 25);
		getContentPane().add(btCancel);

	}

	public LinkedList<String> getScreenData(RegisterUserScreen frame) {
		screenData = null;

		if (txtName.getText() != null && txtSurname.getText() != null && txtBirthday.getText() != null
				&& txtEmail.getText() != null && txtPhone.getText() != null && txtProfession.getText() != null
				&& txtUsername.getText() != null && txtPassword.getText() != null) {

			screenData.add(txtName.getText());
			screenData.add(txtSurname.getText());
			screenData.add(txtBirthday.getText());
			screenData.add(txtEmail.getText());
			screenData.add(txtPhone.getText());
			screenData.add(txtProfession.getText());
			screenData.add(txtUsername.getText());
			screenData.add(txtPassword.getText());

			return (LinkedList<String>) screenData;
		}

		JOptionPane.showMessageDialog(null, "You forgot to fill in one or more fields.");
		return null;
	}

}