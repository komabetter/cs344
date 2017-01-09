package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.company;
import model.customers;
import model.orderdetail;
import util.HibernateUtil;
import util.HibernateUtils;

public class companyDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();
	Criteria cri = session.createCriteria(company.class);
	company com = new company();

	public company loginCompany(String user, String pass) {
		com.setValid(false);
		Criterion username = Restrictions.eq("username", user);
		Criterion password = Restrictions.eq("password", pass);
		LogicalExpression andExp = Restrictions.and(username, password);
		cri.add(andExp);

		if (cri.list().isEmpty()) {
			com.setValid(false);
		} else {
			System.out.println("ELSE");
			com = (company) cri.list().get(0);
			com.setValid(true);
			return com;
		}

		return com;
	}

	public List<orderdetail> selectProduct() {

		List<orderdetail> list = null;
		Session session = (Session) HibernateUtils.getSesstion();
		Criteria criteria = session.createCriteria(orderdetail.class);
		criteria.addOrder(Order.asc("order.orderId"));
		list = criteria.list();
		return list;
	}

	public List<orderdetail> selectProductByOrderId(String idorder) {

		List<orderdetail> list = null;
		Session session = (Session) HibernateUtils.getSesstion();
		Criteria criteria = session.createCriteria(orderdetail.class);
		criteria.add(Restrictions.eq("order.orderId", Integer.parseInt(idorder)));
		criteria.addOrder(Order.asc("order.orderId"));
		list = criteria.list();

		return list;
	}

}
