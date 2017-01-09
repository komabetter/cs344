package dao;

import java.io.Serializable;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.classic.Session;
import org.hibernate.criterion.*;

import java.sql.*;

import connect.connect;
import model.*;
import util.HibernateUtil;
import util.HibernateUtils;

public class customersDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Criteria cri = session.createCriteria(customers.class);
	customers customer = new customers();
	Connection con = null;
	PreparedStatement pstm = null;
	Result rs = null;

	public customers loginCustomer(String user, String pass) {
		customer.setValid(false);
		Criterion username = Restrictions.eq("username", user);
		Criterion password = Restrictions.eq("password", pass);

		LogicalExpression andExp = Restrictions.and(username, password);
		cri.add(andExp);

		if (cri.list().isEmpty()) {
			customer.setValid(false);
		} else {
			System.out.println("ELSE");
			customer = (customers) cri.list().get(0);
			customer.setValid(true);
			return customer;
		}

		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<orderdetail> selectProduct(String id) {
		List<orderdetail> list = null;
		Session session = (Session) HibernateUtils.getSesstion();
		Criteria criteria = session.createCriteria(orderdetail.class);
		criteria.add(Restrictions.eq("customer.customerId", Integer.parseInt(id)));
		criteria.addOrder(Order.asc("order.orderId"));
		try {
			list = criteria.list();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error : " + e);
		}
		return list;
	}

	public List<orderdetail> selectProductByOrderId(String id, String customerId) {

		List<orderdetail> list = null;
		Session session = (Session) HibernateUtils.getSesstion();
		Criteria criteria = session.createCriteria(orderdetail.class);
		criteria.add(Restrictions.eq("customer.customerId", Integer.parseInt(customerId)));
		criteria.add(Restrictions.eq("order.orderId", Integer.parseInt(id)));
		criteria.addOrder(Order.asc("order.orderId"));
		/// criteria.add(Restrictions.and(lhs, rhs),Restrictions.and(lhs,
		/// rhs),Restrictions.or(lhs, rhs));
		list = criteria.list();
		for (orderdetail order : list) {
			System.out.println("OrderId :" + order.getOrder().getOrderId() + "\t" + order.getProduct().getProductName()
					+ "\t" + order.getProduct().getPrice() + "\t" + order.getOrder().getStatus());

		}

		return list;
	}

	public boolean updateResiveProduct(int idpro, int idorder, int idcustomer) {
		boolean chack = false;

		String sql = "UPDATE orderdetail SET statusCustomer = 'ได้รับสินค้าแล้ว' WHERE product_id = ? AND order_id = ? AND customer_id = ?";
		try {
			con = connect.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idpro);
			pstm.setInt(2, idorder);
			pstm.setInt(3, idcustomer);
			pstm.executeUpdate();
			con.close();
			chack = true;

		} catch (Exception e) {
			System.out.println("ERROR : " + e);
		}

		return chack;
	}

}
