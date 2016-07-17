import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;


public class CustomerPanel extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		JTextField textField;
		setLayout(null);
		setSize(600,400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		add(label);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(backIco));
		add(btnNewButton);
		
		JLabel lblNewCustomerOrder = new JLabel("New Customer Order");
		lblNewCustomerOrder.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewCustomerOrder.setBounds(109, 97, 290, 58);
		add(lblNewCustomerOrder);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(57, 194, 99, 22);
		add(lblProductName);
		
		textField = new JTextField();
		textField.setBounds(166, 195, 227, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblOrderQuantity = new JLabel("Order Quantity");
		lblOrderQuantity.setBounds(57, 229, 99, 22);
		add(lblOrderQuantity);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(166, 226, 46, 20);
		add(spinner);
		
		JLabel lblUploadSpecifications = new JLabel("Upload Specifications");
		lblUploadSpecifications.setBounds(57, 270, 167, 22);
		add(lblUploadSpecifications);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(304, 270, 89, 23);
		add(btnBrowse);
		
		JLabel lblUploadAFile = new JLabel("select a file...");
		lblUploadAFile.setBounds(109, 302, 284, 18);
		add(lblUploadAFile);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(57, 331, 147, 37);
		add(btnPlaceOrder);
		
		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.setBounds(226, 331, 167, 37);
		add(btnViewOrders);
		
		JLabel lblNewLabel = new JLabel("backgroundLabel");
		lblNewLabel.setBounds(0, 0, 600, 400);
		add(lblNewLabel);
	}
}
