package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;

public class Head_InspectCategory extends JPanel{

	private JList memberList;
	private JTable table;
	
	public Head_InspectCategory() {
		setLayout(null);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(15, 16, 60, 60);
		add(lblImage);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setBounds(90, 36, 238, 20);
		add(lblCategoryName);
		
		//scroll pane for family members
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 435, 631, -301);
		add(scrollPane);
		
		//JList for family members
		this.memberList = new JList();
		scrollPane.setViewportView(this.memberList);
		memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton = new JButton("Return ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(387, 29, 212, 26);
		add(btnNewButton);
		
		JLabel lblMonthlySpending = new JLabel("Monthly Spending: ");
		lblMonthlySpending.setBounds(15, 92, 144, 20);
		add(lblMonthlySpending);
		
		JLabel lblspending = new JLabel("(Spending)");
		lblspending.setForeground(Color.BLUE);
		lblspending.setBounds(179, 92, 84, 20);
		add(lblspending);
		
		JButton btnEditCategory = new JButton("Edit Category");
		btnEditCategory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditCategory.setBounds(387, 88, 212, 26);
		add(btnEditCategory);
		
		
	}
}
