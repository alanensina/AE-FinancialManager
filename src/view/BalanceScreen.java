package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class BalanceScreen extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceScreen frame = new BalanceScreen();
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
	public BalanceScreen() {
		setTitle("Balance");
		setBounds(100, 100, 440, 482);
		getContentPane().setLayout(null);
		
		JPanel panelIncome = new JPanel();
		panelIncome.setBorder(new TitledBorder(null, "Incomes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelIncome.setBounds(12, 12, 196, 262);
		getContentPane().add(panelIncome);
		panelIncome.setLayout(null);
		
		JLabel lbNameIncome = new JLabel("Name");
		lbNameIncome.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbNameIncome.setBounds(12, 25, 70, 15);
		panelIncome.add(lbNameIncome);
		
		JLabel lbValueIncome = new JLabel("Value");
		lbValueIncome.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueIncome.setBounds(114, 25, 70, 15);
		panelIncome.add(lbValueIncome);
		
		JPanel panelExpense = new JPanel();
		panelExpense.setBorder(new TitledBorder(null, "Expenses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelExpense.setBounds(220, 12, 196, 262);
		getContentPane().add(panelExpense);
		panelExpense.setLayout(null);
		
		JLabel lbNameExpense = new JLabel("Name");
		lbNameExpense.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbNameExpense.setBounds(12, 26, 70, 15);
		panelExpense.add(lbNameExpense);
		
		JLabel lbValueExpense = new JLabel("Value");
		lbValueExpense.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueExpense.setBounds(114, 26, 70, 15);
		panelExpense.add(lbValueExpense);
		
		JPanel panelBalance = new JPanel();
		panelBalance.setBorder(new TitledBorder(null, "Balance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBalance.setBounds(12, 288, 404, 99);
		getContentPane().add(panelBalance);
		panelBalance.setLayout(null);
		
		JLabel lbTotalIncomes = new JLabel("Total incomes:");
		lbTotalIncomes.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbTotalIncomes.setBounds(12, 24, 103, 15);
		panelBalance.add(lbTotalIncomes);
		
		JLabel lbTotalExpenses = new JLabel("Total expenses:");
		lbTotalExpenses.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbTotalExpenses.setBounds(12, 51, 103, 15);
		panelBalance.add(lbTotalExpenses);
		
		JLabel lbBalance = new JLabel("Balance:");
		lbBalance.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbBalance.setBounds(12, 78, 70, 15);
		panelBalance.add(lbBalance);
		
		JLabel lbAllIncomes = new JLabel("Value");
		lbAllIncomes.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbAllIncomes.setBounds(123, 24, 135, 15);
		panelBalance.add(lbAllIncomes);
		
		JLabel lbAllExpenses = new JLabel("Value");
		lbAllExpenses.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbAllExpenses.setBounds(123, 51, 70, 15);
		panelBalance.add(lbAllExpenses);
		
		JLabel lbTotalBalance = new JLabel("Value");
		lbTotalBalance.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbTotalBalance.setBounds(123, 78, 70, 15);
		panelBalance.add(lbTotalBalance);
		
		JButton btCancel = new JButton("Cancel");
		btCancel.setBounds(12, 399, 117, 25);
		getContentPane().add(btCancel);
		
		JButton btPrint = new JButton("Print");
		btPrint.setBounds(299, 399, 117, 25);
		getContentPane().add(btPrint);
		
		JButton btSave = new JButton("Save");
		btSave.setBounds(156, 399, 117, 25);
		getContentPane().add(btSave);

	}
}
