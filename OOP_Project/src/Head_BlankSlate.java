import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Head_BlankSlate extends JPanel{

	public Head_BlankSlate() {
		setLayout(null);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(15, 16, 60, 60);
		add(lblImage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(90, 36, 238, 20);
		add(lblUsername);
	}
}
