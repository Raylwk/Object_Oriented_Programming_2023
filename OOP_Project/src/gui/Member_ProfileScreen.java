package gui;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Project_MainFrame;
import data.Category;
import data.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Member_ProfileScreen extends JPanel{
	private int index;
	private Project_MainFrame main;
	private User[] user;;
	private JLabel lblname, lblUser, lblpassword, lbldob, lblallowance;
	private int i;
	public Member_ProfileScreen(Project_MainFrame main, String username) {
		this.main = main;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(227, 13, 164, 145);
		add(scrollPane);
		
		JLabel lblPhotoToBe = new JLabel("Photo to be added");
		scrollPane.setViewportView(lblPhotoToBe);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(150, 205, 66, 16);
		add(lblName);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(119, 288, 87, 16);
		add(lblPassword);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateOfBirth.setBounds(100, 331, 106, 16);
		add(lblDateOfBirth);
		
		JLabel lblAllowance = new JLabel("Allowance :");
		lblAllowance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAllowance.setBounds(119, 374, 87, 16);
		add(lblAllowance);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(119, 247, 97, 16);
		add(lblUsername);
		
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User editUser = user[index];
				main.showProfileEditScreen(editUser,index, username);
			}
		});
		btnEdit.setBounds(269, 413, 97, 25);
		add(btnEdit);
		
		this.lblname = new JLabel("(Unset)");
		lblname.setBounds(253, 208, 164, 14);
		add(lblname);
		
		this.lblUser = new JLabel("(Unset)");
		lblUser.setBounds(253, 249, 180, 16);
		lblUser.setText(username);
		add(lblUser);
		//this.lblUser.setText(us.getUsername());
		
		this.lblpassword = new JLabel("(Password)");
		lblpassword.setBounds(255, 290, 162, 16);
		add(lblpassword);
		//this.lblpassword.setText(us.getPassword());
		
		this.lbldob = new JLabel("Unset");
		lbldob.setBounds(253, 333, 133, 16);
		add(lbldob);
		
		this.lblallowance = new JLabel("(Allowance)");
		lblallowance.setBounds(253, 377, 147, 14);
		add(lblallowance);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(450, 13, 169, 38);
		add(comboBox);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = lblName.getText();
				main.showExpenseScreen(lblUser.getText());
			}
		});
		btnReturn.setBounds(458, 411, 115, 29);
		add(btnReturn);
		
		JButton btnSaveToFile = new JButton("Save to FIle");
		btnSaveToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().saveData();
			}
		});
		btnSaveToFile.setBounds(26, 411, 115, 29);
		add(btnSaveToFile);
		
		populatelbl();
	}
	
	public void populatelbl(){
		user = main.getController().getUsers();
		for (int i=0;i<this.user.length;i++) {
		    if (user[i].getUsername().equals(this.lblUser.getText())) {
		        this.index = i;
		        break;
		    }
		}
		User u = user[index];
		
		this.lblname.setText(u.getName());
		this.lblUser.setText(u.getUsername());
		this.lblpassword.setText(u.getPassword());
		this.lbldob.setText(u.getDateofBirth());
		String allowance = u.getAllowance()+"";
		this.lblallowance.setText(allowance);
	}
	public int getIndex(){
		user = main.getController().getUsers();
		for (int i=0;i<this.user.length;i++) {
		    if (user[i].getUsername().equals(this.lblUser.getText())) {
		        break; 
		    }
		}
		return i;
	}
}
