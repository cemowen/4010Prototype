import java.awt.*;

import javax.swing.*;



public class WarehousingPanel extends JPanel {
	private JTable table;
	public JButton backButtonWH;
	public JButton saveButtonWH; 
	/**
	 * Create the panel.
	 */
	public WarehousingPanel() {
		setLayout(null);
		setSize(600,400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		add(label);
		
		backButtonWH = new JButton();
		backButtonWH.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource("/back-icon.png")).getImage();
		backButtonWH.setIcon(new ImageIcon(backIco));
		//backButtonWH.addActionListener(MainLogin.handler);
		add(backButtonWH);
		
		JLabel lblWarehousing = new JLabel("Warehousing");
		lblWarehousing.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblWarehousing.setBounds(203, 84, 176, 55);
		add(lblWarehousing);
		
		String[] columnNames = {"Component Name","Quantity"};
		Object[][] data = {
				{"3inch LCD Display", "100"},
				{"oscillator Medium Size", "140"},
				{"up/downconverters", "50"},
				{"freq. multipliers", "46"},
				{"freq. dividers", "81"},
				{"SPMT switches", "121"},
				{"filters", "210"},
				{"variable attenuators", "631"},
				{"PLLs", "26"},
				{"diplexers", "34"},
				{"limiters", "101"},
				{"switch attenuators", "108"},
				{"op-amps", "23"},
				{"voltage regulators/bias circuits", "6"},
				{"DC-DC converters", "14"},
				{"ADCs", "100"}
		};
		table = new JTable(data,columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(44, 136, 500, 206);
		add(scrollPane);
		
		saveButtonWH = new JButton("Save Changes");
		saveButtonWH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveButtonWH.setBounds(394, 353, 150, 36);
		//saveButtonWH.addActionListener(MainLogin.handler);
		add(saveButtonWH);
	}

}
