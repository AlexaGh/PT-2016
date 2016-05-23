package pt2016.project2.bll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import pt2016.project2.entity.Customer;
import pt2016.project2.entity.Order;
import pt2016.project2.entity.OrderDetails;
import pt2016.project2.entity.Product;
import pt2016.project2.model.CustomerModel;
import pt2016.project2.model.OrderDetailsModel;
import pt2016.project2.model.OrderModel;
import pt2016.project2.model.ProductModel;
import pt2016.project3.presentation.Main;

public class Manager {

	public static void main(String[] args) {

		/*
		 * System.out.println(
		 * "-------------------------TESTING CREATE [CUSTOMER]------------------------ Start"
		 * );
		 * 
		 * CustomerDAO customerDAO = new CustomerModel(); Customer c1 = new
		 * Customer(); Customer c2 = new Customer();
		 * 
		 * c2.setCustomerId(79); c1.setCustomerId(76);
		 * 
		 * System.out.println(
		 * "-------------------------TESTING UPDATE [CUSTOMER]----------------------- Start"
		 * );
		 */
		/*
		 * c1.setCustomerId(79); c1.setCustomerName("Caba Beniamin");
		 * 
		 * customerDAO.updateCustomer(c1);
		 * 
		 * System.out.println(
		 * "-------------------------TESTING DELETE [CUSTOMER]------------------------ Start"
		 * );
		 * 
		 * c2.setCustomerId(78); customerDAO.deleteCustomer(c2);
		 * 
		 * System.out .println(
		 * "-------------------------TESTING READ ONE [CUSTOMER]-------------------------------- Start"
		 * );
		 * 
		 * Customer c = customerDAO.readCustomer(73); System.out.println("id: "
		 * + c.getCustomerId() + " name: " + c.getCustomerName());
		 * 
		 * System.out.println(); System.out .println(
		 * "-------------------------TESTING READ ALL [CUSTOMERS]-------------------------------- Start"
		 * );
		 * 
		 * for (Customer customer : customerDAO.readAll()) { System.out.println(
		 * "customer: [Customer Id : " + customer.getCustomerId() + ", Name : "
		 * + customer.getCustomerName() + "]"); }
		 * 
		 * // ----------------product testing
		 * ------------------------------------
		 * 
		 * System.out.println(
		 * "-------------------------TESTING CREATE [PRODUCT]-------------------------------- Start"
		 * );
		 */
		/*
		 * ProductDAO productDAO = new ProductModel();
		 * 
		 * Product p1 = new Product(); Product p2 = new Product();
		 * 
		 * p1.setProductName("red dress"); p1.setProductPrice(20);
		 * p1.setProductQuantity(50);
		 */
		/*
		 * p2.setProductName("blue jeans"); p2.setProductPrice(15);
		 * p2.setProductQuantity(100);
		 * 
		 * productDAO.createProduct(p1); productDAO.createProduct(p2);
		 * 
		 * System.out.println(
		 * "-------------------------TESTING UPDATE [PRODUCT]-------------------------------- Start"
		 * );
		 * 
		 * p1.setProductId(1); p1.setProductName("red jeans");
		 * p1.setProductPrice(55); p1.setProductQuantity(3);
		 * productDAO.updateProduct(p1);
		 * 
		 * System.out.println(
		 * "-------------------------TESTING DELETE [PRODUCT]-------------------------------- Start"
		 * );
		 * 
		 * p2.setProductId(64); productDAO.deleteProduct(p2);
		 * 
		 * 
		 * System.out.println(
		 * "-------------------------TESTING READ ONE [PRODUCT]-------------------------------- Start"
		 * );
		 * 
		 * Product p = productDAO.readProduct(63);
		 * 
		 * System.out.println("customer: [Customer Id : " + p.getProductId() +
		 * ", Name : " + p.getProductName() + ", price: " + p.getProductPrice()
		 * + ", quantity: " + p.getProductQuantity() + "]"); System.out
		 * .println(
		 * "-------------------------TESTING READ ALL [PRODUCTS]-------------------------------- Start"
		 * ); for (Product product : productDAO.readAll()) { System.out.println(
		 * "product: [Product Id : " + product.getProductId() + ", Name : " +
		 * product.getProductName() + ", price: " + product.getProductPrice() +
		 * ", quantity: " + product.getProductQuantity() + "]"); }
		 */
		// ------------------------- order testing
		// ---------------------------------
		/*
		 * System.out.println(
		 * "-------------------------TESTING CREATE [ORDER]---------------------- Start"
		 * );
		 * 
		 * OrderDAO orderDAO = new OrderModel();
		 * 
		 * List<Customer> customers = customerDAO.readAll();
		 * 
		 * // System.out.println("id: " + customers.get(0).getCustomerId());
		 * 
		 * Order newO = new Order(); Order newOrder1 = new Order(1); Order
		 * newOrder2 = new Order(2); Order newOrder3 = new Order(4);
		 * 
		 * newO.setCustomer(c1); // int orderId = orderDAO.createOrder(newO);
		 * 
		 * // newO.setOrderId(orderId); // newO.setCustomer(c1);
		 * 
		 * // System.out.println("id of the order who ordered: " + orderId);
		 * System.out.println("id: " + newO.getOrderId());
		 * 
		 * System.out.println("id of the customer who ordered: " +
		 * newO.getCustomer().getCustomerId());
		 * 
		 * // WHY IS IT NULL? System.out.println(
		 * "name of the customer who ordered: " +
		 * newO.getCustomer().getCustomerName());
		 * 
		 * OrderDetailsDAO odetailsDAO = new OrderDetailsModel();
		 * 
		 * Customer c = customerDAO.readCustomer(c1.getCustomerId());
		 * System.out.println("id: " + c.getCustomerId() + " name: " +
		 * c.getCustomerName());
		 */
		// OrderDetailsDAO odetailsDAO = new OrderDetailsModel();
		//

		//
		// List<OrderDetails> odList = new ArrayList<>();
		//
		// odList.get(0).setOrderId(orderId);
		// odList.get(0).setProduct(p1);
		// odList.get(0).setQuantity(2);
		//
		// Order sameOrder = new Order(orderId, newO.getCustomer(), odList);
		//
		// for (OrderDetails o : odList) {
		// o.setOrderId(orderId);
		// if (odetailsDAO.createOrderD(o)) {
		// System.out.println("so? "); }
		// }

		// updateQuantities(sameOrder);
		
		// TEST
		CustomerModel cm = new CustomerModel();
		ProductModel pm = new ProductModel();
		OrderModel om = new OrderModel();
		OrderDetailsModel odm = new OrderDetailsModel();

		// Display
		System.out.println("Before wipe");
		System.out.println("Customers");
		for (Customer cu : cm.readAll())
			System.out.println(cu);
		System.out.println("Products");
		for (Product p : pm.readAll())
			System.out.println(p);
		System.out.println("Orders");
		for (Order o : om.readAll())
			System.out.println(o);
		System.out.println("OrderDetails");
		for (OrderDetails od : odm.readAll())
			System.out.println(od);

		// wipe the db
		
		for (OrderDetails od : odm.readAll())
			odm.deleteOrderD(od);
		for (Order o : om.readAll())
			om.deleteOrder(o);
		for (Customer cu : cm.readAll())
			cm.deleteCustomer(cu);
		for (Product p : pm.readAll())
			pm.deleteProduct(p);
		
		System.out.println("Fields: ");
		List<Field> f = new Main().getFields(Customer.class);
		for (Field field : f) {
			System.out.println(field.getName());
		}
		String[] names = new Main().getFieldNames(Order.class);
		
		System.out.println("-------------Field names:: ");
		for(int i = 0; i<names.length; i++){
			System.out.println(names[i]);
		}
		// Display
		System.out.println("After wipe");
		System.out.println("Customers");
		for (Customer cu : cm.readAll())
			System.out.println(cu);
		System.out.println("Products");
		for (Product p : pm.readAll())
			System.out.println(p);
		System.out.println("Orders");
		for (Order o : om.readAll())
			System.out.println(o);
		System.out.println("OrderDetails");
		for (OrderDetails od : odm.readAll())
			System.out.println(od);

		// add stuff
		// add a customer
		cm.createCutomer(new Customer(-1, "Ivanovici Anastasia"));
		// add a product
		pm.createProduct(new Product(-1, "Jeans", 50, 50));
		// add an order
		Customer customer;
		Product product;
		OrderDetails orderDetails;

		customer = cm.readAll().get(0);
		product = pm.readAll().get(0);
		orderDetails = new OrderDetails(-1, product, 25);
		ArrayList<OrderDetails> odList = new ArrayList<>();
		odList.add(orderDetails);

		// perform actual insertion
		om.createOrder(new Order(-1, customer, odList));

		// Display
		System.out.println("After insertion");
		System.out.println("Customers");
		for (Customer cu : cm.readAll())
			System.out.println(cu);
		System.out.println("Products");
		for (Product p : pm.readAll())
			System.out.println(p);
		System.out.println("Orders");
		for (Order o : om.readAll())
			System.out.println(o);
		System.out.println("OrderDetails");
		for (OrderDetails od : odm.readAll())
			System.out.println(od);

		
			String text = odm.readAll().toString();
			String text2 = cm.readAll().toString();
			
	        BufferedWriter output = null;
	        try {
	            File file = new File("bill.txt");
	            output = new BufferedWriter(new FileWriter(file));
	            output.write("Client: " + text2 + "\n\n\n");
	            output.append("\n");
	            output.append("Order Details: " + text);
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	            if ( output != null )
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	        }
		/*
		 * OrderModel om = new OrderModel(); List<OrderDetails> odList = new
		 * ArrayList<>();
		 * 
		 * Order o = new Order(5, c1, odList) ; int orderId = om.createOrder(o);
		 * 
		 * OrderDetails od = new OrderDetails(orderId, p1, 5); List<Order>
		 * orders = om.readAll();
		 * 
		 * for (Order order : orders) { System.out.println(order.getOrderId());
		 * }
		 * 
		 * odetailsDAO.createOrderD(od);
		 */

		// for (Order order : orders) {
		// om.deleteOrder(order);
		// }
		// System.out.println("After");
		// orders = om.readAll();
		// for (Order order : orders) {
		// System.out.println(order.getOrderId());
		// }

		//
		// odList.get(0).setOrderId(orderId);
		// odList.get(0).setProduct(p1);
		// odList.get(0).setQuantity(2);
		//
	}
}
