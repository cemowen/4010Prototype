import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainClass extends JApplet implements ActionListener {
	private JTextField textField;
	private JPasswordField passwordField;
	public String[] loginOptions = {"Warehousing","Buyer","Accounting","Vendor","Customer","Management"};
	JButton btnLogin;
	public JPanel cardPanel,  customerPanel;
	Container container;

	/**
	 * Create the applet.
	 */
	public void init(){
		setSize(600,400);
	}
	
	public MainClass() {
	
		getContentPane().setLayout(null);
		
		JLabel lblLoginId = new JLabel("Login ID");
		lblLoginId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoginId.setBounds(122, 174, 84, 27);
		getContentPane().add(lblLoginId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(122, 205, 94, 26);
		getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(276, 180, 126, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(276, 211, 126, 20);
		getContentPane().add(passwordField);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoginAs.setBounds(122, 242, 84, 27);
		getContentPane().add(lblLoginAs);
		
		JComboBox comboBox = new JComboBox(loginOptions);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(276, 243, 126, 27);
		getContentPane().add(comboBox);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblWelcome.setBounds(177, 97, 181, 46);
		getContentPane().add(lblWelcome);
		
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		getContentPane().add(label);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(455, 326, 115, 40);
		btnLogin.addActionListener(this);
		getContentPane().add(btnLogin);
	
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin){
			
		}
		
	}
}
