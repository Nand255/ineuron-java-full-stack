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
		Integer id = null;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				Student student = new Student();

				student.setSname("Rohit");
				student.setSaddress("MI");
				student.setSage(39);
				
				id = (Integer) session.save(student); // use session.persist(student)
				flag = true;
			}	
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object inserted to database...");
			} else {
				transaction.rollback(); 
				System.out.println("Object not inserted to database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
