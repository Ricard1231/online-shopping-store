package model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class UserDAO {
	public User saveInfo(User obUser) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(obUser);
		session.getTransaction().commit();
		return obUser;
	}

	public boolean checkLogin(String username, String password) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select username from User where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		String result = (String) query.uniqueResult();
		if (result != null) {
			return true;
		} else
			return false;
	}
	
	public boolean checkPin(String username, String pin) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select username from User where username = :username and pin = :pin");
		query.setParameter("username", username);
		query.setParameter("pin", pin);
		String result = (String) query.uniqueResult();
		if (result != null) {
			return true;
		} else return false;
	}
	
	public void changePass(String username, String password) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update password from User set password = :password where username = :username");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.executeUpdate();
		}
	
	public void addItem(String username, String iname) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update cart from User set cart = :cart where username = :username");
		query.setParameter("username", username);
		query.setParameter("cart", username);
		query.executeUpdate();
		Query query2 = session.createQuery("insert into Cart values(:unamecart, :itemname)");
		query2.setParameter("unamecart", username);
		query2.setParameter("itemname", iname);
		query2.executeUpdate();
	}
	}