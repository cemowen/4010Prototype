import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;


public class VendorPane extends JPanel {

	/**
	 * Create the panel.
	 */
	public VendorPane() {
		setLayout(null);
		setSize(600,400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		add(label);
		
		JButton vendorBackButton = new JButton();
		vendorBackButton.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		vendorBackButton.setIcon(new ImageIcon(backIco));
		add(vendorBackButton);
		
		String[] columnNames = {"Component Name","Your Price"};
		Object[][] data = {
				
				{"freq. multipliers", "$16.00"},
				{"freq. dividers", "$41.00"},
				{"SPMT switches", "$21.00"},
				{"diplexers", "$34.00"},
				{"limiters", "$31.00"},
				{"switch attenuators", "$18.00"},
				{"op-amps", "$23.00"},
				{"voltage regulators/bias circuits", "$6.00"},
				{"DC-DC converters", "$14.00"},
				{"ADCs", "20.00"},
				{"",""},
				{"",""},
				{"",""}
				
		};
		
		JTable vendortable = new JTable(data,columnNames);
		
		JScrollPane scrollPane = new JScrollPane(vendortable);
		scrollPane.setBounds(44, 136, 500, 206);
		add(scrollPane);
		
		JLabel lblComponentsYouOffer = new JLabel("Components You Offer");
		lblComponentsYouOffer.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblComponentsYouOffer.setBounds(135, 87, 293, 38);
		add(lblComponentsYouOffer);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(432, 353, 112, 23);
		add(btnSaveChanges);
		
		
	}
}
