package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class InsertRecoedApp {
	
	public static void main(String[] args) {
	
		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				transaction = session.beginTransaction();
				
				if(transaction != null) {
					
					MobileCustomer customer = new MobileCustomer();
					customer.setCname("nand");
					customer.setMobileNo(9999888822L);
					customer.setCallerTune("gaya BGT..");
					
					id = (Integer)session.save(customer);
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
