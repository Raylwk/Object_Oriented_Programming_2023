package gui;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Project_MainFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Menu_LoginScreen extends JPanel{
	private JTextField txtUsername;
	private JTextField txtPassword;
	private Project_MainFrame main;
	public Menu_LoginScreen(Project_MainFrame main) {
		setLayout(null);
		this.main = main;
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setBounds(263, 183, 357, 44);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sign in to your account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(159, 43, 581, 61);
		add(lblNewLabel);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(263, 328, 357, 44);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblUsername = new JLabel("Your Username:");
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblUsername.setBounds(256, 152, 173, 29);
		add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Your Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblNewLabel_1.setBounds(263, 283, 166, 29);
		add(lblNewLabel_1);
		
		ButtonGroup btnGroup = new ButtonGroup();
		JRadioButton rdbtnHead = new JRadioButton("Family Head");
		rdbtnHead.setFont(new Font("Tahoma", Font.ITALIC, 25));
		rdbtnHead.setBounds(260, 454, 169, 39);
		add(rdbtnHead);
		btnGroup.add(rdbtnHead);
		
		JRadioButton rdbtnMember = new JRadioButton("Family Member");
		rdbtnMember.setFont(new Font("Tahoma", Font.ITALIC, 25));
		rdbtnMember.setBounds(263, 514, 201, 39);
		add(rdbtnMember);
		btnGroup.add(rdbtnMember);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreateAccount.setForeground(Color.BLUE);
		btnCreateAccount.setBackground(new Color(255, 255, 255));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showRegisterScreen();
			}
		});
		btnCreateAccount.setBounds(442, 715, 148, 29);
		add(btnCreateAccount);
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(51, 153, 102));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//main.getController().readData();
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				boolean validity = main.getController().verifyUser(username, password);
				if(validity == true){
					if(rdbtnHead.isSelected()){
						if(main.getController().verifyFamilyHead(username, password) == true){
							showFamilyScreen();
						}
						else{
							JOptionPane.showMessageDialog(null, "You do not have family head access.", "Invalid Login",
							JOptionPane.PLAIN_MESSAGE);
						}
					}
					else if(rdbtnMember.isSelected()){
						main.showExpenseScreen(username);
					}
					else{
						JOptionPane.showMessageDialog(null, "Please select a method of login.", "Invalid Login",
						JOptionPane.PLAIN_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong Username or Password.", "Invalid Login",
					JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnLogin.setBounds(263, 602, 357, 66);
		add(btnLogin);
		
		JLabel lblSignInAs = new JLabel("Sign in as a:");
		lblSignInAs.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSignInAs.setBounds(263, 400, 138, 31);
		add(lblSignInAs);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setBounds(263, 719, 164, 20);
		add(lblDontHaveAn);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().readData();
				btnLoadData.setEnabled(false);
				main.getController().disableButton();
			}
		});
		btnLoadData.setBounds(263, 755, 115, 29);
		add(btnLoadData);
		if(main.getController().getIsButtonDisabled() == 1){
			btnLoadData.setEnabled(false);
		}
		
		
		
		JButton btnSaveUsers = new JButton("Save Data");
		btnSaveUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(main.getController().getIsButtonDisabled() == 1){
					main.getController().saveData();
				}
				else{
					main.getController().readData();
					btnLoadData.setEnabled(false);
					main.getController().disableButton();
					main.getController().saveData();
				}
			}
		});
		btnSaveUsers.setBounds(452, 755, 115, 29);
		add(btnSaveUsers);
	}
	
	
	//needs to check for username and what not
	public void showFamilyScreen(){
		this.main.showFamilyScreen();
	}
	public void showRegisterScreen(){
		this.main.showRegisterScreen();
	}
}
