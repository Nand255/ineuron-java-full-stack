package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class DeleteApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			//Prepare Query object to hold HQL
			Query query = session.createQuery("Delete FROM in.ineuron.model.Product WHERE pid=:id"); 
			
			//set parameter values
			query.setParameter("id", 2);
			
			// Execute the Query
			count = query.executeUpdate();
			flag =  true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No. of Rows affected is :: "+count);
			} else {
				transaction.rollback();
				System.out.println("No. of Rows affected is :: "+count);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
