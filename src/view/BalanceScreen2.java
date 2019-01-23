package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class BalanceScreen2 extends JInternalFrame {
	private JTable tbExpenses;
	private JTable tbIncomes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceScreen2 frame = new BalanceScreen2();
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
	public BalanceScreen2() {
		setTitle("Balance Screen");
		setBounds(100, 100, 622, 562);
		getContentPane().setLayout(null);
		
		JComboBox cbYear = new JComboBox();
		cbYear.setFont(new Font("Dialog", Font.PLAIN, 12));
		cbYear.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020"}));
		cbYear.setBounds(405, 21, 92, 24);
		getContentPane().add(cbYear);
		
		JComboBox cbMonth = new JComboBox();
		cbMonth.setFont(new Font("Dialog", Font.PLAIN, 12));
		cbMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		cbMonth.setBounds(283, 21, 110, 24);
		getContentPane().add(cbMonth);
		
		JPanel panelIncomes = new JPanel();
		panelIncomes.setBorder(new TitledBorder(null, "Incomes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelIncomes.setBounds(12, 57, 287, 254);
		getContentPane().add(panelIncomes);
		panelIncomes.setLayout(null);
		
		tbIncomes = new JTable();
		tbIncomes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Description", "Value"
			}
		));
		tbIncomes.setBounds(12, 23, 263, 219);
		panelIncomes.add(tbIncomes);
		
		JPanel panelExpenses = new JPanel();
		panelExpenses.setLayout(null);
		panelExpenses.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Expenses", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelExpenses.setBounds(311, 57, 287, 254);
		getContentPane().add(panelExpenses);
		
		tbExpenses = new JTable();
		tbExpenses.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
					"Description", "Value"
			}
		));
		tbExpenses.getColumnModel().getColumn(0).setPreferredWidth(100);
		tbExpenses.getColumnModel().getColumn(1).setPreferredWidth(95);
		tbExpenses.setBounds(12, 23, 263, 219);
		panelExpenses.add(tbExpenses);
		
		JPanel panelBalance = new JPanel();
		panelBalance.setBorder(new TitledBorder(null, "Balance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBalance.setBounds(189, 341, 215, 112);
		getContentPane().add(panelBalance);
		panelBalance.setLayout(null);
		
		JLabel lblTotalIncomes = new JLabel("Total incomes:");
		lblTotalIncomes.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTotalIncomes.setBounds(12, 27, 103, 15);
		panelBalance.add(lblTotalIncomes);
		
		JLabel lblTotalExpenses = new JLabel("Total expenses:");
		lblTotalExpenses.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTotalExpenses.setBounds(12, 54, 103, 15);
		panelBalance.add(lblTotalExpenses);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBalance.setBounds(12, 81, 103, 15);
		panelBalance.add(lblBalance);
		
		JLabel lbValueTotalIncome = new JLabel("Value");
		lbValueTotalIncome.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueTotalIncome.setBounds(133, 27, 70, 15);
		panelBalance.add(lbValueTotalIncome);
		
		JLabel lbValueTotalExpense = new JLabel("Value");
		lbValueTotalExpense.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueTotalExpense.setBounds(133, 54, 70, 15);
		panelBalance.add(lbValueTotalExpense);
		
		JLabel lbValueTotalBalance = new JLabel("Value");
		lbValueTotalBalance.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueTotalBalance.setBounds(133, 81, 70, 15);
		panelBalance.add(lbValueTotalBalance);
		
		JButton btRefresh = new JButton("Refresh");
		btRefresh.setBounds(506, 21, 92, 25);
		getContentPane().add(btRefresh);
		
		JButton btSave = new JButton("Save");
		btSave.setBounds(305, 481, 117, 25);
		getContentPane().add(btSave);
		
		JButton btCancel = new JButton("Cancel");
		btCancel.setBounds(176, 481, 117, 25);
		getContentPane().add(btCancel);

	}
}
