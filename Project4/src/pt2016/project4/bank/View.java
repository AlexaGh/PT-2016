package pt2016.project4.bank;

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

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTabbedPane tabbedPane;
	private JLabel customerName;
	private JLabel customerAge;
	private JLabel customersAccountId;
	private JLabel sum;
	private JLabel accType;
	private JTextField customerNametf;
	private JTextField customerAgetf;
	private JTextField customersAccIdtf;
	private JTextField sumtf;
	private JTextField accTypetf;

	private JButton btnCreateClient;
	private JButton btnCreateAccount;
	private JButton btnDisplayClients;
	private JButton btnDisplayAccounts;
	private JButton btnDeleteClient;
	private JButton btnDeleteAccount;
	private JButton btnDepositMoney;
	private JButton btnWithdrawMoney;

	public JPanel viewAllClientsPanel;
	public JPanel viewAccountsOfaClientPanel;

	public JTable clientsTable;
	public JTable accountsTable;
	
	public View() {
		initialize();
		setVisible(true);

	}

	private void initialize() {

		setSize(640, 480);
		setTitle("Bank");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 604, 419);
		getContentPane().add(tabbedPane);

		JPanel personPanel = new JPanel();
		tabbedPane.addTab("Person", null, personPanel, null);
		personPanel.setLayout(null);

		customerName = new JLabel("Name");
		customerName.setBounds(27, 24, 46, 14);
		personPanel.add(customerName);

		customerNametf = new JTextField();
		customerNametf.setBounds(109, 21, 195, 20);
		personPanel.add(customerNametf);
		customerNametf.setColumns(10);

		customerAge = new JLabel("Age");
		customerAge.setBounds(27, 55, 62, 14);
		personPanel.add(customerAge);

		customerAgetf = new JTextField();
		customerAgetf.setBounds(109, 52, 195, 20);
		personPanel.add(customerAgetf);
		customerAgetf.setColumns(10);

		customersAccountId = new JLabel("Account ID");
		customersAccountId.setBounds(27, 86, 62, 14);
		personPanel.add(customersAccountId);

		customersAccIdtf = new JTextField();
		customersAccIdtf.setBounds(109, 83, 195, 20);
		personPanel.add(customersAccIdtf);
		customersAccIdtf.setColumns(10);

		sum = new JLabel("Sum");
		sum.setBounds(27, 150, 62, 14);
		personPanel.add(sum);

		sumtf = new JTextField();
		sumtf.setBounds(109, 147, 195, 20);
		personPanel.add(sumtf);
		sumtf.setColumns(10);

		accType = new JLabel("Acc Type");
		accType.setBounds(27, 117, 62, 14);
		personPanel.add(accType);

		accTypetf = new JTextField();
		accTypetf.setBounds(109, 114, 195, 20);
		personPanel.add(accTypetf);
		accTypetf.setColumns(10);

		btnCreateClient = new JButton("Add Client");
		btnCreateClient.setBounds(326, 16, 123, 31);
		personPanel.add(btnCreateClient);

		btnCreateAccount = new JButton("Add Account");
		btnCreateAccount.setBounds(459, 16, 123, 31);
		personPanel.add(btnCreateAccount);

		btnDisplayClients = new JButton("Display Clients");
		btnDisplayClients.setBounds(326, 109, 237, 31);
		personPanel.add(btnDisplayClients);

		btnDisplayAccounts = new JButton("Display Accounts of client");
		btnDisplayAccounts.setBounds(326, 155, 237, 31);
		personPanel.add(btnDisplayAccounts);

		btnDeleteClient = new JButton("Delete Client");
		btnDeleteClient.setBounds(326, 69, 123, 31);
		personPanel.add(btnDeleteClient);

		btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setBounds(459, 69, 123, 31);
		personPanel.add(btnDeleteAccount);

		btnDepositMoney = new JButton("Add money");
		btnDepositMoney.setBounds(34, 216, 140, 101);
		personPanel.add(btnDepositMoney);

		btnWithdrawMoney = new JButton("Withdraw money");
		btnWithdrawMoney.setBounds(213, 216, 140, 101);
		personPanel.add(btnWithdrawMoney);

		JTabbedPane viewClients = new JTabbedPane(JTabbedPane.TOP);
		viewAllClientsPanel = new JPanel();
		tabbedPane.addTab("View Clients", null, viewAllClientsPanel, null);
		viewAllClientsPanel.setLayout(null);

		JTabbedPane viewAccounts = new JTabbedPane(JTabbedPane.TOP);
		viewAccountsOfaClientPanel = new JPanel();
		tabbedPane.addTab("View Accounts", null, viewAccountsOfaClientPanel, null);
		viewAccountsOfaClientPanel.setLayout(null);

	}

	public void setInsertClinetActionListener(ActionListener a) {
		btnCreateClient.addActionListener(a);
	}

	public void setInsertAccountActionListener(ActionListener a) {
		btnCreateAccount.addActionListener(a);
	}

	public void setDeleteClientActionListener(ActionListener a) {
		btnDeleteClient.addActionListener(a);
	}

	public void setDeleteAccountActionListener(ActionListener a) {
		btnDeleteAccount.addActionListener(a);
	}

	public void setDisplayClientActionListener(ActionListener a) {
		btnDisplayClients.addActionListener(a);
	}

	public void setAccountDisplayActionListener(ActionListener a) {
		btnDisplayAccounts.addActionListener(a);
	}

	public void setDepositMoneyActionListener(ActionListener a) {
		btnDepositMoney.addActionListener(a);
	}

	public void setWithdrawMonetActionListener(ActionListener a) {
		btnWithdrawMoney.addActionListener(a);
	}

	public JLabel getCustomerName() {
		return customerName;
	}

	public void setCustomerName(JLabel customerName) {
		this.customerName = customerName;
	}

	public JLabel getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(JLabel customerAge) {
		this.customerAge = customerAge;
	}

	public JLabel getCustomersAccountId() {
		return customersAccountId;
	}

	public void setCustomersAccountId(JLabel customersAccountId) {
		this.customersAccountId = customersAccountId;
	}

	public JLabel getSum() {
		return sum;
	}

	public void setSum(JLabel sum) {
		this.sum = sum;
	}

	public JTextField getCustomerNametf() {
		return customerNametf;
	}

	public void setCustomerNametf(JTextField customerNametf) {
		this.customerNametf = customerNametf;
	}

	public JTextField getCustomerAgetf() {
		return customerAgetf;
	}

	public void setCustomerAgetf(JTextField customerAgetf) {
		this.customerAgetf = customerAgetf;
	}

	public JTextField getCustomersAccIdtf() {
		return customersAccIdtf;
	}

	public void setCustomersAccIdtf(JTextField customersAccIdtf) {
		this.customersAccIdtf = customersAccIdtf;
	}

	public JTextField getSumtf() {
		return sumtf;
	}

	public void setSumtf(JTextField sumtf) {
		this.sumtf = sumtf;
	}

	public JLabel getAccType() {
		return accType;
	}

	public void setAccType(JLabel accType) {
		this.accType = accType;
	}

	public JTextField getAccTypetf() {
		return accTypetf;
	}

	public void setAccTypetf(JTextField accTypetf) {
		this.accTypetf = accTypetf;
	}

	public JButton getBtnCreateClient() {
		return btnCreateClient;
	}

	public void setBtnCreateClient(JButton btnCreateClient) {
		this.btnCreateClient = btnCreateClient;
	}

	public JButton getBtnCreateAccount() {
		return btnCreateAccount;
	}

	public void setBtnCreateAccount(JButton btnCreateAccount) {
		this.btnCreateAccount = btnCreateAccount;
	}

	public JButton getBtnDisplayClients() {
		return btnDisplayClients;
	}

	public void setBtnDisplayClients(JButton btnDisplayClients) {
		this.btnDisplayClients = btnDisplayClients;
	}

	public JButton getBtnDisplayAccounts() {
		return btnDisplayAccounts;
	}

	public void setBtnDisplayAccounts(JButton btnDisplayAccounts) {
		this.btnDisplayAccounts = btnDisplayAccounts;
	}

	public JButton getBtnDeleteClient() {
		return btnDeleteClient;
	}

	public void setBtnDeleteClient(JButton btnDeleteClient) {
		this.btnDeleteClient = btnDeleteClient;
	}

	public JButton getBtnDeleteAccount() {
		return btnDeleteAccount;
	}

	public void setBtnDeleteAccount(JButton btnDeleteAccount) {
		this.btnDeleteAccount = btnDeleteAccount;
	}

	public JButton getBtnDepositMoney() {
		return btnDepositMoney;
	}

	public void setBtnDepositMoney(JButton btnDepositMoney) {
		this.btnDepositMoney = btnDepositMoney;
	}

	public JButton getBtnWithdrawMoney() {
		return btnWithdrawMoney;
	}

	public void setBtnWithdrawMoney(JButton btnWithdrawMoney) {
		this.btnWithdrawMoney = btnWithdrawMoney;
	}

	public JPanel getViewAllClientsPanel() {
		return viewAllClientsPanel;
	}

	public void setViewAllClientsPanel(JPanel viewAllClientsPanel) {
		this.viewAllClientsPanel = viewAllClientsPanel;
	}

	public JPanel getViewAccountsOfaClientPanel() {
		return viewAccountsOfaClientPanel;
	}

	public void setViewAccountsOfaClientPanel(JPanel viewAccountsOfaClientPanel) {
		this.viewAccountsOfaClientPanel = viewAccountsOfaClientPanel;
	}

	public void setproductTable(String[] columnNames, Object[][] rowData) {
		if (clientsTable != null) {
			clientsTable.setVisible(false);
			clientsTable.removeAll();
		}
		TableModel tm = new DefaultTableModel(rowData, columnNames);
		clientsTable = new JTable(tm);
		clientsTable.setBounds(10, 11, 554, 319);
		viewAllClientsPanel.add(clientsTable);
		resizeColumnWidth(clientsTable);
	}
	
	public void setAccountsTable(String[] columnNames, Object[][] rowData) {

		if (accountsTable != null) {
			accountsTable.setVisible(false);
			accountsTable.removeAll();
		}
		TableModel tm = new DefaultTableModel(rowData, columnNames);
		accountsTable = new JTable(tm);
		accountsTable.setBounds(10, 11, 554, 319);
		viewAccountsOfaClientPanel.add(accountsTable);
		resizeColumnWidth(accountsTable);
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
