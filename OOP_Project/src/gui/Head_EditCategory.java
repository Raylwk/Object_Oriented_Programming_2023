package gui;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import controller.Project_MainFrame;
import data.Category;

public class Head_EditCategory extends JPanel{
	private JTextField txtName;
	private Project_MainFrame main;
	private JComboBox cbImage;
	private Object[] imageArr;
	public Head_EditCategory(Project_MainFrame main, int index, Category editCat) {
		this.main = main;
		setLayout(null);
		imageArr = main.getController().getImageArray();
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCategoryScreen();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnReturn.setBounds(387, 33, 212, 26);
		add(btnReturn);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				Object image = cbImage.getSelectedItem();
				Category cat = new Category();
				cat.setCategoryImage(image);
				cat.setCategoryName(name);
				main.getController().editCategory(index, cat);
			}
		});
		btnSaveChanges.setBounds(327, 379, 131, 29);
		add(btnSaveChanges);
		
		JLabel lblEditCategory = new JLabel("Edit Category");
		lblEditCategory.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblEditCategory.setBounds(45, 22, 230, 41);
		add(lblEditCategory);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(125, 164, 83, 20);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(254, 161, 146, 26);
		add(txtName);
		txtName.setColumns(10);
		txtName.setText(""+ editCat.getCategoryName());
		
		JLabel lblImage = new JLabel("Image: ");
		lblImage.setBounds(125, 226, 87, 20);
		add(lblImage);
		
		this.cbImage = new JComboBox(imageArr);
		cbImage.setBounds(287, 195, 134, 100);
		add(cbImage);
		cbImage.setSelectedItem(editCat.getCategoryImage());
	}
	
	public void showCategoryScreen(){
		this.main.showCategoryScreen();
	}
}
