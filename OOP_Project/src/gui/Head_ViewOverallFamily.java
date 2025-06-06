package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.Project_MainFrame;
import data.Category;
import data.Expense;
import data.FamilyMember;
import data.User;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
public class Head_ViewOverallFamily extends JPanel{
	private Project_MainFrame main;
	private JTable familyTable;
	private FamilyMember[] familyMember;
	private User[] user;
	private Expense[] expense;
	private String[] months = {"January", "Febraury", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private int index;
	private double spending = 0;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public Head_ViewOverallFamily(Project_MainFrame main){
		this.main = main;
		setLayout(null);
		
		//scroll pane for family members
		this.familyTable = new JTable();
		familyTable.setDefaultEditor(Object.class, null);
		JScrollPane familyScrollPane = new JScrollPane(familyTable);
		familyScrollPane.setBounds(15, 176, 624, 431);
		familyScrollPane.setViewportView(this.familyTable);
		add(familyScrollPane);
		
		JLabel lblFamilyMembers = new JLabel("Family Members");
		lblFamilyMembers.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblFamilyMembers.setBounds(176, 16, 247, 37);
		add(lblFamilyMembers);
		
		JButton btnViewCategories = new JButton("Click to View Categories");
		btnViewCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showCategoryScreen();
			}
		});
		btnViewCategories.setBounds(15, 90, 203, 29);
		add(btnViewCategories);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginScreen();
			}
		});
		btnLogout.setBounds(516, 16, 115, 29);
		add(btnLogout);
		
		JButton btnViewMember = new JButton("View Member");
		btnViewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "Please select a family member";
				int index = familyTable.getSelectedRow();
				if (index == -1){
					JOptionPane.showMessageDialog(null, msg, "Error",
					JOptionPane.PLAIN_MESSAGE);
					return;
				}
				User n = user[index];
				main.showViewExpenseScreen(index, n);
			}
		});
		btnViewMember.setBounds(502, 90, 137, 29);
		add(btnViewMember);
		
		JButton btnEditAllowance = new JButton("Edit Allowance");
		btnEditAllowance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "Please select a family member";
				int index = familyTable.getSelectedRow();
				if (index == -1){
					JOptionPane.showMessageDialog(null, msg, "Error",
					JOptionPane.PLAIN_MESSAGE);
					return;
				}
				User u = user[index];
				main.showEditAllowanceScreen(index, u);
			}
		});
		btnEditAllowance.setBounds(268, 90, 190, 29);
		add(btnEditAllowance);
		
		JLabel lblTotalExpense = new JLabel("Total Expense:");
		lblTotalExpense.setBounds(394, 623, 105, 20);
		add(lblTotalExpense);
		
		JLabel lblShowTotalExpense = new JLabel(String.valueOf(calculateTotalExpense()));
		lblShowTotalExpense.setBounds(533, 623, 106, 20);
		add(lblShowTotalExpense);
		
		populateFamilyTable();
	}
	
	public void populateFamilyTable(){
		user = main.getController().getUsers();
		expense = main.getController().getExpense();
		DefaultTableModel tableModel = new DefaultTableModel();
		//Use when implementing Images for FamilyMembers
		/*{
			@Override
	        public Class<?> getColumnClass(int column) {
	            if (column==0) return ImageIcon.class;
	            return Object.class;
	        }
		};*/
		
		tableModel.addColumn("Name");
		tableModel.addColumn("Allowance");
		tableModel.addColumn("Spending");
		
		for(int i=0; i<this.user.length; i++){
			this.spending = 0;
			User op = user[i]; 
			for(int i1=0; i1<expense.length; i1++){
				Expense ex = expense[i1];
				if (op.getUsername().equals(ex.getUserId())){
					this.spending = this.spending + ex.getAmount();
				}
			}
			Object[] data = new Object[]{op.getName(), "$"+df.format(op.getAllowance()),"$"+df.format(spending)};
			tableModel.insertRow(i, data);
		}
		this.familyTable.setModel(tableModel);
	}
	
	public double calculateTotalExpense(){
		double totalExpense = 0;
		user = main.getController().getUsers();
		expense = main.getController().getExpense();
		for(int i=0; i<this.user.length; i++){
			this.spending = 0;
			User op = user[i]; 
			for(int i1=0; i1<expense.length; i1++){
				Expense ex = expense[i1];
				if (op.getUsername().equals(ex.getUserId())){
					this.spending = this.spending + ex.getAmount();
				}
			}
			totalExpense = totalExpense + spending;
		}
		return totalExpense;
	}
}
