package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateRecordApp2 {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, 18);
		
			if(session != null) 
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				System.out.println(student);
				System.in.read();

				student.setSaddress("IND");
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
