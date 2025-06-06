package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.Project_MainFrame;
import data.Expense;
import data.User;

import javax.swing.JButton;
import java.awt.Font;
import java.util.Arrays;
import java.awt.Color;

public class Head_InspectMember extends JPanel{
	private Project_MainFrame main;
	private JList memberList;
	private JTable table;
	private Expense[] expense;
	private User[] user;
	private JLabel lblUsername;
	public Head_InspectMember(Project_MainFrame main, int Index, User n) {
		setLayout(null);
		
		this.table = new JTable();
		table.setRowHeight(100);
		table.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 176, 824, 384);
		scrollPane.setViewportView(this.table);
		add(scrollPane);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(15, 16, 60, 60);
		add(lblImage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(90, 36, 238, 20);
		add(lblUsername);
		
		//JList for family members
		this.memberList = new JList();
		scrollPane.setViewportView(this.memberList);
		memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton = new JButton("Return ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(387, 33, 212, 26);
		add(btnNewButton);
		
		JLabel lblMonthlyAllowance = new JLabel("Monthly Allowance: ");
		lblMonthlyAllowance.setBounds(15, 92, 144, 20);
		add(lblMonthlyAllowance);
		
		JLabel lblallowance = new JLabel("(Allowance)");
		lblallowance.setForeground(Color.BLUE);
		lblallowance.setBounds(179, 92, 84, 20);
		add(lblallowance);
		
		JButton btnEditAllowance = new JButton("Edit Allowance");
		btnEditAllowance.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditAllowance.setBounds(387, 88, 212, 26);
		add(btnEditAllowance);
		
		this.lblUsername = new JLabel("username");
		lblUsername.setBounds(709, 29, 293, 20);
		lblUsername.setText(this.user[Index].getUsername());
		add(lblUsername);
		
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
				Object[] data = new Object[]{ep.getDate(),ep.getCategory(),ep.getDescription(),ep.getAmount()};
				tableModel.insertRow(i, data);
				System.out.println(Arrays.toString(data));
			}
		}
		this.table.setModel(tableModel);
	}
}
