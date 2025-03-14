package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class clientApp1 {
	
	public static void main(String[] args) {
	
		Session session = null;
		Transaction transaction = null;
		Long id = 1L;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
		
			transaction = session.beginTransaction();
			
			InsurancePolicy policy = session.get(InsurancePolicy.class, id);
			System.out.println(policy);
			
			Thread.sleep(30000); // sleep for 30 seconds
			
			// now update operation
			policy.setTenure(25);
			flag = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag == true) {
				transaction.commit();
				System.out.println("Object inserted to database..."+id);
			} else {
				transaction.rollback(); 
				System.out.println("Object not inserted to database...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
