package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsertRecoedApp {
	
	public static void main(String[] args) {
	
		Session session = null;
		Transaction transaction = null;
		Long id = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				transaction = session.beginTransaction();
				
				if(transaction != null) {
					InsurancePolicy policy = new InsurancePolicy();
					policy.setPname("Leevan suraksha");
					policy.setPtype("yearly");
					policy.setTenure(20);
					
					id = (Long)session.save(policy);
					flag = true;
				}
			}
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
