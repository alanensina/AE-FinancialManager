package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.BalanceController;
import model.Expense;
import model.Income;
import model.User;

public class BalanceScreen extends JInternalFrame {
	private User user;
	private JTable tbIncome;
	private JTable tbExpense;

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

	public BalanceScreen(User user) {
		this.user = user;
		initializeScreen();
	}

	public BalanceScreen() {
		initializeScreen();
	}

	/**
	 * Create the frame.
	 */
	private void initializeScreen() {
		setTitle("Balance Screen");
		setBounds(100, 100, 622, 660);
		getContentPane().setLayout(null);

		JPanel panelBalance = new JPanel();
		panelBalance.setBorder(new TitledBorder(null, "Balance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBalance.setBounds(313, 12, 287, 112);
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

		JLabel lbValueTotalIncome = new JLabel("");
		lbValueTotalIncome.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueTotalIncome.setBounds(133, 27, 142, 15);
		panelBalance.add(lbValueTotalIncome);

		JLabel lbValueTotalExpense = new JLabel("");
		lbValueTotalExpense.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueTotalExpense.setBounds(133, 54, 142, 15);
		panelBalance.add(lbValueTotalExpense);

		JLabel lbValueTotalBalance = new JLabel("");
		lbValueTotalBalance.setFont(new Font("Dialog", Font.PLAIN, 12));
		lbValueTotalBalance.setBounds(133, 81, 142, 15);
		panelBalance.add(lbValueTotalBalance);

		JButton btSave = new JButton("Save");
		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saving to PDF, please wait...");
			}
		});
		btSave.setBounds(318, 578, 117, 25);
		getContentPane().add(btSave);

		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btCancel.setBounds(189, 578, 117, 25);
		getContentPane().add(btCancel);

		JPanel panelPeriod = new JPanel();
		panelPeriod.setBorder(
				new TitledBorder(null, "Select the period", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPeriod.setBounds(12, 12, 294, 112);
		getContentPane().add(panelPeriod);
		panelPeriod.setLayout(null);

		JDateChooser dtStarts = new JDateChooser();
		dtStarts.setBounds(12, 36, 143, 19);
		panelPeriod.add(dtStarts);

		JDateChooser dtEnds = new JDateChooser();
		dtEnds.setBounds(12, 67, 143, 19);
		panelPeriod.add(dtEnds);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LocalDate begin = dtStarts.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate end = dtEnds.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				BalanceController controller = new BalanceController();
				List<Expense> expenses = controller.getExpensesFromService(getUser(), begin, end);
				List<Income> incomes = controller.getIncomeFromService(getUser(), begin, end);
				
				lbValueTotalIncome.setText(round(readIncomeTable(incomes)));
				lbValueTotalExpense.setText(round(readExpenseTable(expenses)));
				lbValueTotalBalance.setText(round(readIncomeTable(incomes) - readExpenseTable(expenses)));
			}
		});
		btnRefresh.setBounds(167, 36, 117, 50);
		panelPeriod.add(btnRefresh);

		JPanel panelIncome = new JPanel();
		panelIncome.setBorder(new TitledBorder(null, "Incomes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelIncome.setBounds(12, 141, 294, 422);
		getContentPane().add(panelIncome);
		panelIncome.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 25, 270, 370);
		panelIncome.add(scrollPane);

		tbIncome = new JTable();
		tbIncome.setEnabled(false);
		tbIncome.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Value" }));
		scrollPane.setViewportView(tbIncome);

		JPanel panelExpense = new JPanel();
		panelExpense.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Expenses",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelExpense.setBounds(306, 141, 294, 422);
		getContentPane().add(panelExpense);
		panelExpense.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 26, 270, 370);
		panelExpense.add(scrollPane_1);

		tbExpense = new JTable();
		tbExpense.setEnabled(false);
		tbExpense.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Value" }));
		scrollPane_1.setViewportView(tbExpense);
	}

	public User getUser() {
		return this.user;
	}

	public void setPosition() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	public double readExpenseTable(List<Expense> list) {
		double sum = 0;
		DefaultTableModel model = (DefaultTableModel) tbExpense.getModel();
		model.setNumRows(0);

		for (Expense e : list) {
			model.addRow(new Object[] { e.getName(), e.getValue() });
			sum = sum + e.getValue();
		}
		return sum;
	}

	public double readIncomeTable(List<Income> list) {
		double sum = 0;
		DefaultTableModel model = (DefaultTableModel) tbIncome.getModel();
		model.setNumRows(0);

		for (Income i : list) {
			model.addRow(new Object[] { i.getName(), i.getValue() });
			sum = sum + i.getValue();
		}
		return sum;
	}
	
	private String round(Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(value);
    }
}
