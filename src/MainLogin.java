import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

public class MainLogin extends JApplet implements ActionListener {
	public static Container container;
	public static CustomerOrders cOrder;
	public static CustomerPanel customerP;
	public static ProcurementOrder pO;
	public static WarehousingPanel wP;
	public static CardLayout deckManager = new CardLayout();
	public static JPanel deck, panel1;

	public String[] loginOptions = { "Warehousing", "Buyer", "Accounting",
			"Vendor", "Customer", "Management" };
	public String[] components1 = { " ", "3inch LCD Display",
			"oscillator Medium Size", "up/downconverters", "freq. multipliers",
			"freq. dividers", "SPMT switches", "filters",
			"variable attenuators", "PLLs", "diplexers", "limiters",
			"switch attenuators", "op-amps",
			"voltage regulators/bias circuits", "DC-DC converters", "ADCs" };
	public String[] vendorList = { "", "Acbel Polytech Inc.",
			"Alps Electric Co. Ltd.", "Amphenol Corp",
			"Asia Vital Components Ltd." };
	public String[][] orders = {
			{ "Black & Decker Toaster Mo.1234", "100", "Pending" },
			{ "Black & Decker Microwave", "140", "Processing" },
			{ "Black & Decker Blender Industrial", "50", "Shipping" }
			 };
	public static JButton btnLogin;
	public static JTextField textField, productNameField;
	public static JPasswordField passwordField;
	public static JComboBox<String> comboBox;
	public JComboBox<String> comboBoxComp;
	JComboBox<String> comboBoxVendor;
	JSpinner spinnerQuan;

	private JTable table;
	public JLabel lblUploadAFile;
	public JButton backButtonWH;
	public JButton saveButtonWH, btnViewOrders, btnPlaceOrder, backButtonCP,
			btnBrowse;
	public JTable table1;
	public JScrollPane scrollPane;
	public JButton cOBackButton, vendorBackButton;
	public JSpinner spinnerCO;
	JButton btnPlaceProcOrder, btnProcBackButton, vendorSaveChanges;

