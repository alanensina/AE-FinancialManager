package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterIncomeScreen extends JInternalFrame {
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterIncomeScreen frame = new RegisterIncomeScreen();
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
	public RegisterIncomeScreen() {
		setTitle("Register income");
		setBounds(100, 100, 373, 455);
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(RegisterIncomeScreen.class.getResource("/icons/income.png")));
		lblLogo.setBounds(12, 12, 345, 136);
		getContentPane().add(lblLogo);
		
		JPanel panelDetailsIncome = new JPanel();
		panelDetailsIncome.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDetailsIncome.setBounds(12, 157, 345, 214);
		getContentPane().add(panelDetailsIncome);
		panelDetailsIncome.setLayout(null);
		
		JLabel lbName = new JLabel("Name");
		lbName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbName.setBounds(12, 26, 70, 15);
		panelDetailsIncome.add(lbName);
		
		txtName = new JTextField();
		txtName.setBounds(95, 24, 238, 19);
		panelDetailsIncome.add(txtName);
		txtName.setColumns(10);
		
		JLabel lbDate = new JLabel("Date");
		lbDate.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbDate.setBounds(12, 53, 70, 15);
		panelDetailsIncome.add(lbDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(95, 51, 106, 19);
		panelDetailsIncome.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lbDescription = new JLabel("Description");
		lbDescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbDescription.setBounds(12, 80, 81, 15);
		panelDetailsIncome.add(lbDescription);
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setWrapStyleWord(true);
		txtDescription.setLineWrap(true);
		txtDescription.setBounds(95, 78, 238, 90);
		panelDetailsIncome.add(txtDescription);
		
		JLabel lbValue = new JLabel("Value");
		lbValue.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValue.setBounds(12, 182, 70, 15);
		panelDetailsIncome.add(lbValue);
		
		txtValue = new JTextField();
		txtValue.setBounds(95, 180, 114, 19);
		panelDetailsIncome.add(txtValue);
		txtValue.setColumns(10);
		
		JButton btRegister = new JButton("Register");
		btRegister.setBounds(237, 383, 117, 25);
		getContentPane().add(btRegister);
		
		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btCancel.setBounds(12, 383, 117, 25);
		getContentPane().add(btCancel);

	}
}
