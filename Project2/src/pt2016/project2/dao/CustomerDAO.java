package pt2016.project2.dao;

import java.util.List;

import pt2016.project2.entity.Customer;

/**
 * DAO-Interface for the different PersonDAO-implementations. Defines the
 * CRUD-operations.
 */
public interface CustomerDAO {
	
    /** Creates a list of customers and returns the list. */
    public List<Customer> readAll();
    
    /** Creates a product and returns true or false. */
    public boolean createCutomer(Customer person);
 
    /** Receives a person by given id. */
    public Customer readCustomer(int id);
 
    /** Updates an existing person. */
    public boolean updateCustomer(Customer person);
 
    /** Deletes a person by customer. */
    public boolean deleteCustomer(Customer c);
}