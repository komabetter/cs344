package dao;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;

import model.employee;
import model.orderdetail;
import model.product;
import util.HibernateUtil;

public class orderDetailDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Criteria cri = session.createCriteria(employee.class);
	orderdetail orderDe = new orderdetail();
	product pro = new product();
	
}
