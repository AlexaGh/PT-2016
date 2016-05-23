package pt2016.project2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt2016.project2.dao.*;
import pt2016.project2.entity.*;

public class ProductModel implements ProductDAO {

	@Override
	public List<Product> readAll() {
		try {
			List<Product> listProducts = new ArrayList<>();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from `product`");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();

				p.setProductId(rs.getInt("idproduct"));
				p.setProductName(rs.getString("name"));
				p.setProductPrice(rs.getDouble("price"));
				p.setProductQuantity(rs.getInt("quantity"));

				listProducts.add(p);
			}
			return listProducts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean createProduct(Product p) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("insert into `product` (`name`, `quantity`, `price`) values(?,?,?)");
			ps.setString(1, p.getProductName());
			ps.setDouble(2, p.getProductPrice());
			ps.setInt(3, p.getProductQuantity());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product readProduct(int id) {
		try {
			Product p = new Product();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from `product` where `idproduct`=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p.setProductId(rs.getInt("idproduct"));
				p.setProductName(rs.getString("name"));
				p.setProductPrice(rs.getDouble("price"));
				p.setProductQuantity(rs.getInt("quantity"));
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateProduct(Product p) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection()
					.prepareStatement("update `product` set `name`=?, `price`=?, `quantity`=? where `idproduct`=?");
			ps.setString(1, p.getProductName());
			ps.setDouble(2, p.getProductPrice());
			ps.setInt(3, p.getProductQuantity());
			ps.setInt(4, p.getProductId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product p) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("delete from `product` where `idproduct`=?");
			ps.setInt(1, p.getProductId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
