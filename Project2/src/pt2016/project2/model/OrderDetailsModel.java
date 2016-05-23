package pt2016.project2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt2016.project2.dao.ConnectionFactory;
import pt2016.project2.dao.OrderDetailsDAO;
import pt2016.project2.entity.OrderDetails;
import pt2016.project2.entity.Product;

public class OrderDetailsModel implements OrderDetailsDAO {

	@Override
	public boolean createOrderD(OrderDetails orderD) {
		try {

			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(
					"insert into `orderdetails` (`order_id`, `product_id`, `quantity`) values (?,?,?)");

			ps.setInt(1, orderD.getOrderId());
			ps.setInt(2, orderD.getProduct().getProductId());
			ps.setInt(3, orderD.getQuantity());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public OrderDetails readOrderD(int orderId, int productId) {

		OrderDetails o = null;
		try {

			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(
					"select `order_id`, `product_id`, `product`.`name`, `quantity`, `product`.`price` from `orderdetails` JOIN product on `product`.`idproduct` = `orderdetails`.`product_id`  where `order_id`=? AND `idproduct`=?");

			ps.setInt(1, orderId);
			ps.setInt(2, productId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				o = new OrderDetails(rs.getInt(1), p, rs.getInt(4));
			}
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderDetails> readAll() {
		try {
			List<OrderDetails> ordersD = new ArrayList<>();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(
					"select `order_id` AS oid, `product_id` AS pid, `product`.`name` AS name, `orderdetails`.`quantity` AS qty, `product`.`price` AS price from `orderdetails` JOIN product on `product`.`idproduct` = `orderdetails`.`product_id`");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt("pid"), rs.getString("name"), rs.getInt("qty"), rs.getInt("price"));
				ordersD.add(new OrderDetails(rs.getInt("oid"), p, rs.getInt("qty")));
			}
			return ordersD;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderDetails> readAll(int orderId) {
		try {
			List<OrderDetails> ordersD = new ArrayList<>();
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(
					"select `order_id` AS oid, `product_id` AS pid, `product`.`name` AS name, `orderdetails`.`quantity` AS qty, `product`.`price` AS price from `orderdetails` JOIN product on `product`.`idproduct` = `orderdetails`.`product_id`  where `order_id`=?");

			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt("pid"), rs.getString("name"), rs.getInt("qty"), rs.getInt("price"));
				ordersD.add(new OrderDetails(rs.getInt("oid"), p, rs.getInt("qty")));
			}
			return ordersD;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateOrderD(OrderDetails orderD) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(
					"update `orderdetails` set `order_id`=?, `product_id`=?, `quantity` where `order_id`=? AND `product_id`=?");

			System.out.println("updating orderDetails");
			System.out.println("1 execute update: \n" + ps.executeUpdate());

			ps.setInt(1, orderD.getOrderId());
			ps.setInt(2, orderD.getProduct().getProductId());
			ps.setInt(3, orderD.getQuantity());

			System.out.println("2execute update: \n" + ps.executeUpdate());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteOrderD(OrderDetails orderD) {
		try {
			PreparedStatement ps = ConnectionFactory.getConnection()
					.prepareStatement("delete from `orderdetails` where `order_id`=? AND `product_id`=?");
			ps.setInt(1, orderD.getOrderId());
			ps.setInt(2, orderD.getProduct().getProductId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
