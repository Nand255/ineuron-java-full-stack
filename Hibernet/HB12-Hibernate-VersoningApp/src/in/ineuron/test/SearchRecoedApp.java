package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class SearchRecoedApp {
	public static void main(String[] args) {
		Session session = null;
		MobileCustomer customer = null;
		Transaction transaction = null;
		Integer id = 1;
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				customer = session.get(MobileCustomer.class, id);
				System.out.println("Record before updation :: "+customer);
				
				transaction = session.beginTransaction();
				
				customer.setCallerTune("Esala cup namde...");
				session.save(customer);
				flag = true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("After updation :: "+customer);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
