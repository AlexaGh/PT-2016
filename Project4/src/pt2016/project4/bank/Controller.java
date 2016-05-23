package pt2016.project4.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class Controller {

	private View frame;

	private Bank bank;

	private String[] clientsTableColumnNames = { "ID", "Name", "Age" };
	private String[] accountsTableColumnNames = { "ID", "Name" };

	public Controller(View frame) {

		this.frame = frame;
		bank = new Bank();

		frame.setInsertClinetActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = frame.getCustomerNametf().getText();
				int age = Integer.parseInt(frame.getCustomerAgetf().getText());
				int accId = Integer.parseInt(frame.getCustomersAccIdtf().getText());
				double sum = Double.parseDouble(frame.getSumtf().getText());
				String accType = frame.getAccTypetf().getText();

				if (!name.equals("") && age > 0 && accId >= 0
						&& (accType.equals("spending") || accType.equals("saving"))) {

					Person p = new Person(name, age);
					Account acc;
					if (accType.equals("spending")) {

						acc = new SpendingAccounts(accId, sum);
						bank.addAccforPerson(p, acc);

					}
					if (accType.equals("saving")) {

						acc = new SavingAccount(accId, sum);
						bank.addAccforPerson(p, acc);
					}

					// bank.addAccforPerson(p, acc);
					getClientsTable();

				} else {
					System.out.println("All fields are mandatory!");
				}

			}
		});

		frame.setInsertAccountActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name = frame.getCustomerNametf().getText();
				int age = Integer.parseInt(frame.getCustomerAgetf().getText());
				int accId = Integer.parseInt(frame.getCustomersAccIdtf().getText());
				double sum = Double.parseDouble(frame.getSumtf().getText());
				String accType = frame.getAccTypetf().getText();

				if (!name.equals("") && age > 0 && accId >= 0
						&& (accType.equals("spending") || accType.equals("saving"))) {

					Person p = new Person(name, age);
					Account acc;
					if (accType.equals("spending")) {
						
						acc = new SpendingAccounts(accId, sum);
						bank.addAccforPerson(p, acc);

					}
					if (accType.equals("saving")) {

						acc = new SavingAccount(accId, sum);
						bank.addAccforPerson(p, acc);
					}
						getAccountsTable(p);

				} else {
					System.out.println("All fields are mandatory!");
				}

			}
		});

		frame.setDeleteClientActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name = frame.getCustomerNametf().getText();
				int age = Integer.parseInt(frame.getCustomerAgetf().getText());
				// int accId =
				// Integer.parseInt(frame.getCustomersAccIdtf().getText());

				if (!name.equals("") && age > 0) {

					Person p = new Person(name, age);
					bank.deletePerson(p);
					//getAccountsTable(p);

				} else {
					System.out.println("All fields are mandatory!");
				}

			}
		});

		frame.setDeleteAccountActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = frame.getCustomerNametf().getText();
				int age = Integer.parseInt(frame.getCustomerAgetf().getText());
				int accId = Integer.parseInt(frame.getCustomersAccIdtf().getText());
				double sum = Double.parseDouble(frame.getSumtf().getText());
				String accType = frame.getAccTypetf().getText();

				if (!name.equals("") && age > 0 && accId >= 0) {

					Person p = new Person(name, age);
					bank.deleteAccount(accId, p);
					getAccountsTable(p);

				} else {
					System.out.println("All fields are mandatory!");
				}

			}
		});

		frame.setDisplayClientActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getClientsTable();
			}
		});

		frame.setAccountDisplayActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = frame.getCustomerNametf().getText();
				int age = Integer.parseInt(frame.getCustomerAgetf().getText());

				Person p = new Person(name, age);
				getAccountsTable(p);

			}
		});

		frame.setDepositMoneyActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name = frame.getCustomerNametf().getText();
				int age = Integer.parseInt(frame.getCustomerAgetf().getText());
				int accId = Integer.parseInt(frame.getCustomersAccIdtf().getText());
				double sum = Double.parseDouble(frame.getSumtf().getText());
				String accType = frame.getAccTypetf().getText();

				if (!name.equals("") && age > 0 && accId >= 0
						&& (accType.equals("spending") || accType.equals("saving"))) {

					Person p = new Person(name, age);
					bank.depositMoney(sum, accId, p);
					getAccountsTable(p);

				}

			}
		});

		frame.setWithdrawMonetActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name = frame.getCustomerNametf().getText();
				int age = Integer.parseInt(frame.getCustomerAgetf().getText());
				int accId = Integer.parseInt(frame.getCustomersAccIdtf().getText());
				double sum = Double.parseDouble(frame.getSumtf().getText());
				String accType = frame.getAccTypetf().getText();

				if (!name.equals("") && age > 0 && accId >= 0
						&& (accType.equals("spending") || accType.equals("saving"))) {

					Person p = new Person(name, age);
					bank.withdrawMoney(sum, accId, p);
					getAccountsTable(p);

				}

			}
		});
	}

	private void getClientsTable() {

		List<Person> plist = bank.displayAll();

		int plistSize = plist.size();
		String[] productsTableColumnNames = new Main().getFieldNames(ClientFields.class);
		Object[][] pmatrix = new Object[plistSize][productsTableColumnNames.length];

		int i = 0;
		for (Person p : plist) {
			pmatrix[i][0] = p.getName();
			pmatrix[i][1] = p.getAge();
			i++;
		}

		// for (i = 0; i < plistSize; i++) {
		// pmatrix[i][0] = plist.get(i).getName();
		// pmatrix[i][1] = (Integer) plist.get(i).getAge();
		// }

		frame.setproductTable(productsTableColumnNames, pmatrix);

	}

	private void getAccountsTable(Person p) {

		Set<Account> accounts = bank.displayAllACcounts(p);

		int plistSize = accounts.size();

		String[] productsTableColumnNames = new Main().getFieldNames(AccountFields.class);
		Object[][] pmatrix = new Object[plistSize][productsTableColumnNames.length];

		int i = 0;
		for (Account a : accounts) {
			pmatrix[i][0] = a.getAccountId();
			pmatrix[i][1] = a.getMoney();
			pmatrix[i][2] = a.getType();
			i++;
		}
		frame.setAccountsTable(productsTableColumnNames, pmatrix);

	}

}
