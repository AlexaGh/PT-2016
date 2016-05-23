package pt2016.project2.dao;

import java.util.List;

import pt2016.project2.entity.Order;

/**
 * DAO-Interface for the different OrderDAO-implementations. Defines the
 * CRUD-operations.
 */
public interface OrderDAO {
	
    
    /** Creates an order */
    public int createOrder(Order order);
 
    /** Receives an order by given id. */
    public Order readOrder(int id);
 
    /** Updates an existing order. */
    public boolean updateOrder(Order order);
 
    /** Deletes an order by Order */
    public boolean deleteOrder(Order o);
    
    public List<Order> readAll();
    
}