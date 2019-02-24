package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.RegisterExpenseController;
import model.Expense;
import model.User;

public class RegisterExpenseScreen extends JInternalFrame {
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtValue;
	private User user;
	private Expense expense = new Expense();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterExpenseScreen frame = new RegisterExpenseScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public User getUser() {
		return user;
	}

	public RegisterExpenseScreen(User user) {
		this.user = user;
		initializeScreen();
	}
	
	public RegisterExpenseScreen() {
		initializeScreen();
	}
	
	/**
	 * Create the frame.
	 */
	public void initializeScreen() {
		setTitle("Register expense");
		setBounds(100, 100, 373, 455);
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(RegisterExpenseScreen.class.getResource("/icons/expense.png")));
		lblLogo.setBounds(12, 12, 345, 136);
		getContentPane().add(lblLogo);
		
		JPanel panelDetailsExpense = new JPanel();
		panelDetailsExpense.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDetailsExpense.setBounds(12, 157, 345, 214);
		getContentPane().add(panelDetailsExpense);
		panelDetailsExpense.setLayout(null);
		
		JLabel lbName = new JLabel("Name");
		lbName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbName.setBounds(12, 26, 70, 15);
		panelDetailsExpense.add(lbName);
		
		txtName = new JTextField();
		txtName.setBounds(95, 24, 238, 19);
		panelDetailsExpense.add(txtName);
		txtName.setColumns(10);
		
		JLabel lbDate = new JLabel("Date");
		lbDate.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbDate.setBounds(12, 53, 70, 15);
		panelDetailsExpense.add(lbDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(95, 51, 106, 19);
		panelDetailsExpense.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lbDescription = new JLabel("Description");
		lbDescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbDescription.setBounds(12, 80, 81, 15);
		panelDetailsExpense.add(lbDescription);
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setWrapStyleWord(true);
		txtDescription.setLineWrap(true);
		txtDescription.setBounds(95, 78, 238, 90);
		panelDetailsExpense.add(txtDescription);
		
		JLabel lbValue = new JLabel("Value");
		lbValue.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValue.setBounds(12, 182, 70, 15);
		panelDetailsExpense.add(lbValue);
		
		txtValue = new JTextField();
		txtValue.setBounds(95, 180, 114, 19);
		panelDetailsExpense.add(txtValue);
		txtValue.setColumns(10);
		
		JButton btRegister = new JButton("Register");
		btRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expense.setName(txtName.getText());
				expense.setUser(getUser());
				expense.setDescription(txtDescription.getText());
				expense.setValue(Double.parseDouble(txtValue.getText()));
				expense.setDate(txtDate.getText());
				
				RegisterExpenseController controller = new RegisterExpenseController(getUser());
				if(controller.sendToService(expense, getUser())) {
					txtName.setText("");
					txtDescription.setText("");
					txtValue.setText("");
					txtDate.setText("");
				}
				
			}
		});
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
	
	public void setPosition() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

}
