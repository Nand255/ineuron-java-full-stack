package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class InsertRecoedApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String id = null;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				Student student = new Student();

				student.setSname("virat");
				student.setSaddress("RCB");
				student.setSage(28);
				
				id = (String) session.save(student); // use session.persist(student)
				flag = true;
			}	
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object inserted to database with the id :: "+id);
			} else {
				transaction.rollback(); 
				System.out.println("Object not inserted to database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
