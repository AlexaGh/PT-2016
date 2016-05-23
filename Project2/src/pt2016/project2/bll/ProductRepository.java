package pt2016.project2.bll;

import java.util.List;

import pt2016.project2.dao.ProductDAO;
import pt2016.project2.entity.Product;
import pt2016.project2.model.ProductModel;

public class ProductRepository {

	public List<Product> displayProducts() {
		ProductModel pm = new ProductModel();
		return pm.readAll();
	}

	public Product readProduct(int id) {
		ProductDAO pdao = new ProductModel();
		return pdao.readProduct(id);
	}

	public boolean createProduct(String name, int quantity, double price) {
		ProductDAO pdao = new ProductModel();
		Product p = new Product(1, name, quantity, price);
		return pdao.createProduct(p);
	}

	public boolean updateProduct(int id, String name, int quantity, double price) {
		ProductDAO pdao = new ProductModel();
		Product p = new Product(id, name, quantity, price);
		return pdao.updateProduct(p);
	}

	public boolean deleteProduct(Product p) {
		ProductDAO pdao = new ProductModel();
		return pdao.deleteProduct(p);
	}

}
