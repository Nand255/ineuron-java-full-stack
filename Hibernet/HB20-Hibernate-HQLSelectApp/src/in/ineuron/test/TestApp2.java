package in.ineuron.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			//Prepare Query object to hold HQL
			Query<Product> query = session.createQuery("from in.ineuron.model.Product where pname IN(:prod1, :prod2)"); // select * from product;
			
			// set values to named parameters prod1, prod2
			query.setParameter("prod1", "hmt");			
			query.setParameter("prod2", "omegha");
			
			// Execute the Query (select * from Product where pname IN("hmt","omegha"))
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
