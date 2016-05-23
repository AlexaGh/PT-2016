package pt2016.project3.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import pt2016.project2.bll.CustomerFields;
import pt2016.project2.bll.OrderFields;
import pt2016.project2.bll.OrderProcessing;
import pt2016.project2.bll.ProductFields;
import pt2016.project2.bll.ProductRepository;
import pt2016.project2.dao.CustomerDAO;
import pt2016.project2.dao.OrderDAO;
import pt2016.project2.dao.OrderDetailsDAO;
import pt2016.project2.dao.ProductDAO;
import pt2016.project2.entity.Customer;
import pt2016.project2.entity.Order;
import pt2016.project2.entity.OrderDetails;
import pt2016.project2.entity.Product;
import pt2016.project2.model.CustomerModel;
import pt2016.project2.model.OrderDetailsModel;
import pt2016.project2.model.OrderModel;
import pt2016.project2.model.ProductModel;

public class Controller {

	private ViewFrame frame;
	private OrderProcessing op;
	private ProductRepository pr;

	private String[] customersTableColumnNames = { "ID", "Name", };
	private String[] productsTableColumnNames = { "ID", "Name", "Quantity", "Price" };
	private String[] ordersTableColumnNames = { "ID", "Customer" };

	public Controller(ViewFrame frame) {

		this.frame = frame;
		pr = new ProductRepository();
		op = new OrderProcessing();

		frame.setProductCreateActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String name = frame.getProductName().getText();
				double price = Double.parseDouble(frame.getProductPrice().getText());
				int quantity = Integer.parseInt(frame.getProductQuantity().getText());
				if (!name.equals("") && price > 0d && quantity >= 0) {
					if (pr.createProduct(name, quantity, price)) {
						System.out.println("Product added successfully!");
						getProductsTable();
					} else {
						System.out.println("Failed adding product.");
					}
				} else {
					System.out.println("All fields are mandatory!");
				}

			}
		});

		frame.setProductUpdateActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(frame.getProductID().getText());
				String name = frame.getProductName().getText();
				double price = Double.parseDouble(frame.getProductPrice().getText());
				int quantity = Integer.parseInt(frame.getProductQuantity().getText());
				Product p = pr.readProduct(id);
				if (p.getProductId() != 0) {
					if (!name.equals("")) {
						p.setProductName(name);
					}
					if (price > 0d) {
						p.setProductPrice(price);
					}
					if (quantity >= 0) {
						p.setProductQuantity(quantity);
					}
					if (pr.updateProduct(id, p.getProductName(), p.getProductQuantity(), p.getProductPrice())) {
						getProductsTable();
					} else {
						System.out.println("Could not update table");
					}
				} else {
					System.out.println("Could not find table");
				}
			}

		});

		frame.setProductDeleteActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(frame.getProductID().getText());
				Product p = pr.readProduct(id);
				if (p.getProductId() != 0) {
					if (pr.deleteProduct(p)) {
						System.out.println("Product has been deleted");
						getProductsTable();
					} else {
						System.out.println("Could not delete product");
					}
				} else {
					System.out.println("Could not find product");
				}

			}
		});

		frame.setCustomerInsertActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = frame.getCustomerName().getText();

				if (!name.equals("")) {
					if (op.createCustomer(name))
						System.out.println("Customer has been added");
					getCustomersTable();
				} else {
					System.out.println("Customer hasnt been added");
				}
			}
		});

		frame.setCustomerUpdateEditActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(frame.getCustomerID().getText());
				String name = frame.getCustomerName().getText();

				Customer c = op.readCustomer(id);
				if (c.getCustomerId() != 0) {
					if (!name.equals("")) {
						c.setCustomerName(name);
					}

					if (op.updateCustomer(id, name)) {
						System.out.println("Customer updated successfully!");
						getCustomersTable();
					} else {
						System.out.println("Failed updating customer.");
					}
				} else {
					System.out.println("Customer not found.");
				}
			}

		});

		frame.setCustomerDeleteActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(frame.getCustomerID().getText());

				Customer c = op.readCustomer(id);
				if (c.getCustomerId() != 0) {
					if (op.deleteCustomer(c)) {
						System.out.println("Customer deleted successfully!");
						getCustomersTable();
					} else {
						System.out.println("Failed deleting customer.");
					}
				} else {
					System.out.println("Customer not found.");
				}

			}
		});

		frame.setoOrderActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CustomerDAO cm = new CustomerModel();
				ProductDAO pm = new ProductModel();
				OrderDAO om = new OrderModel();

				int pId = Integer.parseInt(frame.getOrderProductID().getText());
				int cId = Integer.parseInt(frame.getOrderCustomerID().getText());
				int quantities = Integer.parseInt(frame.getOrderQuantity().getText());

				Customer customer = cm.readCustomer(cId);
				Product product = pm.readProduct(pId);

				OrderDetails orderDetails = new OrderDetails(-1, product, quantities);
				ArrayList<OrderDetails> odList = new ArrayList<>();
				odList.add(orderDetails);
				Order order = new Order(-1, customer, odList);

				if (cId == 0) {
					System.out.println("Customer not found.");
					return;
				}

				if (op.order(cId, odList)) {
					System.out.println("Order placed successfuly!");
					getOrdersTable();
				} else {
					System.out.println("Error placing order.");
				}

			}
		});

	}

	private String understock(String[] sPids, String[] sQuantities) {
		int i;
		String understockProducts = "";
		for (i = 0; i < sPids.length; i++) {
			if (op.understock(Integer.parseInt(sPids[i]), Integer.parseInt(sQuantities[i]))) {
				understockProducts = understockProducts.concat(" " + sPids[i]);
			}
		}
		return understockProducts;
	}

	private void getCustomersTable() {

		List<Customer> clist = op.displayCustomers();
		int clistSize = clist.size();
		String[] customersTableColumnNames = new Main().getFieldNames(CustomerFields.class);
		Object[][] cmatrix = new Object[clistSize][customersTableColumnNames.length];

		int i;
		for (i = 0; i < clistSize; i++) {
			cmatrix[i][0] = (Integer) clist.get(i).getCustomerId();
			cmatrix[i][1] = clist.get(i).getCustomerName();
		}
		frame.setcustomerTable(customersTableColumnNames, cmatrix);
	}

	private void getProductsTable() {

		List<Product> plist = pr.displayProducts();
		int plistSize = plist.size();
		String[] productsTableColumnNames = new Main().getFieldNames(ProductFields.class);
		Object[][] pmatrix = new Object[plistSize][productsTableColumnNames.length];

		int i;
		for (i = 0; i < plistSize; i++) {
			pmatrix[i][0] = (Integer) plist.get(i).getProductId();
			pmatrix[i][1] = plist.get(i).getProductName();
			pmatrix[i][2] = (Double) plist.get(i).getProductPrice();
			pmatrix[i][3] = (Integer) plist.get(i).getProductQuantity();
		}
		frame.setproductTable(productsTableColumnNames, pmatrix);
	}

	private void getOrdersTable() {

		List<Order> oList = op.displayOrders();
		int olistSize = oList.size();
		String[] ordersTableColumnNames = new Main().getFieldNames(OrderFields.class);
		Object[][] omatrix = new Object[olistSize][ordersTableColumnNames.length];
		// "ID", "Customer
		int i;
		for (i = 0; i < olistSize; i++) {
			omatrix[i][0] = (Integer) oList.get(i).getOrderId();
			omatrix[i][1] = oList.get(i).getCustomer();

		}
		frame.setorderTable(ordersTableColumnNames, omatrix);
	}

}
