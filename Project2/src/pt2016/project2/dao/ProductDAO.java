package pt2016.project2.dao;

import java.util.List;

import pt2016.project2.entity.Product;

/**
 * DAO-Interface for the different ProductDAO-implementations. Defines the
 * CRUD-operations.
 */
public interface ProductDAO {
	
	 
    /** Creates a list of products and returns the list. */
    public List<Product> readAll();
    
    /** Creates a product and returns true or false. */
    public boolean createProduct(Product product);
 
    /** Receives a product by given id. */
    public Product readProduct(int id);
 
    /** Updates an existing product. */
    public boolean updateProduct(Product product);
 
    /** Deletes a product by product. */
    public boolean deleteProduct(Product product);
    

}