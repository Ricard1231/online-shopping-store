package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ItemDAO {
public ArrayList<Item> getInfo(String itemName) {
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Query query = session.createQuery("Select itemob.iname, itemob.iprice, itemob.idesc from Item itemob where itemob.iname = :iname");
	query.setParameter("iname", itemName);
	List<Object[]> list = query.list();
	ArrayList<Item> allResults = new ArrayList<Item>();
	Item item = new Item();
	for(Object[] data : list) {
		item.setIname((String) data[0]);
		item.setIprice((Double) data[1]);
		item.setIdesc((String) data[2]);
		allResults.add(item);
	}
	session.close();
	sessionFactory.close();
	return allResults;
	}

public ArrayList<Item> getInfoid(int id) {
	SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	Query query = session.createQuery("Select itemob.iname, itemob.iprice, itemob.idesc from Item itemob where itemob.idItem = :idItem");
	query.setParameter("idItem", id);
	List<Object[]> list = query.list();
	ArrayList<Item> allResults = new ArrayList<Item>();
	Item item = new Item();
	for(Object[] data : list) {
		item.setIname((String) data[0]);
		item.setIprice((Double) data[1]);
		item.setIdesc((String) data[2]);
		allResults.add(item);
	}
	session.close();
	sessionFactory.close();
	return allResults;
}
}
