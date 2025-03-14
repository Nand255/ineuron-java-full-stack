package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class GetRecoedApp_load {
	public static void main(String[] args) {
		Session session = null;
		Integer id = 18;
		
		try {
			session = HibernateUtil.getSession();
		
			if(session != null) {
				Student student = session.load(Student.class, id);
				if(student != null) {
					System.out.println("STUDENT ID is        :: "+student.getSid());
					System.in.read();
					System.out.println("STUDENT NAME is      :: "+student.getSname());
					System.out.println("STUDENT AGE is       :: "+student.getSage());
					System.out.println("STUDENT ADDRESS is   :: "+student.getSaddress());
				} else {
					System.out.println("Record not found for the given id :: "+id);
				}
			} 
				
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
	}
}
