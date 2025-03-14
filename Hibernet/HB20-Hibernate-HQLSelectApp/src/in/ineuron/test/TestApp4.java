package in.ineuron.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp4 {

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			//Prepare Query object to hold HQL
			Query<Product> query = session.createQuery("from in.ineuron.model.Product where pid=:id"); // select * from product;
			
			System.out.println("Enter the id of the product to be fetched :");
			int id = new Scanner(System.in).nextInt();
			
			// set values to named parameters 
			query.setParameter("id", id);
			
			// Execute the Query (select * from Product where pid= ? )
			List<Product> products = query.getResultList(); // it is recommended to use getResultList(); method 
			System.out.println(products.size());
			
			// process the list object
			if (!products.isEmpty()) {
				Product product = products.get(0);
				System.out.println(product);
			} else {
				System.out.println("Record not available for the given id :: "+id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
