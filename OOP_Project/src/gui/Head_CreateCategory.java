package gui;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Project_MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Head_CreateCategory extends JPanel{
	private JTextField txtCategoryName;
	private JTextField txtCategoryImage;
	private Project_MainFrame main;
	private JComboBox cbImage;
	private Object[] imageArr;
	public Head_CreateCategory(Project_MainFrame main) {
		this.main = main;
		setLayout(null);
		imageArr = main.getController().getImageArray();
		
		JButton button = new JButton("Return ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showCategoryScreen();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 25));
		button.setBounds(387, 33, 212, 26);
		add(button);
		
		JButton btnSaveCategory = new JButton("Save Category");
		btnSaveCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoryName = txtCategoryName.getText();
				Object categoryImage = cbImage.getSelectedItem();
				main.getController().addCategory(categoryImage, categoryName);
			}
		});
		btnSaveCategory.setBounds(222, 429, 133, 29);
		add(btnSaveCategory);
		
		JLabel lblCreateNewCategory = new JLabel("Create New Category");
		lblCreateNewCategory.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCreateNewCategory.setBounds(34, 33, 321, 37);
		add(lblCreateNewCategory);
		
		JLabel lblCategoryName = new JLabel("Category Name:");
		lblCategoryName.setBounds(153, 140, 115, 20);
		add(lblCategoryName);
		
		JLabel lblCategoryImage = new JLabel("Category Image:");
		lblCategoryImage.setBounds(153, 237, 119, 20);
		add(lblCategoryImage);
		
		txtCategoryName = new JTextField();
		txtCategoryName.setBounds(275, 137, 146, 26);
		add(txtCategoryName);
		txtCategoryName.setColumns(10);
		
		/*txtCategoryImage = new JTextField();
		txtCategoryImage.setBounds(489, 137, 146, 26);
		add(txtCategoryImage);
		txtCategoryImage.setColumns(10);*/
		
		this.cbImage = new JComboBox(imageArr);
		cbImage.setBounds(287, 195, 134, 100);
		add(cbImage);
	}
}
