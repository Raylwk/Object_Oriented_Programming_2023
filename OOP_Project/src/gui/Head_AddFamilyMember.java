package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.Project_MainFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Head_AddFamilyMember extends JPanel{
	private JTextField txtName;
	private JTextField txtSpending;
	private Project_MainFrame main;
	public Head_AddFamilyMember(Project_MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JLabel lblAddFamilyMember = new JLabel("Add Family Member");
		lblAddFamilyMember.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblAddFamilyMember.setBounds(214, 16, 499, 61);
		add(lblAddFamilyMember);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(214, 142, 69, 20);
		add(lblName);
		
		JLabel lblSpending = new JLabel("Spending:");
		lblSpending.setBounds(214, 208, 88, 20);
		add(lblSpending);
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(322, 139, 146, 26);
		add(txtName);
		txtName.setColumns(10);
		
		txtSpending = new JTextField();
		txtSpending.setText("1000.50");
		txtSpending.setBounds(322, 205, 146, 26);
		add(txtSpending);
		txtSpending.setColumns(10);
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				float spending= Float.valueOf(txtSpending.getText());
				main.getController().addFamilyMember(name, spending);
			}
		});
		btnAddMember.setBounds(277, 337, 123, 29);
		add(btnAddMember);
		
		JButton btnBack = new JButton("Back ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showFamilyScreen();
			}
		});
		btnBack.setBounds(495, 337, 115, 29);
		add(btnBack);
	}
}
