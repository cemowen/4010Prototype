import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;


public class ProcurementOrder extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProcurementOrder() {
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
		
		JLabel lblPlaceProcurementOrder = new JLabel("Place Procurement Order");
		lblPlaceProcurementOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPlaceProcurementOrder.setBounds(114, 134, 355, 55);
		add(lblPlaceProcurementOrder);
		
		JLabel lblSelectComponent = new JLabel("Select Component");
		lblSelectComponent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectComponent.setBounds(114, 228, 106, 23);
		add(lblSelectComponent);
		
		JLabel lblSelectVendor = new JLabel("Select Vendor");
		lblSelectVendor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectVendor.setBounds(114, 261, 88, 23);
		add(lblSelectVendor);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBounds(114, 295, 63, 24);
		add(lblQuantity);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(262, 229, 175, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(262, 264, 175, 20);
		add(comboBox_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(262, 298, 63, 20);
		add(spinner);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPlaceOrder.setBounds(262, 329, 111, 23);
		add(btnPlaceOrder);
		
		
	}

}
