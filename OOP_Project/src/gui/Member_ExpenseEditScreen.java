package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.Project_MainFrame;
import data.Expense;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Member_ExpenseEditScreen extends JPanel{
	private Project_MainFrame main;
	private JTextField txtDes;
	private JTextField txtAmt;
	private JTextField txtDate;
	private String[] temporary = {"Yes","No"};
	public Member_ExpenseEditScreen(Project_MainFrame main,int index, Expense editEx, String username) {
		this.main = main;
		setLayout(null);
		
		JLabel lblExpenseEditScreen = new JLabel("Expense Edit Screen");
		lblExpenseEditScreen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblExpenseEditScreen.setBounds(201, 37, 187, 16);
		add(lblExpenseEditScreen);
		
		JLabel lblNewLabel = new JLabel("Description :");
		lblNewLabel.setBounds(64, 112, 83, 16);
		add(lblNewLabel);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(71, 159, 56, 16);
		add(lblAmount);
		
		txtDes = new JTextField();
		txtDes.setBounds(194, 109, 116, 22);
		add(txtDes);
		txtDes.setColumns(10);
		txtDes.setText("" + editEx.getDescription());
		
		txtAmt = new JTextField();
		txtAmt.setBounds(194, 156, 116, 22);
		add(txtAmt);
		txtAmt.setColumns(10);
		txtAmt.setText("" + editEx.getAmount());
		
		txtDate = new JTextField();
		txtDate.setBounds(194, 203, 116, 22);
		add(txtDate);
		txtDate.setColumns(10);
		txtDate.setText("" + editEx.getDate());
		
		JComboBox comboBox = new JComboBox(this.temporary);
		comboBox.setBounds(192, 254, 118, 22);
		add(comboBox);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(71, 206, 56, 16);
		add(lblDate);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(71, 257, 76, 16);
		add(lblCategory);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = txtDes.getText();
				Float amount = Float.valueOf(txtAmt.getText());
				String date = txtDate.getText();
				String category = comboBox.getSelectedItem().toString();
				Expense x = new Expense();
				x.setUserId(username);
				x.setDescription(description);
				x.setAmount(amount);
				x.setDate(date);
				x.setCategory(category);
				
				main.getController().editExpense(index,x);
			}
		});
		btnSaveChanges.setBounds(223, 307, 116, 25);
		add(btnSaveChanges);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showExpenseScreen(username);
			}
		});
		btnReturn.setBounds(233, 357, 97, 25);
		add(btnReturn);
	}
}
