package pt2016.project2.bll;

import java.util.ArrayList;
import java.util.List;

import pt2016.project2.dao.CustomerDAO;
import pt2016.project2.dao.OrderDAO;
import pt2016.project2.dao.OrderDetailsDAO;
import pt2016.project2.entity.Customer;
import pt2016.project2.entity.Order;
import pt2016.project2.entity.OrderDetails;
import pt2016.project2.entity.Product;
import pt2016.project2.model.CustomerModel;
import pt2016.project2.model.OrderDetailsModel;
import pt2016.project2.model.OrderModel;
import pt2016.project2.model.ProductModel;

public class OrderProcessing {

	public Customer readCustomer(int id) {
		CustomerDAO cdao = new CustomerModel();
		return cdao.readCustomer(id);
	}

	public boolean createCustomer(String name) {
		CustomerDAO cdao = new CustomerModel();
		Customer c = new Customer(1, name);
		return cdao.createCutomer(c);
	}

	public boolean updateCustomer(int id, String name) {

		CustomerDAO cdao = new CustomerModel();
		Customer c = cdao.readCustomer(id);
		c.setCustomerName(name);
		return cdao.updateCustomer(c);
	}

	public boolean deleteCustomer(Customer c) {
		CustomerDAO cdao = new CustomerModel();
		return cdao.deleteCustomer(c);
	}

	public List<Customer> displayCustomers() {

		CustomerModel cm = new CustomerModel();
		return cm.readAll();
	}

	public List<Order> displayOrders() {

		OrderModel om = new OrderModel();
		return om.readAll();
	}

	public boolean order(int cId, List<OrderDetails> oDetails) {

		CustomerModel cm = new CustomerModel();
		OrderModel om = new OrderModel();
		OrderDetailsModel odm = new OrderDetailsModel();

		Customer customer = cm.readCustomer(cId);

		if (customer.getCustomerId() == 0) {
			return false;
		}

		Order newOrder = new Order(-1, customer, oDetails);
		newOrder.setCustomer(customer);

		int orderId = om.createOrder(newOrder);
		/*if (orderId == -1) {
			return false;
		}
		 */
		
		Order sameOrder = new Order(orderId, newOrder.getCustomer(), oDetails);

		for (OrderDetails o : oDetails) {
			o.setOrderId(orderId);
			if (odm.createOrderD(o)) {
				return true;
			}
		}
		updateQuantities(sameOrder);

		return true;
	}

	private boolean updateQuantities(Order o) {

		ProductRepository pr = new ProductRepository();

		for (OrderDetails oDetails : o.getOrderDetails()) {
			Product p = oDetails.getProduct();
			if (!pr.updateProduct(p.getProductId(), p.getProductName(), p.getProductQuantity() - oDetails.getQuantity(),
					p.getProductPrice())) {
				return false;
			}
		}
		return true;
	}

	public boolean understock(int pId, int quantity) {

		ProductModel pm = new ProductModel();

		Product p = pm.readProduct(pId);
		if (p.getProductQuantity() < quantity) {
			return true;
		}
		return false;
	}
}
