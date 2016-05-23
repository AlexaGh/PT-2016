package pt2016.project2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt2016.project2.dao.ConnectionFactory;
import pt2016.project2.dao.OrderDAO;
import pt2016.project2.entity.Customer;
import pt2016.project2.entity.Order;
import pt2016.project2.entity.OrderDetails;

public class OrderModel implements OrderDAO {

	private static final Logger logger = Logger.getLogger("dal.OrderDAO");

	@Override
	public int createOrder(Order o) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			conn = ConnectionFactory.getConnection();
			preparedStatement = conn.prepareStatement("insert into `order` (`customer_id`) values(?)",
					Statement.RETURN_GENERATED_KEYS);
			// preparedStatement.setInt(1, o.getCustomer().getCustomerId());
			preparedStatement.setInt(1, o.getCustomer().getCustomerId());
			preparedStatement.execute();
			
			result = preparedStatement.getGeneratedKeys();
			
			List<Order> list = new OrderModel().readAll();
			Order maxIdOrder = null;
			for (Order ord : list)
				if (maxIdOrder == null || maxIdOrder.getOrderId() < ord.getOrderId()) {
					maxIdOrder = ord;
				}
			int orderid = maxIdOrder.getOrderId();
			
			OrderDetailsModel odm = new OrderDetailsModel();
			List<OrderDetails> toBeInserted = new ArrayList<>();
			
			for (OrderDetails od : o
					.getOrderDetails()) {
				OrderDetails odi = new OrderDetails(orderid, od.getProduct(), od.getQuantity());
				toBeInserted.add(odi);
			}
			for (OrderDetails od : toBeInserted) {
				odm.createOrderD(od);
			}

			if (result.next() && result != null) {
				return result.getInt(1);
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				result.close();
			} catch (Exception rse) {
				logger.log(Level.SEVERE, rse.getMessage());
			}
			try {
				preparedStatement.close();
			} catch (Exception sse) {
				logger.log(Level.SEVERE, sse.getMessage());
			}
			try {
				conn.close();
			} catch (Exception cse) {
				logger.log(Level.SEVERE, cse.getMessage());
			}
		}
		return -1;
	}

	@Override
	public Order readOrder(int id) {
		Order o = null;
		try {

			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(
					"select `customer_id`, `customer`.`name` from `order` JOIN customer on `order`.`customer_id` = `customer`.`idcustomer`  where `idorder`=?");
			ResultSet rs = ps.executeQuery();

			ps.setInt(1, id);
			while (rs.next()) {
				Customer c = new Customer(rs.getInt(1), rs.getString(2));
				List<OrderDetails> orderDetails = null;
				o = new Order(rs.getInt(1), c, orderDetails);
			}
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateOrder(Order o) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection()
					.prepareStatement("update `order` set `customer_id`=? where `idorder`=?");

			ps.setInt(1, o.getCustomer().getCustomerId());
			ps.setInt(2, o.getOrderId());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteOrder(Order o) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection()
					.prepareStatement("delete from `order` where `idorder`=?");
			ps.setInt(1, o.getOrderId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Order> readAll() {
		try {
			List<Order> listOrder = new ArrayList<>();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement("select * from `order`");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int orderid = rs.getInt("idorder");
				int idcustomer = rs.getInt("customer_id");
				Customer c = new CustomerModel().readCustomer(idcustomer);
				List<OrderDetails> list = new OrderDetailsModel().readAll(orderid);

				Order o = new Order(orderid, c, list);
				listOrder.add(o);
			}
			return listOrder;
		} catch (Exception e) {
			return null;
		}
	}

}
