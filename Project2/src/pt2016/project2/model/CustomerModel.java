package pt2016.project2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt2016.project2.dao.ConnectionFactory;
import pt2016.project2.dao.CustomerDAO;
import pt2016.project2.entity.Customer;

public class CustomerModel implements CustomerDAO {

	@Override
	public List<Customer> readAll() {

		try {
			List<Customer> listCustomer = new ArrayList<>();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from `customer`");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				
				c.setCustomerId(rs.getInt("idcustomer"));
				c.setCustomerName(rs.getString("name"));

				listCustomer.add(c);
			}
			return listCustomer;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean createCutomer(Customer c) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("insert into `customer` (`name`) values(?)");		
			ps.setString(1, c.getCustomerName());
			boolean result = ps.executeUpdate() > 0;
			ps.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer readCustomer(int id) {
		try {
			Customer c = new Customer();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from `customer` where `idcustomer`=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c.setCustomerId(rs.getInt("idcustomer"));
				c.setCustomerName(rs.getString("name"));
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean updateCustomer(Customer c) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("update `customer` set `name`=?  where `idcustomer`=?");
			ps.setString(1, c.getCustomerName());
			ps.setInt(2, c.getCustomerId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("delete from `customer` where `idcustomer`=?");
			ps.setInt(1, c.getCustomerId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
