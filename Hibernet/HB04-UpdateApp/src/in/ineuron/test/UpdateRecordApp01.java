package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateRecordApp01 {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) 
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				Student student = new Student();
				student.setSid(18);    			// Programmer should know that record with the id exist
				student.setSname("virat");
				student.setSaddress("INDIA");
				student.setSage(36);
				session.update(student);
				
				flag = true;
			}	
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object updated to database...");
			} else {
				transaction.rollback(); 
				System.out.println("Object not updated to database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
