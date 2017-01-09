package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static final SessionFactory sessionFactory;
	private static final ThreadLocal<Session>thredSession = new ThreadLocal<>();
	private static final ThreadLocal<Transaction>threadTransection = new ThreadLocal<>();
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable tx) {
			throw new ExceptionInInitializerError(tx);
		}
	}
	
	public static Session getSesstion() {
		Session session = (Session)thredSession.get();
		try {
			if(session == null){
				session = sessionFactory.openSession();
				thredSession.set(session);
			}
		} catch (HibernateException e) {
			throw e;
		}
		return session;
	}
	
	public static void closeSession() {
		try {
			Session session = (Session)thredSession.get();
			thredSession.set(null);
			if(session != null && session.isOpen())
				session.close();
		} catch (HibernateException e) {
			throw e;
		}
	}
	
	public static void beginTransaction() {
		Transaction tx = (Transaction)threadTransection.get();
		try {
			if(tx == null){
				tx = getSesstion().beginTransaction();
				threadTransection.set(tx);
			}
		} catch (HibernateException e) {
			throw e;
		}
	}
	
	public static void commitTransaction() {
		Transaction tx = (Transaction)threadTransection.get();
		try {
			if(tx != null && !tx.wasCommitted() && !tx.wasRolledBack()){
				tx.commit();
			}threadTransection.set(null);
		} catch (HibernateException e) {
			rollbackTransaction();
			throw e;
		}
	}
	
	public static void rollbackTransaction() {
		Transaction tx = (Transaction)threadTransection.get();
		try {
			if(tx != null && !tx.wasCommitted() && !tx.wasRolledBack()){
				tx.commit();
			}
		} catch (HibernateException e) {
			throw e;
		}finally {
			closeSession();
		}
	}
}
