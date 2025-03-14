package in.ineuron.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class TestApp3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			//Prepare Query object to hold HQL
			Query<Object[]> query = session.createQuery("select pname, price, qty from in.ineuron.model.Product where pname IN(:prod1, :prod2)"); // select * from product;
			
			// set values to named parameters prod1, prod2
			query.setParameter("prod1", "hmt");			
			query.setParameter("prod2", "omegha");
			
			// Execute the Query (select * from Product where pname IN("hmt","omegha"))
//			List<Object[]> products = query.list();
			List<Object[]> products = query.getResultList(); // it is recommended to use getResultList(); method 
			
			// process the list object
			System.out.println("pname\tprice\tqty");
			products.forEach(row->{
				for (Object object : row) {
					System.out.print(object+"\t");
				}
				System.out.println();
			});
			
//			Query<Integer> query = session.createQuery("select price from in.ineuron.model.Product where pname IN(:prod1, :prod2)");
//			
//			query.setParameter("prod1", "hmt");			
//			query.setParameter("prod2", "omegha");
//			
//			List<Integer> products = query.list();
//			
//			System.out.println("price");
//			
//			products.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
