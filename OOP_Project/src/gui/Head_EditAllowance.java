package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controller.Project_MainFrame;
import data.Category;
import data.Expense;
import data.FamilyMember;
import data.User;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Head_EditAllowance extends JPanel{
	private JTextField txtNewAllowance;
	private Project_MainFrame main;
	private JLabel lblMembername;
	private JLabel lblSpendingAmount;
	private User[] user;
	private Expense[] expense;
	private double spending = 0; 
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public Head_EditAllowance(Project_MainFrame main, int index, User u) {
		user = main.getController().getUsers();
		expense = main.getController().getExpense();
		this.main = main;
		setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(164, 154, 47, 20);
		setLayout(null);
		add(lblName);
		
		JLabel lblNewAllowance = new JLabel("New Allowance:");
		lblNewAllowance.setBounds(101, 261, 135, 20);
		add(lblNewAllowance);
		
		txtNewAllowance = new JTextField();
		txtNewAllowance.setText(String.valueOf(df.format(u.getAllowance())));
		txtNewAllowance.setBounds(251, 258, 146, 26);
		add(txtNewAllowance);
		txtNewAllowance.setColumns(10);
		
		
		JButton button = new JButton("Return ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showFamilyScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 25));
		button.setBounds(287, 321, 146, 26);
		add(button);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float allowance = Float.valueOf(txtNewAllowance.getText());
				User op = new User();
				op.setAllowance(allowance);
				op.setDateofBirth(user[index].getDateofBirth());
				op.setIsFamilyHead(user[index].getIsFamilyHead());
				op.setName(user[index].getName());
				op.setPassword(user[index].getPassword());
				op.setUsername(user[index].getUsername());
				main.getController().editAllowance(index, op);
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSave.setBounds(101, 324, 146, 26);
		add(btnSave);
		
		JLabel lblEditAllowance = new JLabel("Edit Allowance");
		lblEditAllowance.setFont(new Font("Tahoma", Font.BOLD, 90));
		lblEditAllowance.setBounds(55, -8, 666, 109);
		add(lblEditAllowance);
		
		this.lblMembername = new JLabel("MemberName");
		lblMembername.setBounds(251, 154, 98, 20);
		add(lblMembername);
		lblMembername.setText(user[index].getName());
		
		JLabel lblSpending = new JLabel("Spending:");
		lblSpending.setBounds(139, 207, 72, 20);
		add(lblSpending);
		
		this.lblSpendingAmount = new JLabel("Spending");
		lblSpendingAmount.setBounds(251, 207, 69, 20);
		add(lblSpendingAmount);
		for(int i1=0; i1<expense.length; i1++){
			Expense ex = expense[i1];
			if (user[index].getUsername().equals(ex.getUserId())){
				this.spending = this.spending + ex.getAmount();
			}
		}
		lblSpendingAmount.setText("$"+String.valueOf(df.format(spending)));
	}
	
}
