package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.Project_MainFrame;
import data.Category;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Head_ViewOverallCategories extends JPanel{
	//private Object[][] arrTable;
	private Project_MainFrame main;
	private JTable table;
	private Category[] category;
	private Object[] imageArr;
	private int index;
	public Head_ViewOverallCategories(Project_MainFrame main) {
		setLayout(null);
		this.main = main;
		imageArr = main.getController().getImageArray();
		
		//Scroll Pane & JTable
		this.table = new JTable();
		table.setRowHeight(100);
		table.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 176, 824, 384);
		scrollPane.setViewportView(this.table);
		add(scrollPane);
		
		//Edit Category Button
		JButton btnEditCategory = new JButton("Edit Category");
		btnEditCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "Please select a category";
				int index = table.getSelectedRow();
				if (index == -1){
					JOptionPane.showMessageDialog(null, msg, "Error",
					JOptionPane.PLAIN_MESSAGE);
					return;
				}
				Category editCat = category[index];
				main.showEditCategoryScreen(index, editCat);
			}
		});
		btnEditCategory.setBounds(304, 94, 186, 26);
		add(btnEditCategory);
		
		//Title
		JLabel lblViewCategories = new JLabel("View Categories");
		lblViewCategories.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblViewCategories.setBounds(125, 16, 244, 37);
		add(lblViewCategories);
		
		//Go To Family Panel
		JButton btnClickToView = new JButton("Click to View Family Members");
		btnClickToView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showFamilyScreen();
			}
		});
		btnClickToView.setBounds(30, 93, 243, 29);
		add(btnClickToView);
		
		//Logout Button
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginScreen();
			}
		});
		btnLogout.setBounds(444, 26, 115, 29);
		add(btnLogout);
		
		
		//Create Category Button
		JButton btnCreateCategory = new JButton("Create Category");
		btnCreateCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showCreateCategoryScreen();
			}
		});
		btnCreateCategory.setBounds(516, 93, 145, 29);
		add(btnCreateCategory);
		
		JButton btnDeleteCategory = new JButton("Delete Category");
		btnDeleteCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "Please select a category";
				int index = table.getSelectedRow();
				if (index == -1){
					JOptionPane.showMessageDialog(null, msg, "Error",
					JOptionPane.PLAIN_MESSAGE);
					return;
				}
				main.getController().deleteCategory(index);
				populateCategoryTable();
			}
		});
		btnDeleteCategory.setBounds(684, 93, 145, 29);
		add(btnDeleteCategory);
		populateCategoryTable();
	}
	
	public void populateCategoryTable(){
		category = main.getController().getCategories();
		DefaultTableModel tableModel = new DefaultTableModel(){
			@Override
	        public Class<?> getColumnClass(int column) {
	            if (column==0) return ImageIcon.class;
	            return Object.class;
	        }
		};
		tableModel.addColumn("Icon");
		tableModel.addColumn("Name");
		
		for(int i=0; i<category.length; i++){
			Category op = category[i]; 
			Object[] data = new Object[]{op.getCategoryImage(), op.getCategoryName()};
			tableModel.insertRow(i, data);
		}
		
		this.table.setModel(tableModel);
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setMinWidth(100);
        column.setMaxWidth(100);
        column.setPreferredWidth(100);
	}
}
