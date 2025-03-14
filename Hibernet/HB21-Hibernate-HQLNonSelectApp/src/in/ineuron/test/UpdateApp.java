package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class UpdateApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		int count = 0;
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			//Prepare Query object to hold HQL
			Query query = session.createQuery("UPDATE in.ineuron.model.Product SET qty=qty+:newQty WHERE pname like : initailLatter"); 
			
			//set parameter values
			query.setParameter("newQty", 5);
			query.setParameter("initailLatter", "f%");
			
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
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
