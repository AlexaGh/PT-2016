package pt2016.project2.dao;

import java.util.List;

import pt2016.project2.entity.OrderDetails;

public interface OrderDetailsDAO {

	/** Creates a list of orders(well..actually the details of it) and returns the list. */
	public List<OrderDetails> readAll(int orderId);

	/** Creates an order and returns true or false. */
	public boolean createOrderD(OrderDetails orderD);

	/** Receives an order by given id. */
	public OrderDetails readOrderD(int orderId, int productId);

	/** Updates an existing order. */
	public boolean updateOrderD(OrderDetails orderD);

	/** Deletes an order by Order */
	public boolean deleteOrderD(OrderDetails orderD);
}
