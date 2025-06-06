package gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Project_MainFrame;
import data.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Member_EditProfile extends JPanel{
	private int index;
	private JTextField txtName;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JTextField txtDOB;
	private JLabel lblIsFamilyHead;
	private JLabel lblShowAllowance;
	private Project_MainFrame main;
	private User[] user;
	
	public Member_EditProfile(Project_MainFrame main, int index, User user, String username) {
		this.main = main;
		this.index = index;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(227, 13, 164, 145);
		add(scrollPane);
		
		JLabel lblPhotoToBe = new JLabel("Add or edit photo");
		scrollPane.setViewportView(lblPhotoToBe);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(150, 194, 66, 16);
		add(lblName);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(119, 283, 87, 16);
		add(lblPassword);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateOfBirth.setBounds(100, 328, 106, 16);
		add(lblDateOfBirth);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(119, 235, 97, 16);
		add(lblUsername);
		
		JButton btnSave = new JButton("Save Changes");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtName.getText();
				String username = txtUser.getText();
				String password = txtPassword.getText();
				String dob = txtDOB.getText();
				double allowance = Float.valueOf(lblShowAllowance.getText());
				boolean isFamilyHead = Boolean.parseBoolean(lblIsFamilyHead.getText());
				
				User u = new User();
				u.setName(name);
				u.setUsername(username);
				u.setPassword(password);
				u.setDateofBirth(dob);
				u.setIsFamilyHead(isFamilyHead);
				u.setAllowance(allowance);
				main.getController().editUser(index,u);
			}
		});
		btnSave.setBounds(150, 440, 131, 29);
		add(btnSave);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(228, 193, 144, 22);
		add(txtName);
		txtName.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(227, 234, 144, 22);
		add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(227, 282, 145, 22);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(228, 327, 144, 22);
		add(txtDOB);
		txtDOB.setColumns(10);
		
		lblIsFamilyHead = new JLabel("New label");
		lblIsFamilyHead.setBounds(227, 404, 69, 20);
		add(lblIsFamilyHead);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showProfileScreen(username);
			}
		});
		btnReturn.setBounds(328, 442, 97, 25);
		add(btnReturn);
		
		JLabel lblFamilyHead = new JLabel("Family Head:");
		lblFamilyHead.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFamilyHead.setBounds(119, 403, 97, 21);
		add(lblFamilyHead);
		
		lblShowAllowance = new JLabel("false");
		lblShowAllowance.setBounds(227, 368, 69, 20);
		add(lblShowAllowance);
		
		JLabel lblAllowance = new JLabel("Allowance:");
		lblAllowance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAllowance.setBounds(119, 367, 97, 21);
		add(lblAllowance);
		
		showLabel();
	}
	public void showLabel(){
		user = main.getController().getUsers();
		User u = user[index];
		String familyHead = u.getIsFamilyHead()+"";
		String allowance = u.getAllowance()+"";
		txtUser.setText(u.getUsername());
		txtPassword.setText(u.getPassword());
		lblIsFamilyHead.setText(familyHead);
		lblShowAllowance.setText(allowance);
	}
}
