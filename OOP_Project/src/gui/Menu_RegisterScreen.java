package gui;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Project_MainFrame;
import data.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Menu_RegisterScreen extends JPanel {
	private User[] user;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;
	private Project_MainFrame main;
	String msg;
	String selection;
	boolean familyHead;
	public Menu_RegisterScreen(Project_MainFrame main) {
		this.main = main;
		setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBounds(203, 149, 197, 30);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(203, 238, 197, 30);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtConfirmPassword.setBounds(203, 324, 197, 30);
		add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
		JLabel lblAccountRegisteror = new JLabel("Account Registering Portal");
		lblAccountRegisteror.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAccountRegisteror.setBounds(184, 30, 280, 46);
		add(lblAccountRegisteror);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(205, 128, 97, 18);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(203, 219, 99, 16);
		add(lblPassword);
		
		JCheckBox chckbxRegisterAsFamily = new JCheckBox("Register me as Family Head");
		chckbxRegisterAsFamily.setBounds(413, 152, 229, 29);
		add(chckbxRegisterAsFamily);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Check for matching passwords
				if(txtPassword.getText().equals(txtConfirmPassword.getText())){
				
					//Checking for Family Head or Family Member
					if(chckbxRegisterAsFamily.isSelected()){
						selection = "Family Head";
						familyHead = true;
					}
					else{
						selection = "Family Member";
						familyHead = false;
					}
					
					//Store Name and Password in data storage
					String username = txtUsername.getText();
					String password = txtPassword.getText();
					boolean isFamilyHead = familyHead;
					main.getController().addUser(username, password, null, null, isFamilyHead);
					
					//Message Dialog to confirm Registration
					msg = ("You have successfully registered as " + selection);
					JOptionPane.showMessageDialog(null, msg, "Successful Registration",
					JOptionPane.PLAIN_MESSAGE);
					
					//Return User to login screen
					showLoginScreen();
				}
				else{
					msg = ("Passwords do not match.");
					JOptionPane.showMessageDialog(null, msg, "Registration Error",
					JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(119, 391, 161, 30);
		add(btnRegister);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(203, 298, 161, 25);
		add(lblConfirmPassword);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showLoginScreen();
			}
		});
		btnReturn.setBounds(349, 392, 115, 29);
		add(btnReturn);
	}
	
	public void showLoginScreen(){
		this.main.showLoginScreen();
	}
}
