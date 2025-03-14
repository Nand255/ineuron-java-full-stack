package in.ineuron.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			//Prepare Query object to hold HQL
			Query<Product> query = session.createQuery("from in.ineuron.model.Product"); // select * from product;
			
			// Execute the Query
			List<Product> products = query.list();
			
			// process the list object
			products.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
