package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateRecordApp3 {
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
				
				student.setSaddress("rcb");
				// student object and table row(student table data) are in synchronization
				// no need to write update query it will be generated

				flag = true;
			}	
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object deleted from the database...");
			} else {
				transaction.rollback(); 
				System.out.println("Object not deleted from the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
