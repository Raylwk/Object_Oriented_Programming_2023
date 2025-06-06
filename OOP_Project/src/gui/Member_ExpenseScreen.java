package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.Project_MainFrame;
import data.Category;
import data.Expense;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Member_ExpenseScreen extends JPanel{
	public Vector<String> categoryNames = new Vector<String>();
	private Category[] category;
	private JLabel lblUsername;
	private JLabel lblmonthlyTotal;
	private Expense[] expense;
	private JComboBox comboBox;
	private JTextField txtDesc;
	private JTextField txtAmt;
	private Project_MainFrame main;
	private JTable exTable;
	private JComboBox cbCat, cbMonth, cbDay, cbMonthTtl;
	public String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	public String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String choice;
    private double result = 0.0; 
	
	public Member_ExpenseScreen(Project_MainFrame main, String username) {
		this.main = main;
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 591, 204);
		this.exTable = new JTable();
		
		scrollPane.setViewportView(this.exTable);
		add(scrollPane);
		

		txtDesc = new JTextField();
		txtDesc.setBounds(144, 296, 158, 22);
		add(txtDesc);
		txtDesc.setColumns(10);
		
		txtAmt = new JTextField();
		txtAmt.setBounds(144, 331, 158, 22);
		add(txtAmt);
		txtAmt.setColumns(10);
		
		JLabel lblItemDescription = new JLabel("Item Description");
		lblItemDescription.setBounds(40, 299, 104, 16);
		add(lblItemDescription);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(40, 334, 57, 20);
		add(lblAmount);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(40, 369, 56, 16);
		add(lblDate);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(40, 404, 63, 20);
		add(lblCategory);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String description = txtDesc.getText();
				String day = cbDay.getSelectedItem().toString();
				Float amount = Float.valueOf(txtAmt.getText());
				String mon = cbMonth.getSelectedItem().toString();
				String category = cbCat.getSelectedItem().toString();
				Object categoryImage = findCategoryImage(cbCat.getSelectedIndex());
				main.getController().addExpense(username, description, amount, day, category,categoryImage, mon);
				txtDesc.setText("");
				txtAmt.setText("");
				
				populateExpenseTable();
				
			}
		});
		btnSave.setBounds(506, 308, 97, 25);
		add(btnSave);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Please select a row";
				int index = exTable.getSelectedRow();
				if (index == -1){
					JOptionPane.showMessageDialog(null, msg, "Error",
					JOptionPane.PLAIN_MESSAGE);
					return;
				}
				Expense editEx = expense[index];
				main.showExpenseEditScreen(index, editEx, username);
			}
		});
		btnEdit.setBounds(506, 346, 97, 25);
		add(btnEdit);
		
		JLabel lblTotalExpenseFor = new JLabel("Total expense for ");
		lblTotalExpenseFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalExpenseFor.setBounds(350, 298, 137, 16);
		add(lblTotalExpenseFor);
		
		this.cbMonthTtl = new JComboBox(month);
		cbMonthTtl.setBounds(331, 325, 152, 25);
		add(cbMonthTtl);
		
		this.lblmonthlyTotal = new JLabel("(Monthly Total)");
		lblmonthlyTotal.setBounds(341, 367, 109, 20);
		add(lblmonthlyTotal);
		
		this.cbCat = new JComboBox(fillCategories());
		this.cbCat.setBounds(144, 401, 158, 19);
		add(cbCat);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "Please select a row to be deleted";
				int index = exTable.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(null, msg, "Error",
					JOptionPane.PLAIN_MESSAGE);
					return;
				}
				main.getController().deleteExpense(index);	
				populateExpenseTable();
			}
		});
		btnDelete.setBounds(506, 384, 97, 25);
		add(btnDelete);
		
		JButton btnGo = new JButton("Go to Profile ");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showProfileScreen(username);
			}
		});
		btnGo.setBounds(483, 27, 120, 25);
		add(btnGo);
		
		this.cbMonth = new JComboBox(month);
		cbMonth.setBounds(212, 366, 90, 22);
		add(cbMonth);
		
		this.cbDay = new JComboBox(day);
		cbDay.setBounds(154, 366, 46, 22);
		add(cbDay);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMonthlyTotal();
			}
		});
		btnShow.setBounds(350, 395, 97, 25);
		add(btnShow);
		
		JButton btnBackToMenu = new JButton("Back to Menu");
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showLoginScreen();
			}
		});
		btnBackToMenu.setBounds(15, 25, 152, 29);
		add(btnBackToMenu);
		
		this.lblUsername = new JLabel("username");
		lblUsername.setBounds(709, 29, 293, 20);
		lblUsername.setText(username);
		add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(617, 29, 77, 20);
		add(lblUsername_1);
		
		populateExpenseTable();
		
	}
	
	public void populateExpenseTable(){
		expense = main.getController().getExpense();
		
		DefaultTableModel tableModel = new DefaultTableModel(){
		@Override
        public Class<?> getColumnClass(int column) {
			if (column==1) return ImageIcon.class;
            return Object.class;
	        }
		};
		tableModel.addColumn("Date");
		tableModel.addColumn("Icon");
		tableModel.addColumn("Category");
		tableModel.addColumn("Description");
		tableModel.addColumn("Amount"); 
		for(int i=0; i<expense.length; i++){
			Expense ep = expense[i];
			if(expense[i].getUserId().equals(this.lblUsername.getText())){
				Object[] data = new Object[]{ep.getDate()+" "+ep.getMonth(),ep.getCategoryImage(),ep.getCategory(),ep.getDescription(),"$"+ep.getAmount()};
				tableModel.insertRow(i, data);
			}
		}
		this.exTable.setModel(tableModel);
		exTable.setRowHeight(100);
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
	
	public Object[] fillCategories(){
		category = main.getController().getCategories();
		for (int i = 0; i<category.length; i++){
			Category op = category[i]; 
			this.categoryNames.add(op.getCategoryName());
		}
		return this.categoryNames.toArray();
	}
	
	public Object findCategoryImage(int index){
		category = main.getController().getCategories();
		Category op = category[index];
		return op.getCategoryImage();
	}
}
	

