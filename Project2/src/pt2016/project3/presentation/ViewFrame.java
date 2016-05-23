package pt2016.project3.presentation;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ViewFrame extends JFrame {

	private JTabbedPane tabbedPane;
	int viewPanelIndex;
	private static final long serialVersionUID = -514801656077986211L;

	private JButton btnProductInsert;
	private JButton btnProductUpdate;
	private JButton btnProductDelete;

	private JLabel lblpId;
	private JLabel lblpName;
	private JLabel lblpPrice;
	private JLabel lblpQuantity;

	private JTextField productID;
	private JTextField productName;
	private JTextField productPrice;
	private JTextField productQuantity;

	private JButton btnCustomerCreate;
	private JButton btnCustomerUpdate;
	private JButton btnCustomerDelete;

	private JLabel lblcName;
	private JLabel lblcID;

	private JTextField customerName;
	private JTextField customerID;

	private JButton oOrder;

	private JLabel lbloProductID;
	private JLabel lblOQuantity;
	private JLabel lbloCustomerID;

	private JTextField orderProductID;
	private JTextField orderQuantity;
	private JTextField orderCustomerID;

	private JTable customerTable;
	private JTable productTable;
	private JTable orderTable;

	private JPanel viewProductsPanel;
	private JPanel viewOrdersPanel;
	private JPanel viewCustomersPanel;

	public ViewFrame() {
		initialize();
		setVisible(true);
	}

	private void initialize() {

		setSize(640, 480);
		setTitle("OrderProcessing");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 604, 419);
		getContentPane().add(tabbedPane);

		JPanel customersPanel = new JPanel();
		tabbedPane.addTab("Customer", null, customersPanel, null);
		customersPanel.setLayout(null);

		lblcID = new JLabel("Customer ID");
		lblcID.setBounds(22, 24, 76, 14);
		customersPanel.add(lblcID);

		customerID = new JTextField();
		customerID.setBounds(96, 21, 300, 20);
		customersPanel.add(customerID);
		customerID.setColumns(10);

		lblcName = new JLabel("Name");
		lblcName.setBounds(22, 52, 46, 14);
		customersPanel.add(lblcName);

		customerName = new JTextField();
		customerName.setBounds(96, 49, 300, 20);
		customersPanel.add(customerName);
		customerName.setColumns(10);

		btnCustomerCreate = new JButton("Add");
		btnCustomerCreate.setBounds(96, 96, 88, 23);
		customersPanel.add(btnCustomerCreate);

		btnCustomerUpdate = new JButton("Update");
		btnCustomerUpdate.setBounds(303, 96, 93, 23);
		customersPanel.add(btnCustomerUpdate);

		btnCustomerDelete = new JButton("Delete");
		btnCustomerDelete.setBounds(194, 96, 99, 23);
		customersPanel.add(btnCustomerDelete);

		JPanel productsPanel = new JPanel();
		tabbedPane.addTab("Product", null, productsPanel, null);
		productsPanel.setLayout(null);

		lblpId = new JLabel("Product ID");
		lblpId.setBounds(22, 24, 64, 14);
		productsPanel.add(lblpId);

		productID = new JTextField();
		productID.setBounds(96, 21, 300, 20);
		productsPanel.add(productID);
		productID.setColumns(10);

		lblpName = new JLabel("Name");
		lblpName.setBounds(22, 52, 64, 14);
		productsPanel.add(lblpName);

		productName = new JTextField();
		productName.setColumns(10);
		productName.setBounds(96, 49, 300, 20);
		productsPanel.add(productName);

		lblpPrice = new JLabel("Price");
		lblpPrice.setBounds(22, 83, 64, 14);
		productsPanel.add(lblpPrice);

		productPrice = new JTextField();
		productPrice.setColumns(10);
		productPrice.setBounds(96, 80, 103, 20);
		productsPanel.add(productPrice);

		lblpQuantity = new JLabel("Quantity");
		lblpQuantity.setBounds(227, 83, 64, 14);
		productsPanel.add(lblpQuantity);

		productQuantity = new JTextField();
		productQuantity.setColumns(10);
		productQuantity.setBounds(293, 80, 103, 20);
		productsPanel.add(productQuantity);

		btnProductInsert = new JButton("Add");
		btnProductInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProductInsert.setBounds(96, 128, 85, 23);
		productsPanel.add(btnProductInsert);

		btnProductUpdate = new JButton("Update");
		btnProductUpdate.setBounds(307, 128, 89, 23);
		productsPanel.add(btnProductUpdate);

		btnProductDelete = new JButton("Delete");
		btnProductDelete.setBounds(191, 128, 94, 23);
		productsPanel.add(btnProductDelete);

		JPanel ordersPanel = new JPanel();
		tabbedPane.addTab("Orders", null, ordersPanel, null);
		ordersPanel.setLayout(null);

		lbloProductID = new JLabel("Product ID");
		lbloProductID.setBounds(22, 52, 64, 14);
		ordersPanel.add(lbloProductID);

		orderProductID = new JTextField();
		orderProductID.setColumns(10);
		orderProductID.setBounds(120, 49, 77, 20);
		ordersPanel.add(orderProductID);

		lblOQuantity = new JLabel("Quantity");
		lblOQuantity.setBounds(22, 97, 64, 14);
		ordersPanel.add(lblOQuantity);

		orderQuantity = new JTextField();
		orderQuantity.setColumns(10);
		orderQuantity.setBounds(120, 94, 77, 20);
		ordersPanel.add(orderQuantity);

		lbloCustomerID = new JLabel("Customer ID");
		lbloCustomerID.setBounds(234, 52, 77, 14);
		ordersPanel.add(lbloCustomerID);

		orderCustomerID = new JTextField();
		orderCustomerID.setColumns(10);
		orderCustomerID.setBounds(321, 49, 77, 20);
		ordersPanel.add(orderCustomerID);

		oOrder = new JButton("Get order!");
		oOrder.setBounds(244, 83, 187, 43);
		ordersPanel.add(oOrder);

		JTabbedPane viewProducts = new JTabbedPane(JTabbedPane.TOP);

		viewPanelIndex = viewProducts.getSelectedIndex();

		viewProductsPanel = new JPanel();
		tabbedPane.addTab("View Products", null, viewProductsPanel, null);
		viewProductsPanel.setLayout(null);

		JTabbedPane viewCustomers = new JTabbedPane(JTabbedPane.TOP);
		viewCustomersPanel = new JPanel();
		tabbedPane.addTab("View Customers", null, viewCustomersPanel, null);
		viewCustomersPanel.setLayout(null);

		JTabbedPane viewOrders = new JTabbedPane(JTabbedPane.TOP);
		viewOrdersPanel = new JPanel();
		tabbedPane.addTab("View Orders", null, viewOrdersPanel, null);
		viewOrdersPanel.setLayout(null);

	}

	public void setCustomerInsertActionListener(ActionListener a) {
		btnCustomerCreate.addActionListener(a);
	}

	public void setCustomerUpdateEditActionListener(ActionListener a) {
		btnCustomerUpdate.addActionListener(a);
	}

	public void setCustomerDeleteActionListener(ActionListener a) {
		btnCustomerDelete.addActionListener(a);
	}

	public void setProductCreateActionListener(ActionListener a) {
		btnProductInsert.addActionListener(a);
	}

	public void setProductUpdateActionListener(ActionListener a) {
		btnProductUpdate.addActionListener(a);
	}

	public void setProductDeleteActionListener(ActionListener a) {
		btnProductDelete.addActionListener(a);
	}

	public void setoOrderActionListener(ActionListener a) {
		oOrder.addActionListener(a);
	}

	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(viewPanelIndex);
		}
	}

	public JButton getBtnProductInsert() {
		return btnProductInsert;
	}

	public void setBtnProductInsert(JButton btnProductInsert) {
		this.btnProductInsert = btnProductInsert;
	}

	public JButton getBtnProductUpdate() {
		return btnProductUpdate;
	}

	public void setBtnProductUpdate(JButton btnProductUpdate) {
		this.btnProductUpdate = btnProductUpdate;
	}

	public JButton getBtnProductDelete() {
		return btnProductDelete;
	}

	public void setBtnProductDelete(JButton btnProductDelete) {
		this.btnProductDelete = btnProductDelete;
	}

	public JLabel getLblpId() {
		return lblpId;
	}

	public void setLblpId(JLabel lblpId) {
		this.lblpId = lblpId;
	}

	public JLabel getLblpName() {
		return lblpName;
	}

	public void setLblpName(JLabel lblpName) {
		this.lblpName = lblpName;
	}

	public JLabel getLblpPrice() {
		return lblpPrice;
	}

	public void setLblpPrice(JLabel lblpPrice) {
		this.lblpPrice = lblpPrice;
	}

	public JLabel getLblpQuantity() {
		return lblpQuantity;
	}

	public void setLblpQuantity(JLabel lblpQuantity) {
		this.lblpQuantity = lblpQuantity;
	}

	public JTextField getProductID() {
		return productID;
	}

	public void setProductID(JTextField productID) {
		this.productID = productID;
	}

	public JTextField getProductName() {
		return productName;
	}

	public void setProductName(JTextField productName) {
		this.productName = productName;
	}

	public JTextField getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(JTextField productPrice) {
		this.productPrice = productPrice;
	}

	public JTextField getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(JTextField productQuantity) {
		this.productQuantity = productQuantity;
	}

	public JButton getBtnCustomerCreate() {
		return btnCustomerCreate;
	}

	public void setBtnCustomerCreate(JButton btnCustomerCreate) {
		this.btnCustomerCreate = btnCustomerCreate;
	}

	public JButton getBtnCustomerUpdate() {
		return btnCustomerUpdate;
	}

	public void setBtnCustomerUpdate(JButton btnCustomerUpdate) {
		this.btnCustomerUpdate = btnCustomerUpdate;
	}

	public JButton getBtnCustomerDelete() {
		return btnCustomerDelete;
	}

	public void setBtnCustomerDelete(JButton btnCustomerDelete) {
		this.btnCustomerDelete = btnCustomerDelete;
	}

	public JLabel getLblcName() {
		return lblcName;
	}

	public void setLblcName(JLabel lblcName) {
		this.lblcName = lblcName;
	}

	public JLabel getLblcID() {
		return lblcID;
	}

	public void setLblcID(JLabel lblcID) {
		this.lblcID = lblcID;
	}

	public JTextField getCustomerName() {
		return customerName;
	}

	public void setCustomerName(JTextField customerName) {
		this.customerName = customerName;
	}

	public JTextField getCustomerID() {
		return customerID;
	}

	public void setCustomerID(JTextField customerID) {
		this.customerID = customerID;
	}

	public JButton getoOrder() {
		return oOrder;
	}

	public void setoOrder(JButton oOrder) {
		this.oOrder = oOrder;
	}

	public JLabel getLbloProductID() {
		return lbloProductID;
	}

	public void setLbloProductID(JLabel lbloProductID) {
		this.lbloProductID = lbloProductID;
	}

	public JLabel getLblOQuantity() {
		return lblOQuantity;
	}

	public void setLblOQuantity(JLabel lblOQuantity) {
		this.lblOQuantity = lblOQuantity;
	}

	public JLabel getLbloCustomerID() {
		return lbloCustomerID;
	}

	public void setLbloCustomerID(JLabel lbloCustomerID) {
		this.lbloCustomerID = lbloCustomerID;
	}

	public JTextField getOrderProductID() {
		return orderProductID;
	}

	public void setOrderProductID(JTextField orderProductID) {
		this.orderProductID = orderProductID;
	}

	public JTextField getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(JTextField orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public JTextField getOrderCustomerID() {
		return orderCustomerID;
	}

	public void setOrderCustomerID(JTextField orderCustomerID) {
		this.orderCustomerID = orderCustomerID;
	}

	public void setcustomerTable(String[] columnNames, Object[][] rowData) {
		if (customerTable != null) {
			customerTable.setVisible(false);
			customerTable.removeAll();
		}
		TableModel tm = new DefaultTableModel(rowData, columnNames);
		customerTable = new JTable(tm);
		customerTable.setBounds(10, 11, 554, 319);
		viewCustomersPanel.add(customerTable);
		resizeColumnWidth(customerTable);
	}

	public void setproductTable(String[] columnNames, Object[][] rowData) {
		if (productTable != null) {
			productTable.setVisible(false);
			productTable.removeAll();
		}
		TableModel tm = new DefaultTableModel(rowData, columnNames);
		productTable = new JTable(tm);
		productTable.setBounds(10, 11, 554, 319);
		viewProductsPanel.add(productTable);
		resizeColumnWidth(productTable);
	}

	public void setorderTable(String[] columnNames, Object[][] rowData) {

		if (orderTable != null) {
			orderTable.setVisible(false);
			orderTable.removeAll();
		}
		TableModel tm = new DefaultTableModel(rowData, columnNames);
		orderTable = new JTable(tm);
		orderTable.setBounds(10, 11, 554, 319);
		viewOrdersPanel.add(orderTable);
		resizeColumnWidth(orderTable);
	}

	private void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 20;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}
