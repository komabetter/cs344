package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;

import model.customers;
import model.employee;
import model.order;
import model.orderemployeedetail;
import util.HibernateUtil;
import util.HibernateUtils;

public class orderDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Criteria cri = session.createCriteria(order.class);
	employee em = new employee();
	order or = new order();
	
	public void insert(){
		
		session.beginTransaction();
		or.setStatus("UnComplete");
		session.save(or);
		session.getTransaction().commit();
		
		
	}
	
	public List<orderemployeedetail> selectAllOrder() {

		List<orderemployeedetail> list = null;
		Session session = (Session) HibernateUtils.getSesstion();
		Criteria criteria = session.createCriteria(orderemployeedetail.class);
		criteria.addOrder(Order.asc("order.orderId"));
		list = criteria.list();
		

		return list;
	}
}
