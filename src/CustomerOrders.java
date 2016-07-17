import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;
import java.awt.Font;


public class CustomerOrders extends JPanel {
	private JTable table;
	JScrollPane scrollPane;
	JButton btnNewButton;
	/**
	 * Create the panel.
	 */
	public CustomerOrders() {
		setLayout(null);
		setSize(600,400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		add(label);
		
		btnNewButton = new JButton();
		btnNewButton.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(backIco));
		add(btnNewButton);
		
		String[] columnNames = {"Order","Quantity","Status"};
		Object[][] data = {
				{"Black & Decker Toaster Mo.1234", "100","Pending"},
				{"Black & Decker Microwave", "140","Processing"},
				{"Black & Decker Blender Industrial", "50","Shipping"},
				{" ", " "," "},
				{" ", " "," "},
				{" ", " "," "},
				{" ", " "," "},
				{" ", " "," "},
				{" ", " "," "},
				{" ", " "," "},
				{" ", " "," "},
		};
		table = new JTable(data,columnNames);
		//table.setBounds(60, 332, 393, -173);
		scrollPane = new JScrollPane( table );
		
	
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(55, 150, 474, 208);
		add(scrollPane_1);
		
		JLabel lblYourOrders = new JLabel("Your Orders");
		lblYourOrders.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblYourOrders.setBounds(180, 89, 218, 50);
		add(lblYourOrders);
		
	}
	
}
