package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Project_MainFrame;
import data.Category;
import data.Expense;
import data.User;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Head_ViewExpense extends JPanel{
	private JLabel lblUsername;
	private Expense[] expense;
	private Project_MainFrame main;
	private JTable exTable;
	public String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private JComboBox cbMonthTtl;
	private String choice;
	private JLabel lblmonthlyTotal;
	private double result = 0.0;
	
	public Head_ViewExpense(Project_MainFrame main, int index, User u) {
		this.main = main;
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 591, 204);
		this.exTable = new JTable();
		
		scrollPane.setViewportView(this.exTable);
		add(scrollPane);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMonthlyTotal();
			}
		});
		btnShow.setBounds(350, 395, 97, 25);
		add(btnShow);
		
		this.cbMonthTtl = new JComboBox(month);
		cbMonthTtl.setBounds(331, 325, 152, 25);
		add(cbMonthTtl);
		
		this.lblmonthlyTotal = new JLabel("(Monthly Total)");
		lblmonthlyTotal.setBounds(341, 367, 109, 20);
		add(lblmonthlyTotal);
		
		JButton btnBackToMenu = new JButton("Back to Family Members");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showFamilyScreen();
			}
		});
		btnBackToMenu.setBounds(15, 25, 218, 29);
		add(btnBackToMenu);
		
		this.lblUsername = new JLabel("username");
		lblUsername.setBounds(541, 29, 293, 20);
		lblUsername.setText(u.getUsername());
		add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(449, 29, 77, 20);
		add(lblUsername_1);
		
		populateExpenseTable();
		
	}
	
	public void populateExpenseTable(){
		expense = main.getController().getExpense();
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Date");
		tableModel.addColumn("Category");
		tableModel.addColumn("Description");
		tableModel.addColumn("Amount"); 
		for(int i=0; i<expense.length; i++){
			Expense ep = expense[i];
			if(expense[i].getUserId().equals(this.lblUsername.getText())){
				Object[] data = new Object[]{ep.getDate()+" "+ep.getMonth(),ep.getCategory(),ep.getDescription(),"$"+ep.getAmount()};
				tableModel.insertRow(i, data);
				System.out.println(Arrays.toString(data));
			}
		}
		this.exTable.setModel(tableModel);
	}
	
	public void showMonthlyTotal()
	{
		choice = cbMonthTtl.getSelectedItem().toString();
		
		for(int j=0; j<expense.length;j++)
		{
			Expense ep = expense[j];
			if(choice == ep.getMonth()){
				result = result + ep.getAmount();
			}
			else{
				continue;
			}
			
		}
		System.out.println("The total is " + result);
		lblmonthlyTotal.setText("$"+String.valueOf(result));
		result = 0;
	}
}
	

