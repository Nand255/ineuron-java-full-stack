package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Address;
import in.ineuron.model.StudentInfo;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			
			if (session != null) 
				transaction = session.beginTransaction();
			
			if (transaction != null) {
				
				Address address = new Address();
				address.setCountryName("IND");
				address.setStateName("Karnataka");
				address.setCityName("Benaluru");
				
				StudentInfo info = new StudentInfo();
				info.setSage(33);
				info.setSname("gandhi");
				info.setAddress(address);

				Address address1 = new Address();
				address1.setCountryName("IND");
				address1.setStateName("Gujarat");
				address1.setCityName("Gandhinagar");
				
				StudentInfo info1 = new StudentInfo();
				info1.setSage(20);
				info1.setSname("prince");
				info1.setAddress(address1);
				
				session.save(info);
				session.save(info1);

				flag = true;
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("");
			} else {
				transaction.rollback();
				System.out.println("");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}