package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import in.ineuron.model.Student;

public class XMLApp {
	public static void main(String[] args) {
		
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		int id = 7;
		
		try {
			configuration = new Configuration();
			configuration.configure(); // By default it will search for hibernate.cfg.xml
			
			// providing information about mapping file
			configuration.addAnnotatedClass(Student.class);
			
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Student student = session.get(Student.class, id);
			if(student != null) {
				System.out.println(student);
			} else {
				System.out.println("Record not available for given ID :: "+id);
			}
			
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
	}
}