	public void init() {
		setSize(600, 400);
		container = getContentPane();
		container.setLayout(new GridLayout(1, 1));
		deck = new JPanel();
		deck.setLayout(deckManager);
		panel1 = new JPanel();
		panel1.setLayout(null);
		/*
		 * JLabel lblNewLabel = new JLabel("backgroundLabel");
		 * lblNewLabel.setBounds(0, 0, 600, 400); Image bg = new
		 * ImageIcon(this.getClass().getResource("/background.png")).getImage();
		 * lblNewLabel.setIcon(new ImageIcon(bg)); panel1.add(lblNewLabel);
		 */
		JLabel lblLoginId = new JLabel("Login ID");
		lblLoginId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoginId.setBounds(122, 174, 84, 27);
		panel1.add(lblLoginId);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(122, 205, 94, 26);
		panel1.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(276, 180, 126, 20);
		textField.setColumns(10);
		panel1.add(textField);

		passwordField = new JPasswordField();
		passwordField.setBounds(276, 211, 126, 20);
		panel1.add(passwordField);

		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLoginAs.setBounds(122, 242, 84, 27);
		panel1.add(lblLoginAs);

		comboBox = new JComboBox<String>(loginOptions);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(276, 243, 126, 27);
		panel1.add(comboBox);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblWelcome.setBounds(177, 97, 181, 46);
		panel1.add(lblWelcome);

		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource(
				"/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		panel1.add(label);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(455, 326, 115, 40);
		btnLogin.addActionListener(this);
		panel1.add(btnLogin);
		deck.add(panel1, "panel1");
		container.add(deck);

	}

	public MainLogin() {
		CustomerOrders cOrder = new CustomerOrders();
		customerP = new CustomerPanel();
		pO = new ProcurementOrder();
		wP = new WarehousingPanel();

	}

	// ___________________________________________
	public JPanel warehousePane() {
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setSize(600, 400);
		/*
		 * JLabel lblNewLabel = new JLabel("backgroundLabel");
		 * lblNewLabel.setBounds(0, 0, 600, 400); Image bg = new
		 * ImageIcon(this.getClass().getResource("/background.png")).getImage();
		 * lblNewLabel.setIcon(new ImageIcon(bg)); p.add(lblNewLabel);
		 */
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource(
				"/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		p.add(label);

		backButtonWH = new JButton();
		backButtonWH.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource(
				"/back-icon.png")).getImage();
		backButtonWH.setIcon(new ImageIcon(backIco));
		backButtonWH.addActionListener(this);
		p.add(backButtonWH);

		JLabel lblWarehousing = new JLabel("Warehousing");
		lblWarehousing.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblWarehousing.setBounds(203, 84, 176, 55);
		p.add(lblWarehousing);

		String[] columnNames = { "Component Name", "Quantity" };
		Object[][] data = { { "3inch LCD Display", "100" },
				{ "oscillator Medium Size", "140" },
				{ "up/downconverters", "50" }, { "freq. multipliers", "46" },
				{ "freq. dividers", "81" }, { "SPMT switches", "121" },
				{ "filters", "210" }, { "variable attenuators", "631" },
				{ "PLLs", "26" }, { "diplexers", "34" }, { "limiters", "101" },
				{ "switch attenuators", "108" }, { "op-amps", "23" },
				{ "voltage regulators/bias circuits", "6" },
				{ "DC-DC converters", "14" }, { "ADCs", "100" } };
		table = new JTable(data, columnNames);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(44, 136, 500, 206);
		p.add(scrollPane);

		saveButtonWH = new JButton("Save Changes");
		saveButtonWH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveButtonWH.setBounds(394, 353, 150, 36);
		saveButtonWH.addActionListener(this);
		p.add(saveButtonWH);
		return p;
	}

	public JPanel customerPane() {
		JPanel p = new JPanel();

		p.setLayout(null);
		p.setSize(600, 400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource(
				"/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		p.add(label);

		backButtonCP = new JButton();
		backButtonCP.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource(
				"/back-icon.png")).getImage();
		backButtonCP.setIcon(new ImageIcon(backIco));
		backButtonCP.addActionListener(this);
		p.add(backButtonCP);

		JLabel lblNewCustomerOrder = new JLabel("New Customer Order");
		lblNewCustomerOrder.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewCustomerOrder.setBounds(109, 97, 290, 58);
		p.add(lblNewCustomerOrder);

		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(57, 194, 99, 22);
		p.add(lblProductName);

		productNameField = new JTextField();
		productNameField.setBounds(166, 195, 227, 20);
		p.add(productNameField);
		productNameField.setColumns(10);

		JLabel lblOrderQuantity = new JLabel("Order Quantity");
		lblOrderQuantity.setBounds(57, 229, 99, 22);
		p.add(lblOrderQuantity);

		spinnerCO = new JSpinner();
		spinnerCO.setBounds(166, 226, 46, 20);
		p.add(spinnerCO);

		JLabel lblUploadSpecifications = new JLabel("Upload Specifications");
		lblUploadSpecifications.setBounds(57, 270, 167, 22);
		p.add(lblUploadSpecifications);

		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(304, 270, 89, 23);
		btnBrowse.addActionListener(this);
		p.add(btnBrowse);

		lblUploadAFile = new JLabel("select a file...");
		lblUploadAFile.setBounds(109, 302, 284, 18);
		p.add(lblUploadAFile);

		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(57, 331, 147, 37);
		btnPlaceOrder.addActionListener(this);
		p.add(btnPlaceOrder);

		btnViewOrders = new JButton("View Orders");
		btnViewOrders.setBounds(226, 331, 167, 37);
		btnViewOrders.addActionListener(this);
		p.add(btnViewOrders);
		return p;
	}

	public JPanel customerOrderPane() {
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setSize(600, 400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource(
				"/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		p.add(label);

		cOBackButton = new JButton();
		cOBackButton.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource(
				"/back-icon.png")).getImage();
		cOBackButton.setIcon(new ImageIcon(backIco));
		cOBackButton.addActionListener(this);
		p.add(cOBackButton);

		String[] columnNames = { "Order", "Quantity", "Status" };

		table1 = new JTable(orders, columnNames);

		JScrollPane scrollPane_1 = new JScrollPane(table1);

		scrollPane_1.setBounds(55, 150, 474, 208);
		p.add(scrollPane_1);

		JLabel lblYourOrders = new JLabel("Your Orders");
		lblYourOrders.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblYourOrders.setBounds(180, 89, 218, 50);
		p.add(lblYourOrders);
		return p;
	}

	public JPanel procurementOrderPane() {
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setSize(600, 400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource(
				"/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		p.add(label);

		btnProcBackButton = new JButton();
		btnProcBackButton.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource(
				"/back-icon.png")).getImage();
		btnProcBackButton.setIcon(new ImageIcon(backIco));
		btnProcBackButton.addActionListener(this);
		p.add(btnProcBackButton);

		JLabel lblPlaceProcurementOrder = new JLabel("Place Procurement Order");
		lblPlaceProcurementOrder.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPlaceProcurementOrder.setBounds(114, 134, 355, 55);
		p.add(lblPlaceProcurementOrder);

		JLabel lblSelectComponent = new JLabel("Select Component");
		lblSelectComponent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectComponent.setBounds(114, 228, 106, 23);
		p.add(lblSelectComponent);

		JLabel lblSelectVendor = new JLabel("Select Vendor");
		lblSelectVendor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectVendor.setBounds(114, 261, 88, 23);
		p.add(lblSelectVendor);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBounds(114, 295, 63, 24);
		p.add(lblQuantity);

		comboBoxComp = new JComboBox<String>(components1);
		comboBoxComp.setBounds(262, 229, 175, 20);
		p.add(comboBoxComp);

		comboBoxVendor = new JComboBox<String>(vendorList);
		comboBoxVendor.setBounds(262, 264, 175, 20);
		p.add(comboBoxVendor);
		// spinnerQuan comboBoxComp comboBoxVendor
		spinnerQuan = new JSpinner();
		spinnerQuan.setBounds(262, 298, 63, 20);
		p.add(spinnerQuan);

		btnPlaceProcOrder = new JButton("Place Order");
		btnPlaceProcOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPlaceProcOrder.setBounds(262, 329, 111, 23);
		btnPlaceProcOrder.addActionListener(this);
		p.add(btnPlaceProcOrder);
		return p;
	}

	public JPanel vendorPane() {
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setSize(600, 400);
		JLabel label = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource(
				"/Vandelay Logo1.png")).getImage();
		label.setIcon(new ImageIcon(logo));
		label.setBounds(344, 11, 246, 75);
		p.add(label);

		vendorBackButton = new JButton();
		vendorBackButton.setBounds(10, 11, 75, 50);
		Image backIco = new ImageIcon(this.getClass().getResource(
				"/back-icon.png")).getImage();
		vendorBackButton.setIcon(new ImageIcon(backIco));
		vendorBackButton.addActionListener(this);
		p.add(vendorBackButton);

		String[] columnNames = { "Component Name", "Your Price" };
		Object[][] data = {

				{ "freq. multipliers", "$16.00" }, { "freq. dividers", "$41.00" },
				{ "SPMT switches", "$21.00" }, { "diplexers", "$34.00" },
				{ "limiters", "$31.00" }, { "switch attenuators", "$18.00" },
				{ "op-amps", "$23.00" },
				{ "voltage regulators/bias circuits", "$6.00" },
				{ "DC-DC converters", "$14.00" }, { "ADCs", "20.00" },
				{ "", "" }, { "", "" }, { "", "" }

		};

		JTable vendortable = new JTable(data, columnNames);

		JScrollPane scrollPane = new JScrollPane(vendortable);
		scrollPane.setBounds(44, 136, 500, 206);
		p.add(scrollPane);

		JLabel lblComponentsYouOffer = new JLabel("Components You Offer");
		lblComponentsYouOffer.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblComponentsYouOffer.setBounds(135, 87, 293, 38);
		p.add(lblComponentsYouOffer);

		vendorSaveChanges = new JButton("Save");
		vendorSaveChanges.setBounds(432, 353, 112, 23);
		vendorSaveChanges.addActionListener(this);
		p.add(vendorSaveChanges);

		return p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {

			if (comboBox.getSelectedIndex() == 0) {
				deck.add(warehousePane(), "wP");
				deckManager.show(deck, "wP");
			}
			if (comboBox.getSelectedIndex() == 4) {
				deck.add(customerPane(), "cP");
				deckManager.show(deck, "cP");
			}
			if (comboBox.getSelectedIndex() == 1) {
				deck.add(procurementOrderPane(), "pOP");
				deckManager.show(deck, "pOP");
			}
			if (comboBox.getSelectedIndex() == 3) {
				deck.add(vendorPane(), "vP");
				deckManager.show(deck, "vP");
			}
			comboBox.setSelectedIndex(0);
			textField.setText("");
			passwordField.setText("");

		} else if (e.getSource() == backButtonWH) { // back Warehouse
			deck.add(panel1, "panel1");
			deckManager.show(deck, "panel1");
		} else if (e.getSource() == saveButtonWH) {
			JOptionPane.showMessageDialog(null, "Save Successful", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == backButtonCP) { // back customerPanel
			deck.add(panel1, "panel1");
			deckManager.show(deck, "panel1");
		} else if (e.getSource() == btnPlaceOrder) {
			this.addOrder(productNameField.getText(), spinnerCO.getValue().toString(), "Pending");
			JOptionPane.showMessageDialog(null,
					"Order Placed \nPending Approval", "Info",
					JOptionPane.INFORMATION_MESSAGE);
			lblUploadAFile.setText("select a file..");
			spinnerCO.setValue(0);
			productNameField.setText("");
		}

		else if (e.getSource() == btnBrowse) {

			JFileChooser chooser = new JFileChooser();
			int returnVal = chooser.showOpenDialog(null);
			lblUploadAFile.setText(chooser.getSelectedFile().toString());
		} else if (e.getSource() == btnViewOrders) {
			deck.add(customerOrderPane(), "cOP");
			deckManager.show(deck, "cOP");
		} else if (e.getSource() == cOBackButton) {
			deck.add(customerPane(), "cP");
			deckManager.show(deck, "cP");
		} else if (e.getSource() == btnPlaceProcOrder) {
			// spinnerQuan comboBoxComp comboBoxVendor
			JOptionPane.showMessageDialog(null, "Procurement Order Placed",
					"Info", JOptionPane.INFORMATION_MESSAGE);
			spinnerQuan.setValue(0);
			comboBoxComp.setSelectedIndex(0);
			comboBoxVendor.setSelectedIndex(0);
		} else if (e.getSource() == btnProcBackButton) {
			deck.add(panel1, "panel1");
			deckManager.show(deck, "panel1");
		} else if (e.getSource() == vendorBackButton) {
			deck.add(panel1, "panel1");
			deckManager.show(deck, "panel1");
		} else if (e.getSource() == vendorSaveChanges) {
			JOptionPane.showMessageDialog(null, "Save Successful", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void addOrder(String name, String quantity, String status) {
		System.out.println(orders.length);
		orders = Arrays.copyOf(orders, orders.length + 1);
		System.out.println(orders.length);
		System.out.println(orders.length);
		System.out.println(orders[0][2]);
		String[] t = {name,quantity,status};
		orders[orders.length-1]= t;
		
	}

}
