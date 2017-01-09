package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import connect.connect;
import model.customers;
import model.employee;
import model.order;
import model.orderdetail;
import model.orderemployeedetail;
import util.HibernateUtil;
import util.HibernateUtils;

public class employeeDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Criteria cri = session.createCriteria(employee.class);
	employee employe = new employee();
	Connection con = null;
	PreparedStatement pstm = null;
	Result rs = null;

	public employee loginEmployee(String user, String pass) {
		employe.setValid(false);
		Criterion username = Restrictions.eq("username", user);
		Criterion password = Restrictions.eq("password", pass);
		LogicalExpression andExp = Restrictions.and(username, password);
		cri.add(andExp);

		if (cri.list().isEmpty()) {
			employe.setValid(false);
		} else {
			employe = (employee) cri.list().get(0);
			employe.setValid(true);
			return employe;
		}

		return employe;
	}

	public boolean saveEmployeeSend(int idem, int idor) {
		boolean check = false;

		String sql = "UPDATE orderemployeedetail SET employee_send = ? WHERE order_id = ?";

		try {
			con = connect.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idem);
			pstm.setInt(2, idor);
			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error " + e);
		}

		return check;
	}

	public boolean saveEmployeeResiver(int idem, int idor) {
		boolean check = false;

		String sql = "UPDATE orderemployeedetail SET employee_resive = ? WHERE order_id = ?";

		try {
			con = connect.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idem);
			pstm.setInt(2, idor);
			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error " + e);
		}

		return check;
	}

	public boolean UpdateOrder(int idOrder) {
		boolean check = false;

		String sql = "UPDATE orders SET `status`='complete' WHERE order_id = ?";

		try {
			con = connect.getConnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idOrder);
			pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error " + e);
		}

		return check;
	}
}
